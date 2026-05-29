package LatihanUASDDP2.CrazyEight;
import java.util.ArrayList;

public class Card {
    // atribut dari sebuah kartu, sebuah kartu mempunyai suit dan rank 
    private String suit; // jenis kartu (hearts, diamonds, clubs, spades)
    private int rank; // nilai kartu (2-10, J, Q, K, A)

    // constuctor dari sebuah kartu
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        String rankString;
        if (this.rank == 11) {
            rankString = "J";
        } else if (this.rank == 12) {
            rankString = "Q";
        } else if (this.rank == 13) {
            rankString = "K";
        } else if (this.rank == 14) {
            rankString = "A";
        } else {
            rankString = Integer.toString(this.rank);
        }
        return rankString + " of " + this.suit;
    }


}
