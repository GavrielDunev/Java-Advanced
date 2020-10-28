import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int wreathsCount = 0;
        int storedFlowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int rose = roses.peek();
            int lily = lilies.pop();
            int sum = rose + lily;
            if (sum == 15) {
                wreathsCount++;
                roses.poll();
            } else if (sum > 15) {
                lilies.push(lily - 2);
            } else {
                roses.poll();
                storedFlowers += sum;
            }
        }

        wreathsCount = wreathsCount + storedFlowers / 15;

        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathsCount);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathsCount);
        }
    }
}
