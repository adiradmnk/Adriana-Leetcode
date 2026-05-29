package LatihanUASDDP2.Praktikum6;

import java.util.ArrayList;
public class Klinik {
    private ArrayList<Pasien> daftarPasien = new ArrayList<>();

    // TODO 3: daftarkanPasien — lempar IdDuplikatException jika ID sudah ada
    public void daftarkanPasien(Pasien p) throws IdDuplikatException {
        for (Pasien i : daftarPasien) {
            if (i.getId().equals(p.getId())) {
                throw new IdDuplikatException(p.getId());
            }
        }
        System.out.println("[KLINIK] Pasien terdaftar: " + p);
        daftarPasien.add(p);
    }

    // TODO 4: cariPasien — lempar PasienTidakDitemukanException jika tidak ada
    public Pasien cariPasien(String id) throws PasianTidakDitemukanException{
        Pasien N = null;
        for (Pasien i : daftarPasien) {
            if (i.getId().equals(id)) {
                N =  i;
            }
        }
        if (N == null) {
            throw new PasianTidakDitemukanException(id);
        } 
        return N;
    }

    public void tambahResepPasien(String idPasien, String obat, String frekuensi) throws PasianTidakDitemukanException, BatasResepException{
        try {
            Pasien p = cariPasien(idPasien);
            p.tambahResep(obat, frekuensi);
        } catch (PasianTidakDitemukanException e) {
            System.out.print("[ERROR]: " + e.getMessage());
        } catch (BatasResepException e) {
            System.out.print("[ERROR]: " + e.getMessage());
        }
    }

    public int getTotalPasien() { 
        return daftarPasien.size(); 
    }
}
