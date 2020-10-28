import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, rows, cols, scanner);
        int[] startIndex = new int[2];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int current = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (current > maxSum) {
                    maxSum = current;
                    startIndex = new int[]{row, col};
                }
            }
        }
        System.out.println("Sum = " + maxSum);

        for (int row = startIndex[0]; row <= startIndex[0] + 2; row++) {
            for (int col = startIndex[1]; col <= startIndex[1] + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static void fillMatrix(int[][] matrix, int rows, int cols, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }
    }
}
