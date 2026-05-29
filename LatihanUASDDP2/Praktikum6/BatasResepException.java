package LatihanUASDDP2.Praktikum6;
public class BatasResepException extends Exception{

    public BatasResepException(String namaPasien, int batasMaksimal, String obatGagal) {
        System.out.printf("Batas maksimal resep untuk %s (maks: %d) tercapai. Obat %s tidak ditambahkan.", namaPasien, batasMaksimal, obatGagal);
    }


}
