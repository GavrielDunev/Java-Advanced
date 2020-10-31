package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimestions[0];
        int cols = dimestions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoRowsAndCols = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilRowsAndCols = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilRowsAndCols[0];
            int evilCol = evilRowsAndCols[1];

            destroyCells(matrix, evilRow, evilCol);

            int rowOfIvo = ivoRowsAndCols[0];
            int colOfIvo = ivoRowsAndCols[1];

            sum = gatherStars(matrix, sum, rowOfIvo, colOfIvo);

            command = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static long gatherStars(int[][] matrix, long sum, int rowOfIvo, int colOfIvo) {
        while (rowOfIvo >= 0 && colOfIvo < matrix[1].length) {
            if (rowOfIvo < matrix.length && colOfIvo >= 0 && colOfIvo < matrix[0].length) {
                sum += matrix[rowOfIvo][colOfIvo];
            }

            colOfIvo++;
            rowOfIvo--;
        }
        return sum;
    }

    private static void destroyCells(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
