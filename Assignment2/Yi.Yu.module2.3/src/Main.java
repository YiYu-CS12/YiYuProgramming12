import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck();
        List<Card> allCards = cardDeck.pulling(52);

        List<Card> hearts = new ArrayList<>();
        List<Card> diamonds = new ArrayList<>();
        List<Card> clubs = new ArrayList<>();
        List<Card> spades = new ArrayList<>();
        List<Card> faceCards = new ArrayList<>();
        List<Card> numberCards = new ArrayList<>();

        for (Card card : allCards) {
            switch (card.getSuit()) {
                case HEARTS:
                    hearts.add(card);
                    break;
                case DIAMONDS:
                    diamonds.add(card);
                    break;
                case CLUBS:
                    clubs.add(card);
                    break;
                case SPADES:
                    spades.add(card);
                    break;
            }
        }
        for (Card card : allCards) {
            if (card.getValue()>10){
                faceCards.add(card);
            }
            else{
                numberCards.add(card);
            }
        }

        Collections.sort(hearts);
        Collections.sort(diamonds);
        Collections.sort(clubs);
        Collections.sort(spades);
        Collections.sort(faceCards);
        Collections.sort(numberCards);

        System.out.println("Hearts:");
        for (Card card : hearts) {
            System.out.println(card);
        }

        System.out.println("\nDiamonds:");
        for (Card card : diamonds) {
            System.out.println(card);
        }

        System.out.println("\nClubs:");
        for (Card card : clubs) {
            System.out.println(card);
        }

        System.out.println("\nSpades:");
        for (Card card : spades) {
            System.out.println(card);
        }
        System.out.println("\nFace Cards:");
        for (Card card : faceCards) {
            System.out.println(card);
        }

        System.out.println("\nNumber Cards:");
        for (Card card : numberCards) {
            System.out.println(card);
        }
    }
}


