import java.util.Scanner;

public class Bee {
    public static int pollinatedFlowers = 0;
    public static int beeRow = 0;
    public static int beeCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[n][n];
        for (int row = 0; row < territory.length; row++) {
            char[] values = scanner.nextLine().toCharArray();
            for (int col = 0; col < territory[row].length; col++) {
                territory[row][col] = values[col];
                if (values[col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            territory[beeRow][beeCol] = '.';
            if ("up".equals(command)) {
                if (!checkIndex(beeRow - 1, beeCol, territory)) {
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    if (!moveBee(beeRow - 1, beeCol, territory, command)){
                        System.out.println("The bee got lost!");
                        break;
                    }
                }
            } else if ("down".equals(command)) {
                if (!checkIndex(beeRow + 1, beeCol, territory)) {
                    territory[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    if (!moveBee(beeRow + 1, beeCol, territory, command)){
                        System.out.println("The bee got lost!");
                        break;
                    }
                }
            } else if ("right".equals(command)) {
                if (!checkIndex(beeRow, beeCol + 1, territory)) {
                    territory[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    if (!moveBee(beeRow, beeCol + 1, territory, command)){
                        System.out.println("The bee got lost!");
                        break;
                    }
                }
            } else if ("left".equals(command)) {
                if (!checkIndex(beeRow, beeCol - 1, territory)) {
                    territory[beeRow][beeCol] = '.';
                    System.out.println("The bee got lost!");
                    break;
                } else {
                    if (!moveBee(beeRow, beeCol - 1, territory, command)){
                        System.out.println("The bee got lost!");
                        break;
                    }
                }
            }


            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        printTerritory(territory);
    }

    private static void printTerritory(char[][] territory) {
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean moveBee(int newRow, int newCol, char[][] territory, String command) {
        if (territory[newRow][newCol] == 'f') {
            pollinatedFlowers++;
            territory[newRow][newCol] = 'B';
            beeRow = newRow;
            beeCol = newCol;
        } else if (territory[newRow][newCol] == 'O') {
            territory[newRow][newCol] = '.';
            switch (command){
                case "up" :
                    if (newRow - 1 < 0) {
                        return false;
                    } else {
                        if (territory[newRow - 1][newCol] == 'f') {
                            pollinatedFlowers++;
                        }
                        territory[newRow - 1][newCol] = 'B';
                        beeRow = newRow - 1;
                    }
                    break;
                case "down":
                    if (newRow + 1 >= territory.length) {
                        return false;
                    } else {
                        if (territory[newRow + 1][newCol] == 'f') {
                            pollinatedFlowers++;
                        }
                        territory[newRow + 1][newCol] = 'B';
                        beeRow = newRow + 1;
                    }
                    break;
                case "right":
                    if (newCol + 1 >= territory.length) {
                        return false;
                    }else {
                        if (territory[newRow][newCol + 1] == 'f') {
                            pollinatedFlowers++;
                        }
                        territory[newRow][newCol + 1] = 'B';
                        beeCol = newCol + 1;
                    }
                    break;
                case "left":
                    if (newCol - 1 < 0) {
                        return false;
                    }else {
                        if (territory[newRow][newCol - 1] == 'f') {
                            pollinatedFlowers++;
                        }
                        territory[newRow][newCol - 1] = 'B';
                        beeCol = newCol - 1;
                    }
                    break;
            }

        } else {
            territory[newRow][newCol] = 'B';
            beeRow = newRow;
            beeCol = newCol;
        }
        return true;
    }

    private static boolean checkIndex(int beeRow, int beeCol, char[][] territory) {
        if (beeRow < 0 || beeRow >= territory.length || beeCol < 0 || beeCol >= territory.length) {
            return false;
        }
        return true;
    }
}