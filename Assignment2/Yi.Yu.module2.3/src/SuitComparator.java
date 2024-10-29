import java.util.Comparator;

class SuitComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        return c1.getSuit().compareTo(c2.getSuit());
    }
}