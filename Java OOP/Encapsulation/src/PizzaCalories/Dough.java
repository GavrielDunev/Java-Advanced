package PizzaCalories;

import java.util.Map;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    private static final Map<String, Double> FLOUR_AND_BAKING_TECHNIQUES_TYPES = Map.of("White", 1.5,
            "Wholegrain", 1.0,
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        validateProduct(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        validateProduct(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight *
                FLOUR_AND_BAKING_TECHNIQUES_TYPES.get(this.flourType) *
                FLOUR_AND_BAKING_TECHNIQUES_TYPES.get(this.bakingTechnique);
    }

    public void validateProduct(String productName) {
        if (!FLOUR_AND_BAKING_TECHNIQUES_TYPES.containsKey(productName)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
