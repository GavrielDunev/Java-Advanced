package CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getDisplacementAsString() {
        String displacementAsString = this.displacement + "";
        if (displacementAsString.equals("0")) {
            displacementAsString = "n/a";
        }
        return displacementAsString;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" + "Power: %d%n" + "Displacement: %s%n" + "Efficiency: %s%n"
                , this.model, this.power, getDisplacementAsString(), this.efficiency);
    }
}
