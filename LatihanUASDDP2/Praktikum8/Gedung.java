package LatihanUASDDP2.Praktikum8;
// generic class gudang 

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;

public class Gedung<T extends Barang> {
    // atribut gudang dan apasitas gudang
    private ArrayList<T> entities;
    private int Kapasitas;
    private T jenisBarang;

    public Gedung() {
        this.entities = new ArrayList<T>();
        this.Kapasitas = Kapasitas;
        this.jenisBarang = jenisBarang;
    }

    public int getKapasitas() {
        return this.Kapasitas;
    }

    public T getJenisBarang() {
        return this.jenisBarang;
    }

    public ArrayList<T> getEntities() {
        return this.entities;
    }

    public void tambahBarang(T barang) {
        // validasi apakah barang sudah ada di dalam gudang atau belum
        sudahAda(barang);

        if (entities.size() >= getKapasitas()) {
            System.out.print("gagal menambahkan barang kapasitas sudah penuh");
        } else {
            entities.add(barang);
        }
    }

    public boolean sudahAda(T barang) {
        return entities.stream().anyMatch(x -> x == barang);
    }

    // fungsi cari barang
    public void cariBarang(String i) {
        List<T> n = entities.stream()
                                      .filter(x -> x.getName().toLowerCase().contains(i))
                                      .collect(Collectors.toList());
        System.out.println("Barang yang cocok:");                              
        int counter = 1;
        for (T m : n) {
            System.out.println(counter + ". " + m.getName());
            counter++;
        }
    }
}
