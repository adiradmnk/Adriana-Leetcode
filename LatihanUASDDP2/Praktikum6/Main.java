package LatihanUASDDP2.Praktikum6;

public class Main {
    public static void main(String[] args) {
        Pasien p1 = new Pasien("P001", "Budi Santoso", 34, "flu");
        Pasien p2 = new Pasien("P002", "Sari Dewi", 8, "demam");
        Pasien p3 = new Pasien("P003", "Hendra", 67, "hipertensi");
        System.out.println("[KLINIK] Pasien terdaftar: " + p1);
        System.out.println("[KLINIK] Pasien terdaftar: " + p2);
        System.out.println("[KLINIK] Pasien terdaftar: " + p3);

        Klinik klinik = new Klinik();
        // TODO 5a: daftarkan p1, p2, p3 (gunakan try-catch)
        try {
            klinik.daftarkanPasien(p1);
            klinik.daftarkanPasien(p2);
            klinik.daftarkanPasien(p3);
        } catch (IdDuplikatException e) {
            System.out.print("Perlu perbaikan: " + e.getMessage());
        }

        

        // TODO 5b: cari pasien ID "P002" — harus ditemukan
        try {
            Pasien n = klinik.cariPasien("P002");
            klinik.cariPasien("P999");
        } catch (PasianTidakDitemukanException e) {
            System.out.print("[ERROR]: " + e.getMessage());
        }

        // TODO 5: masukkan p1, p2, p3 ke antrian — tangani AntrianPenuhException
        // buat antrian
        AntrianDokter ad = new AntrianDokter("Adriana", 2);
        try {
            ad.tambahPasien(p1);
            ad.tambahPasien(p2);
            ad.tambahPasien(p3);
        } catch (AntrianPenuhException e) {
            System.out.print(e.getMessage());
        }

        // TODO 5b: printInfo() dan isi antrian — tangani AntrianPenuhException
        try {
            ad.printInfo();
        } catch (AntrianPenuhException e) {
            System.out.print(e.getMessage());
        }

        // TODO 5d: tambahkan resep untuk P001 (2 obat berhasil)
        try {
            klinik.tambahResepPasien("P001", "a", "2");
            klinik.tambahResepPasien("P001", "b", "2");
        } catch (BatasResepException e) {
            System.out.print(e.getMessage());
        } catch (PasianTidakDitemukanException e) {
            System.out.print(e.getMessage());
        }

        // TODO 5e: tambahkan resep ke-4 untuk P002 — harus triggerBatasResepException
        // gunakan multi-catch di sini!
        try {
            klinik.tambahResepPasien("P002", "a", "2");
            klinik.tambahResepPasien("P002", "b", "2");
            klinik.tambahResepPasien("P002", "c", "2");
            klinik.tambahResepPasien("P002", "d", "2");
        } catch (BatasResepException e) {
            System.out.print(e.getMessage());
        } catch (PasianTidakDitemukanException e) {
            System.out.print(e.getMessage());
        }

        // TODO 5f: cetak [SUMMARY]
        System.out.print("[SUMMARY] Total pasien terdaftar: " + klinik.getTotalPasien() + " | Total dalam antrian: " + ad.getJumlah());

    }
}