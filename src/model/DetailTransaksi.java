package model;

// Class Detail Transaksi
public class DetailTransaksi {
    private int idBarang;
    private int jumlah;
    private double subtotal;

    public DetailTransaksi(int idBarang, int jumlah, double subtotal) {
        this.idBarang = idBarang;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
