package LatihanUASDDP2.CrazyEight;
import java.util.ArrayList;
import java.util.Scanner;

public class Eights {
    private ArrayList<Player> players;
    private Deck deck;
    private Hand drawpile; 
    private Hand discardpile; 
    private int currentPlayerIndex; 
    private int playerSize;
    private ArrayList<String> names;
    private int cardSize;
    private Scanner sc;
    private boolean eight = false;
    private Card syaratEight;

    public Eights(ArrayList<String> names, int cardSize) {
        this.names = names; 
        this.players = createPlayers(); 
        this.drawpile = new Hand("Draw Pile"); 
        this.discardpile = new Hand("Discard Pile");
        this.playerSize = this.names.size();
        this.deck = new Deck("deck");
        this.cardSize = cardSize;
        this.sc = new Scanner(System.in);
        this.currentPlayerIndex = 0;
    }

    public ArrayList<Player> createPlayers() { 
        ArrayList<Player> k = new ArrayList<Player>();
        for (String i : this.names) {
            Player n = new Player(i);
            k.add(n);
        }
        return k;
    }

    public void Play() {
        System.out.println("======= Permainan Crazy Eight Dimulai!!! ========");
        deck.shuffle();

        dealPlayer();

        Card atas = deck.popCard();
        if (atas.getRank() == 8) {
            deck.shuffle();
            atas = deck.popCard();
        }
        discardpile.addCard(atas);

        // Kuras deck ke drawpile secara bersih
        while (!deck.isEmpty()) {
            drawpile.addCard(deck.popCard());
        }

        // KUNCI 1: Menggunakan allMatch agar langsung berhenti saat kartu salah satu player = 0
        while (players.stream().allMatch(x -> x.getHand().getSize() > 0)) {
            System.out.printf("\n------ Giliran %s ------", getCurrentPlayer().getName());
            System.out.println("\nKartu di meja: " + discardpile.top()); // menunjukkan kartu yang di atas meja 
            System.out.println("Kartu di tangan kamu: " + getCurrentPlayer().getHand().getCards()); // nunjukkin kartu. yang ada di tangan aku sekarang 

            if (eight == true) { // kalau status eight itu ada, dan kita haru memenuhi nya 
                System.out.println("[EFEK ANGKA 8] Kamu harus mengeluarkan kartu sesuai syarat: " + syaratEight.toString());
                boolean ada = getCurrentPlayer().getHand().getCards().stream().anyMatch(card -> EightMatches(card, syaratEight)); // true kalau ad akartu yang match, maka pencarian apakah ada sesuai dengan syarat 
                if (ada == true) { // kalau ada kartunya 
                    // ambil kartu yang sesuai dengan tobooeal ada 
                    Card n = getCurrentPlayer().getHand().getCards().stream().filter(card -> EightMatches(card, syaratEight)).findFirst().orElse(null); 
                    int m = getCurrentPlayer().getHand().getCards().indexOf(n); // ambil indexnya 
                    getCurrentPlayer().getHand().getCards().remove(m); // hapus dari tangan player 
                    discardpile.addCard(n); // tambahin ke discard pile 
                    eight = false;  // eight jaid false 
                } else { // kalau gk ad akartu yang cocok 
                    drawCard(); // draw card sampai cocok 
                    eight = false; // eight jadi salah 
                }   
            } else { // ini kalau kartu sebelumnya bukan aight 
                boolean ada = getCurrentPlayer().getHand().getCards().stream().anyMatch(card -> cardMatches(card, discardpile.top())); // necek apa kah ada yagn cocok denhan
                if (ada == true) { 
                    Card n = getCurrentPlayer().getHand().getCards().stream().filter(card -> cardMatches(card, discardpile.top())).findFirst().orElse(null);
                    
                    if (n.getRank() == 8) { // kalau yang ada adalah eight, maka di 
                        eight = true; // eight jadi true 
                        System.out.println("\nKamu mengeluarkan Angka 8! Tentukan syarat pemain selanjutnya.");
                        System.out.print("Masukkan nomor rank (1-13): ");
                        int rank = sc.nextInt();
                        sc.nextLine(); 

                        System.out.print("Masukkan nama suit (Hearts/Diamonds/Clubs/Spades): ");
                        String suit = sc.nextLine();

                        syaratEight = new Card(suit, rank); /// isi syarat eight 
                    }
                    
                    int m = getCurrentPlayer().getHand().getCards().indexOf(n); // ambil index yang ada di hand player 
                    getCurrentPlayer().getHand().getCards().remove(m);  // remove dari handnya player 
                    discardpile.addCard(n); // teru straroh di discard pile 

                } else { // kalau tidak ada kartu yang cocok 
                    System.out.println("\nTidak ada kartu cocok! Menarik kartu dari tumpukan..."); // print bilang gk ada kartu yang cocok 
                    
                    // Ambil kartu teratas drawpile SEBELUM drawCard memprosesnya, untuk memastikan diatuh gk null 
                    Card topSebelumDraw = drawpile.isEmpty() ? null : drawpile.top(); 
                    
                    drawCard(); // ambil kartu di drawcard sebelum memprosesnya 
                    
                    // KUNCI 2: Hanya minta input jikalau kartu yang BARU SAJA ditarik adalah angka 8 dan langsung dibuang ke meja
                    if (topSebelumDraw != null && topSebelumDraw.getRank() == 8 && discardpile.top() == topSebelumDraw) { 
                        eight = true; 
                        System.out.println("\nKamu menarik Angka 8 dan otomatis terbuang ke meja! Tentukan syarat pemain selanjutnya.");
                        System.out.print("Masukkan nomor rank (1-13): ");
                        int rank = sc.nextInt();
                        sc.nextLine(); 

                        System.out.print("Masukkan nama suit (Hearts/Diamonds/Clubs/Spades): ");
                        String suit = sc.nextLine();

                        syaratEight = new Card(suit, rank);
                    }
                }
            }

            // Perputaran giliran menggunakan modulus
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

            System.out.print("\nTekan Enter untuk melanjutkan..."); // ini utnuk lanjut atau gk 
            sc.nextLine();
        }

        // AKHIR GAME: Hitung score akhir
        players.forEach(Player::hitungScore);

        // Cari siapa yang kartunya habis total (0)
        Player menang = players.stream()
                               .filter(x -> x.getHand().getSize() == 0)
                               .findFirst()
                               .orElse(null);

        System.out.println("\n======= PERMAINAN BERHASIL SELESAI =======");

        // kalau menang null, berarti pemenangnya yang scorenya npaling rendah 
        if (menang == null) { 
            System.out.println("Permainan macet! Tidak ada sisa kartu cocok di tumpukan.");
            menang = players.get(0);
            for (Player p : players) {
                if (p.getScore() < menang.getScore()) {
                    menang = p;
                }
            }
            System.out.println("Pemenang ditentukan berdasarkan total poin kartu TERENDAH di tangan.");
        }

        System.out.println("PEMENANGNYA ADALAH: " + menang.getName() + " dengan kartu habis!");
    }

