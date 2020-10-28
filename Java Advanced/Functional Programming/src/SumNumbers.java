import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], String> getCountOfNumbers = arr -> String.format("Count = %d", arr.length);
        System.out.println(getCountOfNumbers.apply(numbers));
        Function<int[], String> getSumOfNumbers = arr -> String.format("Sum = %s", Arrays.stream(arr).sum());
        System.out.println(getSumOfNumbers.apply(numbers));
    }
}
