package LatihanUASDDP2;
// ini some rd game ace rank higher than kings odify compare to to implement this orfering 
public class Card {

    private final int rank;
    private final int suit;
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};
        public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
    public int compareTo(Card that) {
        if (this.rank == 1 && that.rank == 13) {
            return - 1;
        }
        if (this.rank == 13 && that.rank == 1) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }
}

// Pada chapter 13, pada class Deck digunakan primitive array private Card[] cards;
// Sementara pada class Pile, digunakan ArrayList, private ArrayList<Card> cards;
// Bagaimana menurut anda, apakah hal ini cocok atau tidak xkonsisten? Jelaskan!
// jadi untuk deck yang bersifat sizenya tetap, tpai tidak cocok 

// crazy eight cocok untuk menggunakan 
// association itu uses a, aggregation dan composisiton itu has a