    // Fungsi drawCard yang aman tanpa penumpukan kartu gaib removeLast
    public void drawCard() {
        if (drawpile.isEmpty()) { // kalau draw card empty berarti di reshuffle 
            reshuffle();
        }

        if (drawpile.isEmpty()) { // ini kalau udah di reshuffle dan benar benar abis maka ada pesannya 
            System.out.println("Tumpukan benar-benar habis! Tidak ada kartu lagi untuk diambil.");
            return;
        }

        Card n = drawpile.popCard(); // mengambil kartu drawpile paling atas, apus dari draw pile

        // kalau kartunya cocok dengan discardpile atas 
        if (cardMatches(n, discardpile.top())) {
            System.out.println(getCurrentPlayer().getName() + " menarik kartu " + n + " dan LANGSUNG COCOK dibuang ke meja."); 
            discardpile.addCard(n); // tambahin ke discard pile 
        } else {  // kalau tidak cocok 
            getCurrentPlayer().getHand().addCard(n); // tambahin ke tangan 
            System.out.println(getCurrentPlayer().getName() + " menarik kartu: " + n + " (Tidak cocok, masuk ke tangan)");
            drawCard(); // rekursi 
        }
    }

    public void reshuffle() { // ini ngocok 
        Card d = discardpile.popCard(); // ambil discard pile paling atas 

        while (!discardpile.isEmpty()) { // selama discard pile gk kosong 
            Card n = discardpile.popCard(); // ambil
            drawpile.addCard(n); // taroh 
        }

        discardpile.addCard(d); // tambah sisa discard pile di discard pile 
        drawpile.shuffle(); // shuffle untuk draw pilrnya 
        System.out.println("-> [INFO] Tumpukan ambil kosong. Discard pile telah dikocok ulang menjadi Draw pile.");
    }

    public Player getCurrentPlayer() { // ambil palyer sekarang 
        return players.get(currentPlayerIndex);
    }

    public void dealPlayer(){ // ngebagiin ke player 
        for (int z = 1; z <= cardSize; z++) {
            for (Player i : players) {
                Hand n = i.getHand();
                Card m = deck.popCard();
                n.addCard(m);
            }
        }
    }

    public boolean cardMatches(Card playerCard, Card discardpile) {
        if (playerCard.getRank() == discardpile.getRank()) return true;
        if (playerCard.getSuit().equals(discardpile.getSuit())) return true;
        if (playerCard.getRank() == 8) return true;
        return false;
    }

    public boolean EightMatches(Card playerCard, Card discardpile) {
        if ((playerCard.getRank() == discardpile.getRank()) && (playerCard.getSuit().equals(discardpile.getSuit()))) {
            return true;
        }
        if (playerCard.getRank() == 8) return true;
        return false;
    }
}