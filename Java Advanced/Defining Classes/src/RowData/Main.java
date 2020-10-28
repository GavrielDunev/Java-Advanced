package RowData;

import java.util.*;

public class Main {
    public static <tire1> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, new ArrayList<>());
            car.getTires().add(tire1);
            car.getTires().add(tire2);
            car.getTires().add(tire3);
            car.getTires().add(tire4);
            cars.put(model, car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            for (Map.Entry<String, Car> entry : cars.entrySet()) {
                if (entry.getValue().getCargo().getCargoType().equals("fragile")) {
                    List<Tire> tires = entry.getValue().getTires();
                    for (Tire tire : tires) {
                        if (tire.getTirePressure() < 1) {
                            System.out.println(entry.getKey());
                            break;
                        }
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (Map.Entry<String, Car> entry : cars.entrySet()) {
                if (entry.getValue().getCargo().getCargoType().equals("flamable")) {
                    if (entry.getValue().getEngine().getEnginePower() > 250) {
                        System.out.println(entry.getKey());
                    }
                }
            }
        }
    }
}
