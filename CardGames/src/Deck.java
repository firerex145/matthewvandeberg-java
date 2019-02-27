import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int size;
    public Deck(String[] rank, String[] suit, int[] value) {
        for (int i = 0; i < suit.length * rank.length; i++) {
            deck.add(new Card(rank[i], suit[i], value[i]));
        }
        //shuffle();
    }
    public boolean isEmpty() {
        return deck.isEmpty();
    }
    public int size() {
        size = deck.size();
        return deck.size();
    }
    public String deal() {
        size -= 1;
        return deck.get(size).toString();
    }
}
