import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int[] wrongValueDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = matrix[wrongValueDimensions[0]][wrongValueDimensions[1]];

        List<int[]> mistakenValues = new ArrayList<>();
        List<Integer> correctValues = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == wrongValue) {
                    mistakenValues.add(new int[]{row, col});
                    correctValues.add(getSum(row, col, wrongValue, matrix));
                }
            }
        }

        for (int i = 0; i < correctValues.size(); i++) {
            int correct = correctValues.get(i);
            int[] mistakenDimensions = mistakenValues.get(i);
            int row = mistakenDimensions[0];
            int col = mistakenDimensions[1];
            matrix[row][col] = correct;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int row, int col, int wrongValue, int[][] matrix) {
        int sum = 0;

        if (col + 1 < matrix[row].length) {
            if (matrix[row][col + 1] != wrongValue) {
                sum += matrix[row][col + 1];
            }
        }
            if (col - 1 >= 0) {
                if (matrix[row][col - 1] != wrongValue) {
                    sum += matrix[row][col - 1];
                }
            }

            if (row > 0) {
                if (matrix[row - 1][col] != wrongValue) {
                    sum += matrix[row - 1][col];
                }
            }

            if (row < matrix.length - 1) {
                if (matrix[row + 1][col] != wrongValue) {
                    sum += matrix[row + 1][col];
                }
            }

        return sum;
    }
}