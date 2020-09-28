import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        int[] firstPlayerNumbs = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondPlayerNumbs = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(firstPlayerNumbs).forEach(firstPlayerCards::add);
        Arrays.stream(secondPlayerNumbs).forEach(secondPlayerCards::add);

        int round = 50;
        while (round-- > 0) {
            int first = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(first);
            int second = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(second);
            if (first > second) {
                firstPlayerCards.add(first);
                firstPlayerCards.add(second);
            } else if (first < second) {
                secondPlayerCards.add(first);
                secondPlayerCards.add(second);
            }
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
                break;
            }
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerCards.size() < secondPlayerCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
