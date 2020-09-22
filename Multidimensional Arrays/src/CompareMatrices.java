import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] firstMatrix = new int[rows][cols];

        readMatrix(scanner, firstMatrix, rows, cols);
        input = scanner.nextLine().split("\\s+");
        rows = Integer.parseInt(input[0]);
        cols = Integer.parseInt(input[1]);
        int[][] secondMatrix = new int[rows][cols];
        readMatrix(scanner, secondMatrix, rows, cols);
        System.out.println(areEqual(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int rows = 0; rows < firstMatrix.length; rows++) {
            if (firstMatrix[rows].length != secondMatrix[rows].length) {
                return false;
            }
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (firstMatrix[rows][cols] != secondMatrix[rows][cols]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void readMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
    }
}
