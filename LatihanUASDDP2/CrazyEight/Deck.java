package LatihanUASDDP2.CrazyEight;
import java.util.ArrayList;

public class Deck extends CardCollection{
    private String name;
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private Integer[] ranks = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    // ini untuk deck yang kosong
    public Deck(String name) {
        super(name);
        this.name = name;
        fiftyTwoCards();
    }

    public void fiftyTwoCards() {
        ArrayList<Card> m = new ArrayList<Card>();
        for (String i : suits) {
            for (int n : ranks) {
                Card k = new Card(i, n);
                this.addCard(k);
            }
        }
    }

    public String getName() {
        return name;
    }





}
