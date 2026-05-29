package LatihanUASDDP2.Praktikum6;

public class PasianTidakDitemukanException extends Exception {
    public PasianTidakDitemukanException(String id) {
        super("Pasien dengan id " + id + " tidak ditemukan");
    }
}
