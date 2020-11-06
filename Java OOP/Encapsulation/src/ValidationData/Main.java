package ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            try {
                Person person = new Person(input[0], input[1], Integer.parseInt(input[2]),
                        Double.parseDouble(input[3]));
                people.add(person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        double bonus = Double.parseDouble(scanner.nextLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
