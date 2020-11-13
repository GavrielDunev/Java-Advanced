package VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    private static final double ADDITIONAL_CONSUMPTION_WITH_AIR_CONDITIONER = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptions, double tankCapacity) {
        super(fuelQuantity, fuelConsumptions, tankCapacity);
    }

    public String drive (double distance, double fuelConsumption) {
        double fuelNeeded = (fuelConsumption + ADDITIONAL_CONSUMPTION_WITH_AIR_CONDITIONER) * distance;
        if (this.fuelQuantity < fuelNeeded) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(this.fuelQuantity -= fuelNeeded);
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }
}
