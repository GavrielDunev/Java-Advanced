package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> birthableList = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Citizen")) {
                birthableList.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
            } else if (tokens[0].equals("Pet")) {
                birthableList.add(new Pet(tokens[1], tokens[2]));
            }
            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : birthableList) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
