import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(line[0]);
        int columns = Integer.parseInt(line[1]);
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(", ");
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        int[][] bestMatrix = new int[2][2];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < columns - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestMatrix[0][0] = matrix[row][col];
                    bestMatrix[0][1] = matrix[row][col + 1];
                    bestMatrix[1][0] = matrix[row + 1][col];
                    bestMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix[i].length; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
