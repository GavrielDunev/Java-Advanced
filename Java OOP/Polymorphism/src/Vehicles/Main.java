package Vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicleMap = new HashMap<>();

        String[] carTokens = scanner.nextLine().split("\\s+");
        vehicleMap.put("Car", new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2])));

        String[] truckTokens = scanner.nextLine().split("\\s+");
        vehicleMap.put("Truck", new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2])));

        int inputCount = Integer.parseInt(scanner.nextLine());

        while (inputCount-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("Drive")) {
                double distance = Double.parseDouble(input[2]);
                System.out.println(vehicleMap.get(input[1]).drive(distance));
            } else {
                double liters = Double.parseDouble(input[2]);
                vehicleMap.get(input[1]).refuel(liters);
            }
        }

        for (Vehicle vehicle : vehicleMap.values()) {
            System.out.println(vehicle.toString());
        }
    }
}
