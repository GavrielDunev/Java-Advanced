package Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
   protected double fuelQuantity;
   protected double fuelConsumptions;

    protected Vehicle(double fuelQuantity, double fuelConsumptions) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptions = fuelConsumptions;
    }

    public String drive(double distance) {
        double fuelNeeded = this.fuelConsumptions * distance;
        if (this.fuelQuantity < fuelNeeded) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuelQuantity -= fuelNeeded;
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
