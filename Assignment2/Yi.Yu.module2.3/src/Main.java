import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        deck.add(new Card(Suit.HEARTS, "10", 10));
        deck.add(new Card(Suit.DIAMONDS, "Jack", 11));
        deck.add(new Card(Suit.CLUBS, "3", 3));
        deck.add(new Card(Suit.SPADES, "Queen", 12));
        deck.add(new Card(Suit.HEARTS, "King", 13));
        deck.add(new Card(Suit.DIAMONDS, "Ace", 14));

        System.out.println("Original deck:");
        for (Card card : deck) {
            System.out.println(card);
        }

        Collections.sort(deck, new SuitComparator());
        System.out.println("\nSorted by Suit:");
        for (Card card : deck) {
            System.out.println(card);
        }

        Collections.sort(deck, new FaceCardComparator());
        System.out.println("\nSorted by Face Card:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}


