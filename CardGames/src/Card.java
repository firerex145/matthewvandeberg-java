public class Card {
    private String rank;
    private String suit;
    private int value;

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(Card otherCard) {
        return rank.equals(otherCard.getRank()) && suit.equals(otherCard.getSuit()) && value == otherCard.getValue();
    }

    public String toString() {
        return rank + " of " + suit + " (point value = " + value + ")";
    }
}
