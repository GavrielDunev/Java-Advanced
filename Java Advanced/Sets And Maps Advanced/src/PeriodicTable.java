import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> chemicalElements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(elements));
        }

        for (String chemicalElement : chemicalElements) {
            System.out.print(chemicalElement + " ");
        }
    }
}
