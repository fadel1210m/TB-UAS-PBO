# TB-UAS-PBO
Tugas Besar ini dibuat untuk memenuhi UAS Mata Kuliah Pemograman Berorientasi Objek
# Sistem Informasi Penjualan Toko ATK

Proyek ini merupakan implementasi **Sistem Informasi Penjualan Toko Alat Tulis Kantor (ATK)** berbasis **Java (console)** yang dikembangkan sebagai **Ujian Akhir Semester (UAS)** mata kuliah **Pemrograman Berorientasi Objek (PBO)**. Sistem ini dirancang untuk membantu proses pengelolaan data barang, pengendalian stok, serta transaksi penjualan secara terkomputerisasi dan terintegrasi dengan database.

---

## Deskripsi Singkat

Sistem ini mengatasi permasalahan pencatatan manual pada toko ATK dengan menyediakan fitur manajemen data barang dan transaksi penjualan. Seluruh data disimpan dalam database MySQL dan diakses menggunakan JDBC. Pendekatan **Pemrograman Berorientasi Objek** diterapkan melalui penggunaan class, object, interface, inheritance, dan exception handling.

---

## Fitur Utama

* Manajemen data barang (tambah, lihat, ubah, hapus)
* Penambahan jenis barang baru
* Penambahan stok barang (restock)
* Transaksi penjualan multi-item
* Perhitungan otomatis total harga dan kembalian
* Validasi stok dan input menu

---

## Teknologi yang Digunakan

* Java (Console Application)
* MySQL
* JDBC (Java Database Connectivity)

---

## Struktur Folder Proyek

```
penjualan-toko-atk/
│
├── src/
│   ├── database/
│   │   └── DatabaseConnection.java
│   │
│   ├── model/
│   │   ├── Pengguna.java
│   │   ├── Kasir.java
│   │   ├── Barang.java
│   │   ├── Transaksi.java
│   │   └── DetailTransaksi.java
│   │
│   ├── service/
│   │   ├── CRUDInterface.java
│   │   ├── BarangService.java
│   │   └── TransaksiService.java
│   │
│   └── main/
│       └── MainApp.java
│
├── database/
│   └── toko_atk.sql
│
│
├── lib/
│   └── mysql-connector-j-9.5.0.jar
│
└── README.md
```

---

## Cara Menjalankan Program

1. Import database MySQL menggunakan file `database/toko_atk.sql`
2. Pastikan MySQL server dalam keadaan aktif
3. Atur konfigurasi database (URL, username, password) pada file `DatabaseConnection.java`
4. Jalankan file `MainApp.java`
5. Gunakan menu pada console untuk mengelola barang dan melakukan transaksi

---

## Catatan Implementasi

* Data barang awal dapat dimasukkan langsung melalui database sebagai *seed data* untuk keperluan pengujian
* Sistem tetap menyediakan fitur input barang melalui program
* Seluruh transaksi dan perubahan stok tercatat secara otomatis di database

---

## Identitas Mahasiswa

Nama : Fadel Muhammad
NIM  : 2411522029
Mata Kuliah : Pemrograman Berorientasi Objek

---
