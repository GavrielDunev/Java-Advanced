import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '(') {
                stack.push(index);
            } else if (input.charAt(index) == ')') {
                if (!stack.isEmpty()) {
                    int startIndex = stack.pop();
                    String extraction = input.substring(startIndex, index + 1);
                    System.out.println(extraction);
                }
            }
        }
    }
}
