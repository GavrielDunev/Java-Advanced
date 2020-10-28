import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiPredicate<Integer, int[]> validateNumber = (number, arr) -> {
            for (int divider : arr) {
                if (number % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= num; i++) {
            if (validateNumber.test(i, dividers)) {
                System.out.print(i + " ");
            }
        }
    }
}
