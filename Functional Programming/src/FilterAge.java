import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> ageFilter = createAgeFilter(condition, age);

        Function<Person, String> formatter = createFormatter(format);

        System.out.println(people.stream()
                .filter(ageFilter)
                .map(formatter)
                .collect(Collectors.joining(System.lineSeparator())));

    }

    private static Function<Person, String> createFormatter(String format) {
        if (format.equals("name")) {
            return p -> p.name;
        } else if (format.equals("age")) {
            return p -> String.valueOf(p.age);
        } else {
            return p -> p.name + " - " + p.age;
        }
    }


    private static Predicate<Person> createAgeFilter(String condition, int age) {
        if (condition.equals("younger")) {
            return p -> p.age <= age;
        } else {
            return p -> p.age >= age;
        }
    }

    public static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return this.age;
        }
        public String getName(){
            return this.name;
        }
    }
}
