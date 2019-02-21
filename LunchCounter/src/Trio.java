public class Trio implements MenuItem {
    private Sandwich sandwich;
    private Salad salad;
    private Drink drink;

    public Trio(Sandwich sandwich, Salad salad, Drink drink){
        this.sandwich = sandwich;
        this.salad = salad;
        this.drink = drink;
    }

    public String getName() {
        return "Name: " + sandwich.getName() + " / " + salad.getName() + " / " + drink.getName();
    }

    public double getPrice() {
        double min = Math.min(Math.min(sandwich.getPrice(), salad.getPrice()), drink.getPrice());
        return sandwich.getPrice() + salad.getPrice() + drink.getPrice() - min;
    }
}
