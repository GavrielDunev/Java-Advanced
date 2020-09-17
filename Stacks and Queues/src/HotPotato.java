import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
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
            if (count % n == 0) {
                for (int i = 0; i < n - 1; i++) {
                    if (!kidNames.isEmpty()) {
                        String current = kidNames.poll();
                        kidNames.offer(current);
                    }
                }

                System.out.println("Removed " + kidNames.poll());
            }
            count++;
        }

        System.out.println("Last is " + kidNames.peek());
    }
}
