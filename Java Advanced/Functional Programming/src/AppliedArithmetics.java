import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> addition = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + 1;
            }
            return arr;
        };

        Function<int[], int[]> multiplication = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 2;
            }
            return arr;
        };

        Function<int[], int[]> subtraction = arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - 1;
            }
            return arr;
        };

        Consumer<int[]> printer = arr -> Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    addition.apply(numbers);
                    break;
                case "multiply":
                    multiplication.apply(numbers);
                    break;
                case "subtract":
                    subtraction.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
