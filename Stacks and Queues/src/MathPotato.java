import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kidNames = new ArrayDeque<>();

        for (String child : children) {
            kidNames.offer(child);
        }

        int count = 1;
        while (kidNames.size() != 1) {
            for (int i = 1; i < n; i++) {
                if (!kidNames.isEmpty()) {
                    kidNames.offer(kidNames.poll());
                }
            }
            if (isComposite(count) || count == 1) {
                System.out.println("Removed " + kidNames.poll());
            } else {
                System.out.println("Prime " + kidNames.peek());
            }
            count++;

        }
        System.out.println("Last is " + kidNames.peek());

    }

    private static boolean isComposite(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
