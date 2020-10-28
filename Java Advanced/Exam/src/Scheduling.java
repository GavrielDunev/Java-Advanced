import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
// tasks - stack
//threads - queue
public class Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);
        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        boolean isKilled = false;
        while (!isKilled) {
            int task = tasks.peek();
            int thread = threads.peek();
            if (task == taskToBeKilled) {
                System.out.printf("Thread with value %d killed task %d%n", thread, taskToBeKilled);
                isKilled = true;
            } else if (thread >= task) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }

        for (Integer thread : threads) {
            System.out.print(thread + " ");
        }
    }
}
