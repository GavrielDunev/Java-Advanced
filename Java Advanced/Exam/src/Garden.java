import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);
        int[][] garden = new int[rows][cols];
        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                garden[row][col] = 0;
            }
        }
        String input = scanner.nextLine();
        Map<Integer, Integer> flowers = new LinkedHashMap<>();
        while (!input.equals("Bloom Bloom Plow")) {
            int row = Integer.parseInt(input.split(" ")[0]);
            int col = Integer.parseInt(input.split(" ")[1]);
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                System.out.println("Invalid coordinates.");
                input = scanner.nextLine();
                continue;
            }
            flowers.put(row, col);
            input = scanner.nextLine();
        }

        for (Map.Entry<Integer, Integer> flower : flowers.entrySet()) {
            int flowerRow = flower.getKey();
            int flowerCol = flower.getValue();
            garden[flowerRow][flowerCol] = 1;
            //up
            if (flowerRow - 1 >= 0) {
                for (int currentRow = flowerRow - 1; currentRow >= 0; currentRow--) {
                    garden[currentRow][flowerCol] = garden[currentRow][flowerCol] + 1;
                }
            }
            //down
            if (flowerRow + 1 < rows) {
                for (int currentRow = flowerRow + 1; currentRow < rows; currentRow++) {
                    garden[currentRow][flowerCol] = garden[currentRow][flowerCol] + 1;
                }
            }
            //left
            if (flowerCol - 1 >= 0) {
                for (int currentCol = flowerCol - 1; currentCol >= 0; currentCol--) {
                    garden[flowerRow][currentCol] = garden[flowerRow][currentCol] + 1;
                }
            }
            //right
            if (flowerCol + 1 < cols) {
                for (int currentCol = flowerCol + 1; currentCol < cols; currentCol++) {
                    garden[flowerRow][currentCol] = garden[flowerRow][currentCol] + 1;
                }
            }
        }

        printGarden(garden);
    }

    private static void printGarden(int[][] garden) {
        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }
    }
}
