import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        Consumer<String[]> printer = arr -> {
            for (String current : arr) {
                System.out.println(current);
            }
        };

        printer.accept(strings);
    }
}
