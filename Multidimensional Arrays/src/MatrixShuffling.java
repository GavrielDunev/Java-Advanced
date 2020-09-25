import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            matrix[row] = numbers;
        }

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            if (command[0].equals("swap")) {
                if (command.length == 5) {
                    int row1 = Integer.parseInt(command[1]);
                    int col1 = Integer.parseInt(command[2]);
                    int row2 = Integer.parseInt(command[3]);
                    int col2 = Integer.parseInt(command[4]);
                    if ((row1 >= 0 && row1 < rows) && (row2 >= 0 && row2 < rows)
                            && (col1 >= 0 && col1 < cols) && (col2 >= 0 && col2 < cols)) {
                        String current = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = current;
                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}