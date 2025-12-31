package model;

// Subclass Kasir mewarisi Pengguna
public class Kasir extends Pengguna {

    private String idKasir;

    public Kasir(String idKasir, String nama) {
        super(nama);
        this.idKasir = idKasir;
    }

    public String getIdKasir() {
        return idKasir;
    }
}
