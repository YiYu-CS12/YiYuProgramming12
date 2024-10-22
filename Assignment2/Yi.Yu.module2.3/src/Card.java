public class Card implements Comparable<Card>{
    private Suit suit;
    private String rank;
    private int value;

    public Card(Suit suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card o) {
        if(this.value > o.value){
            return 1;
        }
        else if(this.value < o.value){
            return -1;
        }
        return 0;
    }
}