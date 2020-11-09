package CarShopExtended;

public class CarImpl implements Car{
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    public String countryProduced() {
        return this.countryProduced;
    }

    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel(),
                countryProduced(), CarImpl.TIRES);
    }
}
