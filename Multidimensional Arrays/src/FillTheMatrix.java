import javax.swing.*;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);

        int[][] matrix = new int[size][size];

        fillMatrix(size, pattern, matrix);

        printMatrix(size, matrix);
    }

    public static void printMatrix(int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrix(int size, char pattern, int[][] matrix) {
        int startNumber = 1;
        if (pattern == 'A') {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            }
        } else if (pattern == 'B') {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = startNumber++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = startNumber++;
                    }
                }
            }
        }
    }
}
