public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
    }

    public Car(String brand, String model, int horsepower) {
        this(brand, model);
        this.horsepower = horsepower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsepower());
    }
}
