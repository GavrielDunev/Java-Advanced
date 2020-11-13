package Vehicles;

public class Car extends Vehicle{
    private static final double ADDITIONAL_CONSUMPTION_WITH_AIR_CONDITIONER = 0.9;

    public Car(double fuelQuantity, double fuelConsumptions) {
        super(fuelQuantity, fuelConsumptions + ADDITIONAL_CONSUMPTION_WITH_AIR_CONDITIONER);
    }

}
