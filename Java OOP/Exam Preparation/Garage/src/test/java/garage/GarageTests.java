package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {
    public Garage garage;
    public Car car1;
    public Car car2;

    @Before
    public void setUp() {
        this.garage = new Garage();
        this.car1 = new Car("Porsche", 300, 200000.00);
        this.car2 = new Car("Mercedes", 250, 100000.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCars() {
        garage.addCar(car1);
        List<Car> cars = garage.getCars();
        cars.add(car2);
    }

    @Test
    public void testGetCount() {
        garage.addCar(car1);
        garage.addCar(car2);
        int expected = garage.getCount();
        Assert.assertEquals(expected, 2);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(200);
        Assert.assertEquals(allCarsWithMaxSpeedAbove.size(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWithNullParam() {
        garage.addCar(null);
    }

    @Test
    public void testGetMostExpensiveCar() {
        garage.addCar(car1);
        garage.addCar(car2);
        Car mostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals(mostExpensiveCar.getBrand(), car1.getBrand());
    }

    @Test
    public void testFindAllCarsByBrand() {
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> allCarsByBrand = garage.findAllCarsByBrand(car2.getBrand());
        Assert.assertEquals(allCarsByBrand.size(), 1);

    }
}