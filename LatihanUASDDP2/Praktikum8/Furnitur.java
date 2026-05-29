package LatihanUASDDP2.Praktikum8;

public class Furnitur extends Barang{
    private String name;

    Furnitur(String i, int berat, int stok, int harga){
        super(i, berat, stok, harga);
    }

    public String getJenis() {
        return "Furnitur";
    }

    public String getName() {
        return this.name;
    }
}
