package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(person);
            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person personToBeCompared = people.remove(n - 1);
        int equalPeople = 1;
        for (Person person : people) {
            if (personToBeCompared.compareTo(person) == 0) {
                equalPeople++;
            }
        }
        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalPeople, people.size() + 1 - equalPeople, people.size() + 1);
        }
    }
}
