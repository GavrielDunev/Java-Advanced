import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("[()]");
        int degrees = Integer.parseInt(line[1]) % 360;

        String input = scanner.nextLine();
        List<String> lines = new ArrayList<>();
        int maxLength = 0;
        while (!input.equals("END")) {
            lines.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }

        char[][] matrix = new char[lines.size()][maxLength];
        fillMatrix(matrix, lines);

        rotateMatrix(matrix, degrees, maxLength);
        if (degrees == 0) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static void rotateMatrix(char[][] matrix, int degrees, int maxLength) {
        switch (degrees) {
            case 90:
                for (int col = 0; col < maxLength; col++) {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = matrix.length - 1; row >= 0; row--) {
                    for (int col = maxLength - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = maxLength - 1; col >= 0; col--) {
                    for (int row = 0; row < matrix.length; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> lines) {
        for (int row = 0; row < matrix.length; row++) {
            String current = lines.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < current.length()) {
                    matrix[row][col] = current.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
