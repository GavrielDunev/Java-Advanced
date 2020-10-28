package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }

    public String getWeightAsString(){
        String weightAsString = this.weight + "";
        if (weightAsString.equals("0")) {
            weightAsString = "n/a";
        }
        return weightAsString;
    }

    @Override
    public String toString(){
        return String.format("%s:%n" + this.engine + "Weight: %s%n" + "Color: %s"
        ,this.model, getWeightAsString(), this.color);
    }
}
