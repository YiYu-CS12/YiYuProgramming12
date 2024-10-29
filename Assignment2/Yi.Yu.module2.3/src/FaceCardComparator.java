import java.util.Comparator;

public class FaceCardComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        boolean c1IsFaceCard = isFaceCard(c1);
        boolean c2IsFaceCard = isFaceCard(c2);

        if (c1IsFaceCard && !c2IsFaceCard) {
            return -1;  // c1 is face, c2 not
        } else if (!c1IsFaceCard && c2IsFaceCard) {
            return 1;  // c1 not face, c2 is
        } else {
            return 0;  // Cards are both face or both not face
        }
    }

    private boolean isFaceCard(Card card) {
        String rank = card.getRank();
        return rank.equals("Jack") || rank.equals("Queen") || rank.equals("King");
    }
}