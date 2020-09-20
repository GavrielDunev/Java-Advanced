import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            int number = Integer.parseInt(command[0]);
            switch (number) {
                case 1:
                    int numberToBePushed = Integer.parseInt(command[1]);
                    numbers.push(numberToBePushed);
                    break;
                case 2:
                    if (!numbers.isEmpty()) {
                        numbers.pop();
                    }
                    break;
                case 3:
                    System.out.println(maxNumber(numbers));
                    break;
            }
        }
    }
    public static int maxNumber (ArrayDeque<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }
}
