package LatihanUASDDP2.Praktikum6;

public class Pasien {
    // deklarasikan semua instance variable
    private String id;
    private String nama;
    private int umur;
    private String penyakit;
    private String[] resep; // obat apa saja 
    private String[] frekuensi; // frekuensi setiap obat 
    private int jumlahResep;
    // konstruktor
    public Pasien(String id, String nama, int umur, String penyakit) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.penyakit = penyakit;
        this.resep = new String[3];
        this.frekuensi = new String[3];
        this.jumlahResep = 0;
    }

    public void tambahResep(String namaObat, String frek) throws BatasResepException {
        if (this.jumlahResep >= resep.length) {
            throw new BatasResepException(this.nama, resep.length, namaObat);
        } else {
            resep[jumlahResep] = namaObat;
            frekuensi[jumlahResep] = frek;
            jumlahResep++;
        }
    }

    public void printResep() {
        if (jumlahResep == 0) {
            System.out.print("Belum ada resep yang ditambahkan");
        } else {
            System.out.print("[RESEP] Nama: ");
            for (int i = 0; i <= jumlahResep; i++) {
                System.out.printf("%s (%sx sehari)\n", resep[i], frekuensi[i]);
            }
        }
    }
    // getter semua field, setter untuk penyakit dan umur
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }
    // override toString()
    @Override
    public String toString() {
        return nama + " (ID: " + id + ", umur: " + umur + ", penyakit: " + penyakit +
        ")";
    }
}




