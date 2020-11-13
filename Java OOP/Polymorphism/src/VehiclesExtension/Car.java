package VehiclesExtension;

public class Car extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION_WITH_AIR_CONDITIONER = 0.9;

    public Car(double fuelQuantity, double fuelConsumptions, double tankCapacity) {
        super(fuelQuantity, fuelConsumptions + ADDITIONAL_CONSUMPTION_WITH_AIR_CONDITIONER,
                tankCapacity);
    }
}
