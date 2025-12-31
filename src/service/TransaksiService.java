package service;

import database.DatabaseConnection;
import model.DetailTransaksi;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Service transaksi penjualan
public class TransaksiService {

    Scanner input = new Scanner(System.in);
    ArrayList<DetailTransaksi> detailList = new ArrayList<>();

    public void transaksiBaru() {
        try {
            double total = 0;
            char lanjut;

            do {
                System.out.print("ID Barang: ");
                int idBarang = input.nextInt();

                System.out.print("Jumlah: ");
                int jumlah = input.nextInt();
                input.nextLine();

                Connection conn = DatabaseConnection.getConnection();
                ResultSet rs = conn.createStatement()
                        .executeQuery("SELECT harga, stok FROM barang WHERE id_barang=" + idBarang);

                if (rs.next()) {
                    double harga = rs.getDouble("harga");
                    int stok = rs.getInt("stok");

                    if (jumlah > stok) {
                        System.out.println("Stok tidak cukup!");
                        return;
                    }

                    double subtotal = harga * jumlah;
                    total += subtotal;

                    detailList.add(new DetailTransaksi(idBarang, jumlah, subtotal));

                    conn.createStatement()
                            .executeUpdate("UPDATE barang SET stok=stok-" + jumlah +
                                    " WHERE id_barang=" + idBarang);
                }

                System.out.print("Tambah barang lain? (y/n): ");
                lanjut = input.nextLine().charAt(0);

            } while (lanjut == 'y');

            // Diskon
            double diskon = (total > 100000) ? total * 0.1 : 0;
            total -= diskon;

            System.out.println("Total Bayar: " + total);
            System.out.print("Uang Bayar: ");
            double bayar = input.nextDouble();
            input.nextLine();

            double kembalian = bayar - total;

            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO transaksi (tanggal, total, bayar, kembalian) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setDouble(2, total);
            ps.setDouble(3, bayar);
            ps.setDouble(4, kembalian);
            ps.executeUpdate();

            ResultSet rsKey = ps.getGeneratedKeys();
            rsKey.next();
            int idTransaksi = rsKey.getInt(1);

            for (DetailTransaksi dt : detailList) {
                PreparedStatement psDetail = conn.prepareStatement(
                        "INSERT INTO detail_transaksi (id_transaksi, id_barang, jumlah, subtotal) VALUES (?, ?, ?, ?)");
                psDetail.setInt(1, idTransaksi);
                psDetail.setInt(2, dt.getIdBarang());
                psDetail.setInt(3, dt.getJumlah());
                psDetail.setDouble(4, dt.getSubtotal());
                psDetail.executeUpdate();
            }

            System.out.println("Transaksi berhasil disimpan.");
            System.out.println("Kembalian: " + kembalian);

        } catch (Exception e) {
            System.out.println("Transaksi gagal.");
        }
    }
}
