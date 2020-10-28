import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] territory = new String[n][n];

        int snakeRow = 0;
        int snakeCol = 0;
        int[] burrowOne = new int[2];
        int[] burrowTwo = new int[2];
        burrowOne[0] = -1;
        burrowTwo[0] = -1;
        for (int i = 0; i < territory.length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < territory[i].length; j++) {
                territory[i][j] = String.valueOf(line.charAt(j));
                if (territory[i][j].equals("S")) {
                    snakeRow = i;
                    snakeCol = j;
                } else if (territory[i][j].equals("B")) {
                    if (burrowOne[0] == -1) {
                        burrowOne[0] = i;
                        burrowOne[1] = j;
                    } else {
                        burrowTwo[0] = i;
                        burrowTwo[1] = j;
                    }
                }
            }
        }

        int foodQuantities = 0;
        while (foodQuantities < 10) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                if (snakeRow - 1 < 0) {
                    territory[snakeRow][snakeCol] = ".";
                    System.out.println("Game over!");
                    break;
                } else {
                    territory[snakeRow][snakeCol] = ".";
                    if (territory[snakeRow - 1][snakeCol].equals("*")) {
                        foodQuantities++;
                    } else if (snakeRow - 1 == burrowOne[0] && snakeCol == burrowOne[1]) {
                        territory[snakeRow - 1][snakeCol] = ".";
                        territory[burrowTwo[0]][burrowTwo[1]] = "S";
                        snakeRow = burrowTwo[0];
                        snakeCol = burrowTwo[1];
                        continue;
                    } else if (snakeRow - 1 == burrowTwo[0] && snakeCol == burrowTwo[1]) {
                        territory[snakeRow - 1][snakeCol] = ".";
                        territory[burrowOne[0]][burrowOne[1]] = "S";
                        snakeRow = burrowOne[0];
                        snakeCol = burrowOne[1];
                        continue;
                    }
                    territory[snakeRow - 1][snakeCol] = "S";
                    snakeRow--;
                }
            } else if (command.equals("down")) {
                if (snakeRow + 1 > n - 1) {
                    territory[snakeRow][snakeCol] = ".";
                    System.out.println("Game over!");
                    break;
                } else {
                    territory[snakeRow][snakeCol] = ".";
                    if (territory[snakeRow + 1][snakeCol].equals("*")) {
                        foodQuantities++;
                    } else if (snakeRow + 1 == burrowOne[0] && snakeCol == burrowOne[1]) {
                        territory[snakeRow + 1][snakeCol] = ".";
                        territory[burrowTwo[0]][burrowTwo[1]] = "S";
                        snakeRow = burrowTwo[0];
                        snakeCol = burrowTwo[1];
                        continue;
                    } else if (snakeRow + 1 == burrowTwo[0] && snakeCol == burrowTwo[1]) {
                        territory[snakeRow + 1][snakeCol] = ".";
                        territory[burrowOne[0]][burrowOne[1]] = "S";
                        snakeRow = burrowOne[0];
                        snakeCol = burrowOne[1];
                        continue;
                    }
                    territory[snakeRow + 1][snakeCol] = "S";
                    snakeRow++;
                }
            } else if (command.equals("left")) {
                if (snakeCol - 1 < 0) {
                    territory[snakeRow][snakeCol] = ".";
                    System.out.println("Game over!");
                    break;
                } else {
                    territory[snakeRow][snakeCol] = ".";
                    if (territory[snakeRow][snakeCol - 1].equals("*")) {
                        foodQuantities++;
                    } else if (snakeRow == burrowOne[0] && snakeCol - 1 == burrowOne[1]) {
                        territory[snakeRow][snakeCol - 1] = ".";
                        territory[burrowTwo[0]][burrowTwo[1]] = "S";
                        snakeRow = burrowTwo[0];
                        snakeCol = burrowTwo[1];
                        continue;
                    } else if (snakeRow == burrowTwo[0] && snakeCol - 1 == burrowTwo[1]) {
                        territory[snakeRow][snakeCol - 1] = ".";
                        territory[burrowOne[0]][burrowOne[1]] = "S";
                        snakeRow = burrowOne[0];
                        snakeCol = burrowOne[1];
                        continue;
                    }
                    territory[snakeRow][snakeCol - 1] = "S";
                    snakeCol--;
                }
            } else if (command.equals("right")) {
                if (snakeCol + 1 > n - 1) {
                    territory[snakeRow][snakeCol] = ".";
                    System.out.println("Game over!");
                    break;
                } else {
                    territory[snakeRow][snakeCol] = ".";
                    if (territory[snakeRow][snakeCol + 1].equals("*")) {
                        foodQuantities++;
                    } else if (snakeRow == burrowOne[0] && snakeCol + 1 == burrowOne[1]) {
                        territory[snakeRow][snakeCol + 1] = ".";
                        territory[burrowTwo[0]][burrowTwo[1]] = "S";
                        snakeRow = burrowTwo[0];
                        snakeCol = burrowTwo[1];
                        continue;
                    } else if (snakeRow == burrowTwo[0] && snakeCol + 1 == burrowTwo[1]) {
                        territory[snakeRow][snakeCol + 1] = ".";
                        territory[burrowOne[0]][burrowOne[1]] = "S";
                        snakeRow = burrowOne[0];
                        snakeCol = burrowOne[1];
                        continue;
                    }
                    territory[snakeRow][snakeCol + 1] = "S";
                    snakeCol++;
                }
            }
        }

        if (foodQuantities >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodQuantities);

        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }
    }
}
