package LatihanUASDDP2.Praktikum5;
import java.util.Scanner;

// superclass untuk pembayaran 
class Pembayaran {
    public double hitungTotalBelanja(double totalBelanja) {
        return totalBelanja;
    }

    public String namaMetodePembayaran() {
        return "Metode Pembayaran";
    }

}

// class metode pembayaran utnuk tunai
class Tunai extends Pembayaran {
    // gak ada biaya tambahan 
    public String namaMetodePembayaran() {
        return "Tunai";
    }

    public double hitungTotalBelanja(double totalBelanja) {
        return totalBelanja;
    }
}

// metode pembayarna utnuk kartu kredit
class KartuKredit extends Pembayaran {
 // biaya admin 2 persen dari total belanja
    public String namaMetodePembayaran() {
        return "Kartu Kredit";
    }

    public double hitungTotalBelanja(double totalBelanja) {
        double admin = totalBelanja * 0.2;
        return totalBelanja + admin;
    }
}

// metode pembayaran untuk e wallet
class EWallet extends Pembayaran {
 // diskon 5% dari total belanja 
    public String namaMetodePembayaran() {
        return "E-wallet";
    }

    public double hitungTotalBelanja(double totalBelanja) {
        double diskon = totalBelanja *0.5;
        return totalBelanja + diskon;
    }
}

// ini main method nya 
public class SistemKasir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalHarga = 0;
        int jumlahBarang = 0;
        boolean input_0 = true;
        while (input_0) {
            System.out.printf("Masukkan harga barang %d (ketik 0 untuk selesai):", jumlahBarang);
            int harga = sc.nextInt();
            if (harga == 0) {
                input_0 = false;
            }
            totalHarga += harga;
            jumlahBarang++;
        }

        // minta input metode pembayaran
        System.out.print("\nPilih metode pembayaran: ");
        System.out.print("\n1. Tunai\n" + //
                           "2. Kartu Kredit\n" + //
                           "3. E-Wallet ");
        System.out.print("\nPilihan: ");
        int pilihan = sc.nextInt();

        Pembayaran n;
        if (pilihan == 1) {
            n = new Tunai();
        } else if (pilihan == 2) {
            n = new KartuKredit();
        } else {
            n = new EWallet();
        }

        System.out.print("\nTotal Belanja     : " + totalHarga);
        System.out.print("\nMetode Pembayaran : " + n.namaMetodePembayaran());
        System.out.print("\nTotal Bayar       : " + n.hitungTotalBelanja(totalHarga));
    }
}