package LatihanUASDDP2.Praktikum8;
// gudang inventori dapat menyimpan barang barang, elektronik dan funitur, 
// barang = kode baran, berat, stok, harg, dapat dimasukkan ke gudang
// satu gudang, satu jenis barang
// setiap gedung memiliki ama dan kapasitas barang

import java.util.UUID;

// abstract superclass
public abstract class Barang {

    protected String kode;
    protected int berat;
    protected int stok;
    protected int harga;
    protected String nama;

    public Barang(String i, int berat, int stok, int harga) {
        this.nama = i;
        this.berat = berat;
        this.harga = harga;
        this.stok = stok;
        this.kode = UUID.randomUUID().toString();
    }


    public int getBerat() {
        return this.berat;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getStok() {
        return this.stok;
    }

    public String getKode() {
        return this.kode;
    }

    public abstract String getName();
    public abstract String getJenis();

}
