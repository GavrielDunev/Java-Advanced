import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        String line = scanner.nextLine();
        boolean areBalanced = true;
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                brackets.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (brackets.isEmpty()) {
                    areBalanced = false;
                    break;
                } else {
                    char removed = brackets.pop();
                    if (current == ']' && removed != '[') {
                        areBalanced = false;
                    } else if (current == '}' && removed != '{') {
                        areBalanced = false;
                    } else if (current == ')' && removed != '(') {
                        areBalanced = false;
                    }
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
