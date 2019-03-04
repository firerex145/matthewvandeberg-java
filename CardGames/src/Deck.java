import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private int size;
    public Deck(String[] rank, String[] suit, int[] value) {
        for (int i = 0; i < rank.length; i++) {
            for(int j = 0; j < suit.length; j++) {
                deck.add(new Card(rank[i], suit[j], value[i]));
            }
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
    public String toString() {
        String temp = deck.get(0).toString();
        for (int i = 1; i < deck.size(); i ++) {
            temp += ", " + deck.get(i).toString();
        }
        return temp;
    }
}
