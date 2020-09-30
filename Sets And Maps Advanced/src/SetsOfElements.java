import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetSize = sizes[0];
        int secondSetSize = sizes[1];
        Set<Integer> firstSet = new LinkedHashSet<>(firstSetSize);
        Set<Integer> secondSet = new LinkedHashSet<>(secondSetSize);

        for (int i = 0; i < firstSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
