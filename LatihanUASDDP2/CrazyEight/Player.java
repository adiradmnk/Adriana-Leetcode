package LatihanUASDDP2.CrazyEight;

public class Player {
    private String name;
    private Hand hand; // palyer mempunyai hand jadi membuat hand 
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand(name);
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public Hand getHand() {
        return this.hand;
    }

    // method ngitung score
    public void hitungScore() {
        for (Card i : getHand().getCards()) {
            if (i.getRank() == 8) {
                this.score += 50;
            } else if (i.getRank() > 10) {
                this.score += 10;
            } else {
                this.score += i.getRank();
            }
        }
    }

}
