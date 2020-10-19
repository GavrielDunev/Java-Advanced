import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> getUppercaseWords = word -> Character.isUpperCase(word.charAt(0));
        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(getUppercaseWords)
                .collect(Collectors.toList());
        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);
    }
}
