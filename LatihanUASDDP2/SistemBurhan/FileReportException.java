package LatihanUASDDP2.SistemBurhan;
// kegagalan baca-tulis file (IOException) atau kesalahan format baris dokumen.
public class FileReportException extends Exception{
    public FileReportException() {
        super("Terdapat error");
    }
}
