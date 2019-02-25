public class CardTester {
    public static void main(String[] args) {
        Card card1 = new Card("5", "spades", 5);
        Card card2 = new Card("5", "spades", 5);
        Card card3 = new Card("7", "hearts", 7);

        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());
        System.out.println();

        System.out.println("card1 equals card2: " + card1.equals(card2));
        System.out.println("card1 equals card3: " + card1.equals(card3));
        System.out.println("card2 equals card3: " + card2.equals(card3));
    }
}
