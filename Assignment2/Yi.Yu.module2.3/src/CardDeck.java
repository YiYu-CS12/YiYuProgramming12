import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardDeck {
    private LinkedList<Card> deck;

    public CardDeck() {
        deck = new LinkedList<>();
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for (Suit suit : Suit.values()) {
            for (int i = 0; i < ranks.length; i++) {
                deck.add(new Card(suit, ranks[i], values[i]));
            }
        }
    }

    // I was originally want to use random number to generate a random card from the deck
    // However the repeat card might happen, so I use the shuffle function in package Collections
    // Source: https://docs.oracle.com/javase/6/docs/api/java/util/Collections.html#shuffle(java.util.List)
    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public List<Card> pulling(int numberOfCards) {
        List<Card> hand = new LinkedList<>();
        for (int i = 0; i < numberOfCards; i++) {
            if (!deck.isEmpty()) {
                hand.add(deck.pop());
            }
        }
        return hand;
    }

}