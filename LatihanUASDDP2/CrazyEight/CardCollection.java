package LatihanUASDDP2.CrazyEight;
import java.util.ArrayList;
// ini class untuk pile deck dan hands of cards yang mereka semua extend dari cardcollection
// ini tempat 
public class CardCollection {
    private String label; // nama 
    private ArrayList<Card> cards;

    public CardCollection(String name) {
        this.label = name;
        this.cards = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void addCard(Card card) {
        // method untuk menambahkan kartu ke dalam koleksi kartu
        cards.add(card);
    }

    public Card popCard() {
        Card lastCard = cards.getLast();
        cards.remove(cards.size() - 1);
        return lastCard;
    }


    public boolean isEmpty() {
        if (cards.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void shuffle() {
        java.util.Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public int getSize() {
        return cards.size();
    }

    public Card top() {
        return cards.getLast();
    }

    
}
