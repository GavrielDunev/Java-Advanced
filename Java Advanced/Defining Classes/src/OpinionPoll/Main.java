package OpinionPoll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Person person;
        Map<String, Person> people= new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            person = new Person();
            person.setName(tokens[0]);
            person.setAge(Integer.parseInt(tokens[1]));
            people.put(tokens[0], person);
        }

        people.entrySet().stream().filter(e -> e.getValue().getAge() > 30).forEach(e -> System.out.println(e.getValue()));
    }
}
