package service;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// Service untuk mengelola data barang
public class BarangService implements CRUDInterface {

    Scanner input = new Scanner(System.in);

    // =======================
    // TAMBAH JENIS BARANG BARU (INSERT)
    // =======================
    @Override
    public void create() {
        try {
            System.out.print("Nama Barang: ");
            String nama = input.nextLine().toUpperCase();

            System.out.print("Harga: ");
            double harga = input.nextDouble();

            System.out.print("Stok Awal: ");
            int stok = input.nextInt();
            input.nextLine();

            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO barang (nama_barang, harga, stok) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setDouble(2, harga);
            ps.setInt(3, stok);
            ps.executeUpdate();

            System.out.println("Jenis barang baru berhasil ditambahkan.");

        } catch (Exception e) {
            System.out.println("Gagal menambahkan barang.");
        }
    }

    // =======================
    // TAMPILKAN DATA BARANG (SELECT)
    // =======================
    @Override
    public void read() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM barang");

            System.out.println("\n=== DATA BARANG ===");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_barang") + " | " +
                        rs.getString("nama_barang") + " | " +
                        rs.getDouble("harga") + " | " +
                        rs.getInt("stok")
                );
            }

        } catch (Exception e) {
            System.out.println("Gagal menampilkan data barang.");
        }
    }

    // =======================
    // UPDATE STOK (OVERWRITE)
    // =======================
    @Override
    public void update() {
        try {
            System.out.print("ID Barang: ");
            int id = input.nextInt();

            System.out.print("Stok Baru: ");
            int stokBaru = input.nextInt();
            input.nextLine();

            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE barang SET stok = ? WHERE id_barang = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stokBaru);
            ps.setInt(2, id);

            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Stok barang berhasil diperbarui.");
            } else {
                System.out.println("ID barang tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Gagal update stok.");
        }
    }

    // =======================
    // TAMBAH STOK (RESTOCK)
    // =======================
    public void tambahStok() {
        try {
            System.out.print("ID Barang: ");
            int id = input.nextInt();

            System.out.print("Jumlah Stok Tambahan: ");
            int tambahan = input.nextInt();
            input.nextLine();

            Connection conn = DatabaseConnection.getConnection();
            String sql = "UPDATE barang SET stok = stok + ? WHERE id_barang = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tambahan);
            ps.setInt(2, id);

            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Stok berhasil ditambahkan.");
            } else {
                System.out.println("ID barang tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Gagal menambahkan stok.");
        }
    }

    // =======================
    // HAPUS BARANG (DELETE)
    // =======================
    @Override
    public void delete() {
        try {
            System.out.print("ID Barang: ");
            int id = input.nextInt();
            input.nextLine();

            Connection conn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM barang WHERE id_barang = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Barang berhasil dihapus.");
            } else {
                System.out.println("ID barang tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Gagal menghapus barang.");
        }
    }
}
