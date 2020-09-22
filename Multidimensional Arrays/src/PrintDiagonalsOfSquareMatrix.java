import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(num -> Integer.parseInt(num)).toArray();
            matrix[row] = arr;
        }

        int row = 0;
        int col = 0;
        while (row < size && col < size) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();

        row = size - 1;
        col = 0;
        while (row >= 0 && col < size) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }
}
