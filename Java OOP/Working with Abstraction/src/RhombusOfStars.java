import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            printRow(n - i, i);
        }

        for (int i = 1; i <= n; i++) {
            printRow(i, n - i);
        }
    }

    private static void printRow(int spaces, int stars) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
