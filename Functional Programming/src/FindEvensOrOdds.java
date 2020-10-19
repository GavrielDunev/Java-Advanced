import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ranges = scanner.nextLine().split("\\s+");
        String typeOfNumbers = scanner.nextLine();
        int lowerBound = Integer.parseInt(ranges[0]);
        int upperBound = Integer.parseInt(ranges[1]);

        Predicate<Integer> tester = createTester(typeOfNumbers);

        StringBuilder sb = new StringBuilder();
        for (int i = lowerBound; i <= upperBound; i++) {
            if (tester.test(i)) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static Predicate<Integer> createTester(String typeOfNumbers) {
        if (typeOfNumbers.equals("odd")) {
            return num -> num % 2 != 0;
        } else {
            return num -> num % 2 == 0;
        }
    }
}
