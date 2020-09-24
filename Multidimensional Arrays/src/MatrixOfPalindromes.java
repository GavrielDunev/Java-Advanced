import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[][] matrix = new String[rows][columns];

        char startLetter = 'a';
        fillMatrix(rows, columns, matrix, startLetter);

        printMatrix(rows, columns, matrix);
    }

    public static void printMatrix(int rows, int columns, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrix(int rows, int columns, String[][] matrix, char startLetter) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = "" + (char)(startLetter + row) + (char)(startLetter + col + row) + (char)(startLetter + row);
            }
        }
    }
}
