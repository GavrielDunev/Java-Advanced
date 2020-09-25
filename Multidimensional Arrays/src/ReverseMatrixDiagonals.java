import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = readIntArray(scanner);

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = readIntArray(scanner);
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = arr[col];
            }
        }

        int row = matrix.length - 1;
        int col = matrix[row].length - 1;

        StringBuilder result = new StringBuilder();

        while (col >= 0) {
            result.append(matrix[row][col]).append(" ");

            int upperRow = row - 1;
            int upperAndRightCol = col + 1;
            while (upperRow >= 0 && upperAndRightCol < matrix[upperRow].length) {
                result.append(matrix[upperRow][upperAndRightCol]).append(" ");
                upperRow--;
                upperAndRightCol++;
            }
            col--;
            result.append("\n");
        }

        row -= 1;
        col = 0;

        while (row >= 0) {
            result.append(matrix[row][col]).append(" ");

            int upperRow = row - 1;
            int upperAndRightCol = col + 1;

            while (upperRow >= 0 && upperAndRightCol < matrix[upperRow].length) {
                result.append(matrix[upperRow][upperAndRightCol]).append(" ");
                upperRow--;
                upperAndRightCol++;
            }
            row--;
            result.append("\n");
        }

        System.out.print(result);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
