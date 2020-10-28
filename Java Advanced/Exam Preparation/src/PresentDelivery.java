import java.util.Scanner;

public class PresentDelivery {
    public static int niceKids = 0;
    public static int niceKidsWithoutPresents = 0;
    public static int santaRow = 0;
    public static int santaCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int presents = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        char[][] neighbourhood = new char[n][n];

        for (int row = 0; row < neighbourhood.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < neighbourhood[row].length; col++) {
                if (line[col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                } else if (line[col].equals("V")) {
                    niceKids++;
                }
                neighbourhood[row][col] = line[col].charAt(0);
            }
        }
        niceKidsWithoutPresents = niceKids;

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            if (command.equals("up")) {
                presents = moveSanta(santaRow - 1, santaCol, neighbourhood, presents);
                if (presents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            } else if (command.equals("down")) {
                presents = moveSanta(santaRow + 1, santaCol, neighbourhood, presents);
                if (presents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            } else if (command.equals("left")) {
                presents = moveSanta(santaRow, santaCol - 1, neighbourhood, presents);
                if (presents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            } else if (command.equals("right")) {
                presents = moveSanta(santaRow, santaCol + 1, neighbourhood, presents);
                if (presents == 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            }
            command = scanner.nextLine();
        }

        printNeighbourhood(neighbourhood);

        if (niceKidsWithoutPresents == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsWithoutPresents);
        }
    }

    private static void printNeighbourhood(char[][] neighbourhood) {
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood[row].length; col++) {
                System.out.print(neighbourhood[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int moveSanta(int newRow, int newCol, char[][] neighbourhood, int presents) {
        if (newRow < 0 || newRow >= neighbourhood.length || newCol < 0 || newCol >= neighbourhood.length) {
            neighbourhood[santaRow][santaCol] = '-';
            return 0;
        }

        neighbourhood[santaRow][santaCol] = '-';
        switch (neighbourhood[newRow][newCol]) {
            case 'V':
                santaRow = newRow;
                santaCol = newCol;
                neighbourhood[newRow][newCol] = 'S';
                presents--;
                niceKidsWithoutPresents--;
                break;
            case 'X':
            case '-':
                santaRow = newRow;
                santaCol = newCol;
                neighbourhood[newRow][newCol] = 'S';
                break;

            case 'C':
                santaRow = newRow;
                santaCol = newCol;
                neighbourhood[newRow][newCol] = 'S';

                if (neighbourhood[newRow][newCol - 1] == 'X') {
                    presents--;
                    neighbourhood[newRow][newCol - 1] = '-';
                } else if (neighbourhood[newRow][newCol - 1] == 'V') {
                    neighbourhood[newRow][newCol - 1] = '-';
                    presents--;
                    niceKidsWithoutPresents--;
                } else if (neighbourhood[newRow][newCol - 1] == 'C') {

                    if (neighbourhood[newRow][newCol - 2] == 'X') {
                        presents--;
                        neighbourhood[newRow][newCol - 2] = '-';
                    } else if (neighbourhood[newRow][newCol - 2] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow][newCol - 2] = '-';
                    }

                    if (neighbourhood[newRow - 1][newCol - 1] == 'X') {
                        presents--;
                        neighbourhood[newRow - 1][newCol - 1] = '-';
                    } else if (neighbourhood[newRow - 1][newCol - 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow - 1][newCol - 1] = '-';
                    }

                    if (neighbourhood[newRow + 1][newCol - 1] == 'X') {
                        presents--;
                        neighbourhood[newRow + 1][newCol - 1] = '-';
                    } else if (neighbourhood[newRow + 1][newCol - 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow + 1][newCol - 1] = '-';
                    }
                }
                if (presents == 0) {
                    return 0;
                }

                if (neighbourhood[newRow][newCol + 1] == 'X') {
                    presents--;
                    neighbourhood[newRow][newCol + 1] = '-';
                } else if (neighbourhood[newRow][newCol + 1] == 'V') {
                    neighbourhood[newRow][newCol + 1] = '-';
                    presents--;
                    niceKidsWithoutPresents--;
                } else if (neighbourhood[newRow][newCol + 1] == 'C') {
                    if (neighbourhood[newRow][newCol + 2] == 'X') {
                        presents--;
                        neighbourhood[newRow][newCol + 2] = '-';
                    } else if (neighbourhood[newRow][newCol + 2] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow][newCol + 2] = '-';
                    }

                    if (neighbourhood[newRow - 1][newCol + 1] == 'X') {
                        presents--;
                        neighbourhood[newRow - 1][newCol + 1] = '-';
                    } else if (neighbourhood[newRow - 1][newCol + 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow - 1][newCol + 1] = '-';
                    }

                    if (neighbourhood[newRow + 1][newCol + 1] == 'X') {
                        presents--;
                        neighbourhood[newRow + 1][newCol + 1] = '-';
                    } else if (neighbourhood[newRow + 1][newCol + 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow + 1][newCol + 1] = '-';
                    }
                }
                if (presents == 0) {
                    return 0;
                }

                if (neighbourhood[newRow - 1][newCol] == 'X') {
                    presents--;
                    neighbourhood[newRow - 1][newCol] = '-';
                } else if (neighbourhood[newRow - 1][newCol] == 'V') {
                    neighbourhood[newRow - 1][newCol] = '-';
                    presents--;
                    niceKidsWithoutPresents--;
                } else if (neighbourhood[newRow - 1][newCol] == 'C') {
                    neighbourhood[newRow - 1][newCol] = '-';

                    if (neighbourhood[newRow - 2][newCol] == 'X') {
                        presents--;
                        neighbourhood[newRow - 2][newCol] = '-';
                    } else if (neighbourhood[newRow - 2][newCol] == 'V') {
                        presents--;
                        neighbourhood[newRow - 2][newCol] = '-';
                        niceKidsWithoutPresents--;
                    }

                    if (neighbourhood[newRow - 1][newCol - 1] == 'X') {
                        presents--;
                        neighbourhood[newRow - 1][newCol - 1] = '-';
                    } else if (neighbourhood[newRow - 1][newCol - 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow - 1][newCol - 1] = '-';
                    }

                    if (neighbourhood[newRow - 1][newCol + 1] == 'X') {
                        presents--;
                        neighbourhood[newRow - 1][newCol + 1] = '-';
                    } else if (neighbourhood[newRow - 1][newCol + 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow - 1][newCol + 1] = '-';
                    }
                }
                if (presents == 0) {
                    return 0;
                }

                if (neighbourhood[newRow + 1][newCol] == 'X') {
                    presents--;
                    neighbourhood[newRow + 1][newCol] = '-';
                } else if (neighbourhood[newRow + 1][newCol] == 'V') {
                    neighbourhood[newRow + 1][newCol] = '-';
                    presents--;
                    niceKidsWithoutPresents--;
                } else if (neighbourhood[newRow + 1][newCol] == 'C') {

                    if (neighbourhood[newRow + 2][newCol] == 'X') {
                        presents--;
                        neighbourhood[newRow + 2][newCol] = '-';
                    } else if (neighbourhood[newRow + 2][newCol] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow + 2][newCol] = '-';
                    }

                    if (neighbourhood[newRow + 1][newCol - 1] == 'X') {
                        presents--;
                        neighbourhood[newRow + 1][newCol - 1] = '-';
                    } else if (neighbourhood[newRow + 1][newCol - 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow + 1][newCol - 1] = '-';
                    }

                    if (neighbourhood[newRow + 1][newCol + 1] == 'X') {
                        presents--;
                        neighbourhood[newRow + 1][newCol + 1] = '-';
                    } else if (neighbourhood[newRow + 1][newCol + 1] == 'V') {
                        presents--;
                        niceKidsWithoutPresents--;
                        neighbourhood[newRow + 1][newCol + 1] = '-';
                    }
                }
                if (presents == 0) {
                    return 0;
                }

                break;
        }

        return presents;
    }
}
