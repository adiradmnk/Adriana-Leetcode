package LatihanUASDDP2.Praktikum6;

public class AntrianDokter {
    private String namaDokter;
    private String[] antrian;
    private int jumlah;
    private int jumlahAntrian;

    public AntrianDokter(String nama, int jumlahAntrian) {
        this.antrian = new String[jumlahAntrian];
        this.namaDokter = nama;
        this.jumlahAntrian = jumlahAntrian;
        this.jumlah = jumlahTerisi(); // awal antrian sekarang 0
    }

    public int jumlahTerisi() {
        int count = 0;
        for (String i : antrian) {
            if (i != null) {
                count++;
            }
        }
        return count;
    }

    public void tambahPasien(Pasien p) throws AntrianPenuhException {
        if (jumlah < jumlahAntrian) {
            antrian[jumlah] = p.getNama();
            System.out.print("[ANTRIAN]");
        } else {
            throw new AntrianPenuhException();
        }
    }

    public int getSlotTersedia() {
        return jumlahAntrian - jumlah;
    }
    public int getJumlah() {
        return this.jumlahAntrian;
    }

    public void printInfo() throws AntrianPenuhException {
        System.out.printf("\n[ANTRIAN] %s -- slot tersedia: %d", this.namaDokter, getSlotTersedia());
        if (getSlotTersedia() == 0) {
            throw new AntrianPenuhException("ok");
        }
    }
}
