import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, Integer> validateLength = (name, length) -> name.length() == length;

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String command = input.split("\\s+")[0];
            String option = input.split("\\s+")[1];
            String string = input.split("\\s+")[2];
            if (command.equals("Double")) {
                switch (option) {
                    case "StartsWith":
                        for (int i = people.size() - 1; i >= 0; i--) {
                            if (startsWith.test(people.get(i), string)) {
                                people.add(people.get(i));
                            }
                        }
                        break;
                    case "EndsWith":
                        for (int i = people.size() - 1; i >= 0; i--) {
                            if (endsWith.test(people.get(i), string)) {
                                people.add(people.get(i));
                            }
                        }
                        break;
                    case "Length":
                        int length = Integer.parseInt(string);
                        for (int i = people.size() - 1; i >= 0; i--) {
                            if (validateLength.test(people.get(i), length)) {
                                people.add(people.get(i));
                            }
                        }
                        break;
                }
            } else if (command.equals("Remove")) {
                switch (option) {
                    case "StartsWith":
                        for (int i = 0; i < people.size(); i++) {
                            if (startsWith.test(people.get(i), string)) {
                                people.remove(i);
                                i--;
                            }
                        }
                        break;
                    case "EndsWith":
                        for (int i = 0; i < people.size(); i++) {
                            if (endsWith.test(people.get(i), string)) {
                                people.remove(i);
                                i--;
                            }
                        }
                        break;
                    case "Length":
                        int length = Integer.parseInt(string);
                        for (int i = 0; i < people.size(); i++) {
                            if (validateLength.test(people.get(i), length)) {
                                people.remove(i);
                                i--;
                            }
                        }
                        break;
                }
            }
            input = scanner.nextLine();
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String one, String two) {
                return one.compareTo(two);
            }
        };

        people = people.stream()
                .sorted(comparator)
                .collect(Collectors.toList());


        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(String.join(", ", people));
            System.out.print(" are going to the party!");
        }
    }
}