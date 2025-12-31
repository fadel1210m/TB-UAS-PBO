package model;

import java.time.LocalDate;

// Class Transaksi
public class Transaksi {
    private int idTransaksi;
    private LocalDate tanggal;
    private double total;
    private double bayar;
    private double kembalian;

    public Transaksi(LocalDate tanggal, double total, double bayar, double kembalian) {
        this.tanggal = tanggal;
        this.total = total;
        this.bayar = bayar;
        this.kembalian = kembalian;
    }

    public double getTotal() {
        return total;
    }
}
