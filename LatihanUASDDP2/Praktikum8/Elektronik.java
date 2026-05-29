package LatihanUASDDP2.Praktikum8;

public class Elektronik extends Barang{
    private String name;

    Elektronik(String i, int berat, int stok, int harga){
        super(i, berat, stok, harga);
    }

    public String getJenis() {
        return "Elektronik";
    }

    public String getName() {
        return this.name;
    }
}
