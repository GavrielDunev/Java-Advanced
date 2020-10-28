import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = Integer.parseInt(scanner.nextLine());
        Predicate<String> validateLength = name -> name.length() <= maxLength;
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(validateLength)
                .forEach(System.out::println);
    }
}
