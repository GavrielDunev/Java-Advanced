import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> backHistory = new ArrayDeque<>();
        String instruction = scanner.nextLine();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (backHistory.size() > 1) {
                    forwardHistory.push(backHistory.pop());
                    System.out.println(backHistory.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (instruction.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    backHistory.push(forwardHistory.peek());
                    System.out.println(forwardHistory.pop());
                }
            } else {
                backHistory.push(instruction);
                System.out.println(instruction);
                forwardHistory.clear();
            }
            instruction = scanner.nextLine();
        }
    }
}
