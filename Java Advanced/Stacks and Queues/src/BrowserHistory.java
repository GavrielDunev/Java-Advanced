import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String instruction = scanner.nextLine();

        while (!instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (stack.size() > 1) {
                    stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    instruction = scanner.nextLine();
                    continue;
                }
            } else {
                stack.push(instruction);
            }

            System.out.println(stack.peek());
            instruction = scanner.nextLine();
        }
    }
}