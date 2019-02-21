public class Client {
    public static void main(String[] args) {
        Sandwich club = new Sandwich("Club Sandwich", 2.75);
        Sandwich cheese = new Sandwich("Cheeseburger", 2.75);

        Salad cole = new Salad("Cole Slaw", 1.25);
        Salad spin = new Salad("Spinach Salad", 1.25);

        Drink cap = new Drink("Cappuccino", 3.50);
        Drink soda = new Drink("Orange Soda", 1.25);

        Trio trio1 = new Trio(club, cole, cap);
        Trio trio2 = new Trio(cheese, spin, soda);

        System.out.println();
        System.out.println(club.getName());
        System.out.println("Price: $" + club.getPrice() + "\n");
        System.out.println(cole.getName());
        System.out.println("Price: $" + cole.getPrice() + "\n");
        System.out.println(cap.getName());
        System.out.println("Price: $" + cap.getPrice() + "\n");

        System.out.println(cheese.getName());
        System.out.println("Price: $" + cheese.getPrice() + "\n");
        System.out.println(spin.getName());
        System.out.println("Price: $" + spin.getPrice() + "\n");
        System.out.println(soda.getName());
        System.out.println("Price: $" + soda.getPrice() + "\n");
    }
}
