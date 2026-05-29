package LatihanUASDDP2.CrazyEight.test;

import static org.junit.Assert.*;
import org.junit.Test;

import LatihanUASDDP2.CrazyEight.*;

public class CardCollectionTest {
    // ini inisialisasi situasi untuk dipakai di setiap test, lebih ke membuat objeknya, dan objek yang bergantung 
    private CardCollection collection;
    private Card kartu1;
    private Card kartu2;
    
    // ngetes constructor dan label 
    @Test
    public void testConstructorDanLabel() {
        collection = new CardCollection("Test Pile");
        kartu1 = new Card("Hearts", 5);
        kartu2 = new Card("Spades", 10);
        // Menguji apakah label nama kelas terpasang dengan benar saat objek dibuat
        assertEquals("Test Pile", collection.getLabel());
        assertTrue(collection.isEmpty());
        assertEquals(0, collection.getSize());
    }

    @Test
    public void testAddCard() {
        collection = new CardCollection("Test Pile");
        kartu1 = new Card("Hearts", 5);
        kartu2 = new Card("Spades", 10);
        // WHEN: Menambahkan satu kartu
        collection.addCard(kartu1);

        // THEN: Ukuran bertambah dan status kosong menjadi false
        assertEquals(1, collection.getSize());
        assertFalse(collection.isEmpty());
        assertEquals(kartu1, collection.top());
    }

    @Test
    public void testTop_MelihatKartuTanpaMenghapus() {
        collection = new CardCollection("Test Pile");
        kartu1 = new Card("Hearts", 5);
        kartu2 = new Card("Spades", 10);
        collection.addCard(kartu1);
        collection.addCard(kartu2);

        // WHEN: Memanggil fungsi top()
        Card kartuTeratas = collection.top();

        // THEN: Harus mengembalikan kartu terakhir yang dimasukkan (kartu2)
        assertEquals(kartu2, kartuTeratas);
        // PASTIKAN: Ukuran tumpukan tidak berkurang (tetap 2) karena top() hanya mengintip
        assertEquals(2, collection.getSize());
    }

    @Test
    public void testPopCard_MengambilDanMenghapusKartu() {
        collection = new CardCollection("Test Pile");
        kartu1 = new Card("Hearts", 5);
        kartu2 = new Card("Spades", 10);
        collection.addCard(kartu1);
        collection.addCard(kartu2);

        // WHEN: Melakukan popCard() pertama (mengambil kartu paling belakang/teratas)
        Card hasilPop1 = collection.popCard();
        
        // THEN: Kartu yang keluar harus kartu2, dan ukuran tumpukan tersisa 1
        assertEquals(kartu2, hasilPop1);
        assertEquals(1, collection.getSize());

        // WHEN: Melakukan popCard() kedua
        Card hasilPop2 = collection.popCard();

        // THEN: Kartu yang keluar kartu1, dan tumpukan menjadi kosong total
        assertEquals(kartu1, hasilPop2);
        assertTrue(collection.isEmpty());
    }

}
