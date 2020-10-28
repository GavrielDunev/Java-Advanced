package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engines = new HashMap<>();
        Engine engine;
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            if (input.length == 2) {
                engine = new Engine(model, power);
                engines.put(model, engine);
            } else if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);
            } else if (input.length == 3) {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model, power, displacement);
                    engines.put(model, engine);
                } catch (IllegalArgumentException e) {
                    String efficiency = input[2];
                    engine = new Engine(model, power, efficiency);
                    engines.put(model, engine);
                }
            }
        }

        int m = Integer.parseInt(scanner.nextLine());

        Car car;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine carEngine = engines.get(input[1]);
            if (input.length == 2) {
                car = new Car(model, carEngine);
                cars.add(car);
            } else if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new Car(model, carEngine, weight, color);
                cars.add(car);
            } else if (input.length == 3) {
                try {
                    int weight = Integer.parseInt(input[2]);
                    car = new Car(model, carEngine, weight);
                    cars.add(car);
                } catch (IllegalArgumentException e) {
                    String color = input[2];
                    car = new Car(model, carEngine, color);
                    cars.add(car);
                }
            }
        }

        for (Car current : cars) {
            System.out.println(current.toString());
        }
    }
}
