package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> people = new HashMap<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] person = scanner.nextLine().split("\\s+");
            if (person.length == 4) {
                people.put(person[0], new Citizen(person[0],Integer.parseInt(person[1]),
                        person[2], person[3]));
            } else {
                people.put(person[0], new Rebel(person[0],Integer.parseInt(person[1]),
                        person[2]));
            }
        }

        String person = scanner.nextLine();
        while (!person.equals("End")) {
            if (people.containsKey(person)) {
                people.get(person).buyFood();
            }
            person = scanner.nextLine();
        }

        System.out.println(people.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
