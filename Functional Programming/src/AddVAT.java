import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> addVat = num -> num + 0.2 * num;
        double[] numsWithVAT = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(num -> addVat.apply(Double.parseDouble(num)))
                .toArray();
        System.out.println("Prices with VAT:");
        Arrays.stream(numsWithVAT).forEach(n -> System.out.printf("%.2f%n", n));
    }
}
