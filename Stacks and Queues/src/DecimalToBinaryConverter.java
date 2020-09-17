import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
            return;
        }

        while (number > 0) {
            numbers.push(number % 2);
            number = number / 2;
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop());
        }
    }
}
