import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> realNumbers = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(entry -> {
            realNumbers.putIfAbsent(entry, 0);
            realNumbers.put(entry, realNumbers.get(entry) + 1);
        });
        realNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
