package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] evenLine = scanner.nextLine().split("\\s+");

        List<Animal> animalList = new ArrayList<>();
        while (!evenLine[0].equals("End")) {
            Animal animal = createAnimal(evenLine);

            String[] oddLine = scanner.nextLine().split("\\s+");
            Food food = createFood(oddLine);

            animal.makeSound();
            try {
                animal.eat(food);
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animalList.add(animal);
            evenLine = scanner.nextLine().split("\\s+");
        }

        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }

    private static Food createFood(String[] tokens) {
        int foodQuantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("Vegetable") ? new Vegetable(foodQuantity) : new Meat(foodQuantity);
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Cat":
                return new Cat(tokens[0], tokens[1], Double.parseDouble(tokens[2]),
                        tokens[3], tokens[4]);
            case "Tiger":
                return new Tiger(tokens[0], tokens[1], Double.parseDouble(tokens[2]),
                        tokens[3]);
            case "Zebra":
                return new Zebra(tokens[0], tokens[1], Double.parseDouble(tokens[2]),
                        tokens[3]);
            case "Mouse":
                return new Mouse(tokens[0], tokens[1], Double.parseDouble(tokens[2]),
                        tokens[3]);
            default:
                throw new IllegalStateException("Invalid animal type");
        }
    }
}
