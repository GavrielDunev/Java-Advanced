package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        } else {
            Car latestCar = data.get(0);
            for (Car car : data) {
                if (latestCar.getYear() < car.getYear()) {
                    latestCar = car;
                }
            }
            return latestCar;
        }
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (Car currentCar : data) {
            if (currentCar.getManufacturer().equals(manufacturer) && currentCar.getModel().equals(model)) {
                car = currentCar;
                break;
            }
        }
        return car;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
