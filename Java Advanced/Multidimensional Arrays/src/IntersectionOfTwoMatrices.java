import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rows][columns];
        char[][] secondMatrix = new char[rows][columns];

        readMatrix(firstMatrix, scanner);
        readMatrix(secondMatrix, scanner);
        char[][] thirdMatrix = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                } else {
                    thirdMatrix[row][col] = '*';
                }
            }
        }

        for (int i = 0; i < thirdMatrix.length; i++) {
            for (int j = 0; j < thirdMatrix[i].length; j++) {
                System.out.print(thirdMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
    }
}
