import java.io.PrintStream;
import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> symbols = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            symbols.putIfAbsent(currentSymbol, 0);
            symbols.put(currentSymbol, symbols.get(currentSymbol) + 1);
        }

        symbols.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
