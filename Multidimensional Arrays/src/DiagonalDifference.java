import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];


        for (int row = 0; row < size; row++) {
                matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    sumOfPrimaryDiagonal += matrix[row][col];
                }
                if (col == size - 1 - row) {
                    sumOfSecondaryDiagonal += matrix[row][col];
                }
            }
        }

        System.out.println(Math.abs(sumOfPrimaryDiagonal - sumOfSecondaryDiagonal));
    }
}
