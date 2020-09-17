import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        for (String current : input) {
            stack.push(current);
        }
        ArrayDeque<String> reversedStack = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }

        while (reversedStack.size() != 1) {
            int firstNum = Integer.parseInt(reversedStack.pop());
            String operator = reversedStack.pop();
            int secondNum = Integer.parseInt(reversedStack.pop());
            if (operator.equals("-")) {
                reversedStack.push((firstNum - secondNum) + "");
            } else {
                reversedStack.push((firstNum + secondNum) + "");
            }
        }
        System.out.println(reversedStack.peek());
    }
}
