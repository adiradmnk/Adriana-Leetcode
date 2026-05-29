package LatihanUASDDP2.Praktikum6;

public class AntrianPenuhException extends Exception{
    public AntrianPenuhException() {
        super( "Antrian dokter umum penuh. Pasien Hendra tidak dapat ditambahkan.");
    }

    public AntrianPenuhException(String i) {
        super ("Antrian sudah penuh");
    }
}
