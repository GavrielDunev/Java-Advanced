import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBox::push);


        int sumOfCollectedItems = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstBoxItem = firstBox.peek();
            int secondBoxItem = secondBox.pop();
            int sum = firstBoxItem + secondBoxItem;
            if (sum % 2 == 0) {
                sumOfCollectedItems += sum;
                firstBox.poll();
            } else {
                firstBox.offer(secondBoxItem);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfCollectedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sumOfCollectedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sumOfCollectedItems);
        }
    }
}
