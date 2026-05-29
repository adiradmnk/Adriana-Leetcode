package LatihanUASDDP2.SistemBurhan;
// jika saat proses impor CSV, ditemukan id atau judul media yang sudah terdaftar di dalam sistem.
public class DuplicateMediaException extends Exception {
    public DuplicateMediaException(){
        super("Terdapat error");
    }
}
