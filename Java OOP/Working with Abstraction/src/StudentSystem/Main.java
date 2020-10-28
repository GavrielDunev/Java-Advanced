package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (isExit(input)){
                break;
            }
            studentSystem.ParseCommand(input);
        }
    }

    private static boolean isExit(String[] input) {
        return input[0].equals("Exit");
    }
}
