package LatihanUASDDP2.CrazyEight;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.print("===== Selamat datang ke Crazy Eight =====");
        boolean loop_is = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();

        while (loop_is) {
            System.out.print("\nMasukkan berapa banyak player yang main: ");
            int jumlahPlayer = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= jumlahPlayer; i++) {
                System.out.printf("Masukkan nama player ke-%d: ", i);
                String k = sc.nextLine();
                names.add(k);
            }

            System.out.print("Masukkan jumlah kartu per player: ");
            int cardSize = sc.nextInt();
            sc.nextLine();

            Eights play = new Eights(names, cardSize);
            play.Play();

            loop_is = false;


        }

        // selesai
        System.out.print("Terima kasih sudah main crazy Eights");
        System.exit(0);

    }

}
