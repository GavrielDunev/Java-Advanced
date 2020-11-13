package VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        vehicleMap.put("Car", createVehicle(scanner.nextLine().split("\\s+")));
        vehicleMap.put("Truck", createVehicle(scanner.nextLine().split("\\s+")));

        Bus bus = createBus(scanner.nextLine().split("\\s+"));
        vehicleMap.put("Bus", bus);

        int inputCount = Integer.parseInt(scanner.nextLine());

        while (inputCount-- > 0) {
            try {
                String[] input = scanner.nextLine().split("\\s+");
                double argument = Double.parseDouble(input[2]);
                if (input[0].equals("Drive") && input[1].equals("Bus")) {
                    double fuelConsumption = bus.getFuelConsumptions();
                    System.out.println(bus.drive(argument, fuelConsumption));
                } else if (input[0].equals("Refuel")) {
                    vehicleMap.get(input[1]).refuel(argument);
                } else {
                    System.out.println(vehicleMap.get(input[1]).drive(argument));
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }

    }

    private static Vehicle createVehicle(String[] tokens) {
        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));

        }
        return null;
    }

    private static Bus createBus(String[] tokens) {
        return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }
}
