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
        shuffle();
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public String deal() {
        size -= 1;
        if (size == -1) {
            return null;
        }
        return deck.get(size).toString();
    }
    public String toString() {
        if (size == 0) {
            return null;
        }
        String temp = deck.get(0).toString();
        for (int i = 1; i < size; i ++) {
            temp += ", " + deck.get(i).toString();
        }
        return temp;
    }
    public void shuffle() {
        size = deck.size();
        for (int i = size - 1; i > 0; i--) {
            int random = (int)(Math.random() * i);
            Card temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }
}
