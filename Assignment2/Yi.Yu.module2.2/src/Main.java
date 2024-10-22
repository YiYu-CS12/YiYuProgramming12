import java.util.List;

public class Main {
    public static void main(String[] args) {
        CardDeck deckOfCards = new CardDeck();
        List<Card> hand = deckOfCards.pulling(7);

        System.out.println("Hand of 7 cards:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
}