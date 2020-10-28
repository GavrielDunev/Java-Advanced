import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns; col++) {
                int current = Integer.parseInt(line[col]);
                matrix[row][col] = current;
            }
        }

        boolean isFound = false;
        int number = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
