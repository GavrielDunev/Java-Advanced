import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line.split("\\s+")[0]);
        int s = Integer.parseInt(line.split("\\s+")[1]);
        int x = Integer.parseInt(line.split("\\s+")[2]);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        String[] numbersToBePushed = scanner.nextLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            numbers.offer(Integer.parseInt(numbersToBePushed[i]));
        }

        for (int i = 0; i < s; i++) {
            if (!numbers.isEmpty()) {
                numbers.poll();
            }
        }

        if (numbers.contains(x)) {
            System.out.println("true");
        } else if (numbers.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(minNumber(numbers));
        }
    }

    private static int minNumber(ArrayDeque<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (min > number) {
                min = number;
            }
        }
        return min;
    }

}
