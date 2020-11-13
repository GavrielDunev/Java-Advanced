package VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumptions;
    protected double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptions, double tankCapacity) {
        this.fuelConsumptions = fuelConsumptions;
        this.tankCapacity = tankCapacity;
        setFuelQuantity(fuelQuantity);
    }

    public double getFuelConsumptions() {
        return this.fuelConsumptions;
    }

    public void setFuelQuantity(double fuelQuantity) {
        validateFuel(fuelQuantity);
        this.fuelQuantity = fuelQuantity;
    }

    public String drive(double distance) {
        double fuelNeeded = this.fuelConsumptions * distance;
        if (this.fuelQuantity < fuelNeeded) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(this.fuelQuantity -= fuelNeeded);
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    public void refuel(double liters) {
        validateFuel(liters);
        setFuelQuantity(this.fuelQuantity += liters);
    }

    private void validateFuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
