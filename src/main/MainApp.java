package main;

import model.Kasir;
import service.BarangService;
import service.TransaksiService;

import java.util.Scanner;

// Main class
public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BarangService barangService = new BarangService();
        TransaksiService transaksiService = new TransaksiService();

        Kasir kasir = new Kasir("KSR01", "Admin");

        int menu;
        do {
            System.out.println("\n=== SISTEM PENJUALAN TOKO ATK ===");
            System.out.println("Kasir: " + kasir.getNama());
            System.out.println("1. Kelola Barang");
            System.out.println("2. Transaksi Penjualan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    int pilihBarang;
                    do {
                        System.out.println("\n=== MENU BARANG ===");
                        System.out.println("1. Tambah Jenis Barang Baru");
                        System.out.println("2. Lihat Data Barang");
                        System.out.println("3. Tambah Stok Barang");
                        System.out.println("4. Update Stok (Overwrite)");
                        System.out.println("5. Hapus Barang");
                        System.out.println("0. Kembali");
                        System.out.print("Pilih: ");

                        pilihBarang = input.nextInt();
                        input.nextLine();

                        switch (pilihBarang) {
                            case 1:
                                barangService.create();
                                break;
                            case 2:
                                barangService.read();
                                break;
                            case 3:
                                barangService.tambahStok();
                                break;
                            case 4:
                                barangService.update();
                                break;
                            case 5:
                                barangService.delete();
                                break;
                        }
                    } while (pilihBarang != 0);
                    break;

                case 2:
                    transaksiService.transaksiBaru();
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (menu != 0);
    }
}
