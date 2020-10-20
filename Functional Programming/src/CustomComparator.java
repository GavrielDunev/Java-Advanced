import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 == 0){
                return first.compareTo(second);
            } else if (first % 2 == 0) {
                return -1;
            } else if (second % 2 == 0) {
                return 1;
            }
            return first.compareTo(second);
        };

        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
