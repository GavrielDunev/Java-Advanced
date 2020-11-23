import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean succeeded = false;

        while (!succeeded) {
            succeeded = printNumbers(scanner);
        }

    }

    public static boolean printNumbers(Scanner scanner) {
        try {
            int[] numbers = readTwoNumbers(scanner);
            for (int i = numbers[0]; i <= numbers[1]; i++) {
                System.out.println(i);
            }
            return true;
        } catch (NumberFormatException | IllegalStateException ex) {
            System.out.println("Invalid number. " + ex.getMessage());
            return false;
        }
    }

    public static int readOneNumber(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());
        if (number <= 1 || number >= 100) {
            throw new IllegalStateException("Number should be in range (1...100)");
        }
        return number;
    }

    public static int[] readTwoNumbers(Scanner scanner) {
        int[] numbers = new int[2];
        numbers[0] = readOneNumber(scanner);
        numbers[1] = readOneNumber(scanner);
        return numbers;
    }
}
