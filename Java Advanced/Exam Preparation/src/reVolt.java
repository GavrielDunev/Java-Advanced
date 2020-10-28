import java.util.Scanner;

public class reVolt {
    public static int playerRow = 0;
    public static int playerCol = 0;
    public static boolean isFinishReached = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];


        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
                if (line[col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        for (int i = 0; i < countOfCommands; i++) {
            String command = scanner.nextLine();
            if ("up".equals(command)) {
                moveUp(playerRow - 1, playerCol, matrix);
                if (isFinishReached) {
                    System.out.println("Player won!");
                    break;
                }
            } else if ("down".equals(command)) {
                moveDown(playerRow + 1, playerCol, matrix);
                if (isFinishReached) {
                    System.out.println("Player won!");
                    break;
                }
            } else if ("right".equals(command)) {
                moveRight(playerRow, playerCol + 1, matrix);
                if (isFinishReached) {
                    System.out.println("Player won!");
                    break;
                }
            } else if ("left".equals(command)) {
                moveLeft(playerRow, playerCol - 1, matrix);
                if (isFinishReached) {
                    System.out.println("Player won!");
                    break;
                }
            }
        }

        if (!isFinishReached) {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void moveUp(int newRow, int col, char[][] matrix) {
        matrix[playerRow][playerCol] = '-';
        if (newRow < 0) {
            if (isFinish(matrix.length - 1, col, matrix)) {
                isFinishReached = true;
            }
            matrix[matrix.length - 1][col] = 'f';
            playerRow = matrix.length - 1;
        } else {
            switch (matrix[newRow][col]) {
                case '-':
                    matrix[newRow][col] = 'f';
                    playerRow = newRow;
                    break;
                case 'F':
                    matrix[newRow][col] = 'f';
                    isFinishReached = true;
                    break;
                case 'T':
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case 'B':
                    newRow = newRow - 1;
                    if (newRow < 0) {
                        if (isFinish(matrix.length - 1, col, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[matrix.length - 1][col] = 'f';
                        playerRow = matrix.length - 1;
                    } else {
                        if (isFinish(newRow, col, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[newRow][col] = 'f';
                        playerRow = newRow;
                    }
                    break;
            }
        }
    }

    private static void moveDown(int newRow, int col, char[][] matrix) {
        matrix[playerRow][playerCol] = '-';
        if (newRow >= matrix.length) {
            if (isFinish(0, col, matrix)) {
                isFinishReached = true;
            }
            matrix[0][col] = 'f';
            playerRow = 0;
        } else {
            switch (matrix[newRow][col]) {
                case '-':
                    matrix[newRow][col] = 'f';
                    playerRow = newRow;
                    break;
                case 'F':
                    matrix[newRow][col] = 'f';
                    isFinishReached = true;
                    break;
                case 'T':
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case 'B':
                    newRow = newRow + 1;
                    if (newRow >= matrix.length) {
                        if (isFinish(0, col, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[0][col] = 'f';
                        playerRow = 0;
                    } else {
                        if (isFinish(newRow, col, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[newRow][col] = 'f';
                        playerRow = newRow;
                    }
                    break;
            }
        }
    }

    private static void moveLeft(int row, int newCol, char[][] matrix) {
        matrix[playerRow][playerCol] = '-';
        if (newCol < 0) {
            if (isFinish(row, matrix.length - 1, matrix)) {
                isFinishReached = true;
            }
            matrix[row][matrix.length - 1] = 'f';
            playerCol = matrix.length - 1;
        } else {
            switch (matrix[row][newCol]) {
                case '-':
                    matrix[row][newCol] = 'f';
                    playerCol = newCol;
                    break;
                case 'F':
                    matrix[row][newCol] = 'f';
                    isFinishReached = true;
                    break;
                case 'T':
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case 'B':
                    newCol = newCol - 1;
                    if (newCol < 0) {
                        if (isFinish(row, matrix.length - 1, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[row][matrix.length - 1] = 'f';
                        playerCol = matrix.length - 1;
                    } else {
                        if (isFinish(row, newCol, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[row][newCol] = 'f';
                        playerCol = newCol;
                    }
                    break;
            }
        }
    }

    private static void moveRight(int row, int newCol, char[][] matrix) {
        matrix[playerRow][playerCol] = '-';
        if (newCol >= matrix.length) {
            if (isFinish(row, 0, matrix)) {
                isFinishReached = true;
            }
            matrix[row][0] = 'f';
            playerCol = 0;
        } else {
            switch (matrix[row][newCol]) {
                case '-':
                    matrix[row][newCol] = 'f';
                    playerCol = newCol;
                    break;
                case 'F':
                    matrix[row][newCol] = 'f';
                    isFinishReached = true;
                    break;
                case 'T':
                    matrix[playerRow][playerCol] = 'f';
                    break;
                case 'B':
                    newCol = newCol + 1;
                    if (newCol >= matrix.length) {
                        if (isFinish(row, 0, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[row][0] = 'f';
                        playerCol = 0;
                    } else {
                        if (isFinish(row, newCol, matrix)) {
                            isFinishReached = true;
                        }
                        matrix[row][newCol] = 'f';
                        playerCol = newCol;
                    }
                    break;
            }
        }
    }

    public static boolean isFinish(int row, int col, char[][] matrix) {
        return matrix[row][col] == 'F';
    }
}
