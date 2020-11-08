package PizzaCalories;

import java.util.Map;

public class Topping {
    private String toppingType;
    private double weight;

    private static final Map<String, Double> TOPPING_TYPES_AND_MODIFIERS = Map.of("Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9);

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories() {
        return 2 * this.weight * TOPPING_TYPES_AND_MODIFIERS.get(this.toppingType);
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_TYPES_AND_MODIFIERS.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
}
