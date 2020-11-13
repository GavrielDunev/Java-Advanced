package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;
    private String livingRegion;

    protected Animal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.animalType,
                this.animalName,
                formatter.format(this.animalWeight),
                this.livingRegion,
                this.foodEaten);
    }
}
