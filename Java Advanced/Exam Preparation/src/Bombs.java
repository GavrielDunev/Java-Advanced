import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] effects = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] casings = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();

        for (int effect : effects) {
            bombEffects.offer(effect);
        }

        for (int casing : casings) {
            bombCasings.push(casing);
        }

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;


        while ((!bombCasings.isEmpty()) && (!bombEffects.isEmpty())) {
            if (bombEffects.peek() + bombCasings.peek() == 40) {
                daturaBombs++;
                bombCasings.pop();
                bombEffects.poll();
            } else if (bombEffects.peek() + bombCasings.peek() == 60) {
                cherryBombs++;
                bombCasings.pop();
                bombEffects.poll();
            } else if (bombEffects.peek() + bombCasings.peek() == 120) {
                smokeDecoyBombs++;
                bombCasings.pop();
                bombEffects.poll();
            } else {
                int decreasedBombCasing = bombCasings.pop() - 5;
                bombCasings.push(decreasedBombCasing);
            }

            if ((daturaBombs >= 3) && (cherryBombs >= 3) && (smokeDecoyBombs >= 3)) {
                break;
            }
        }

        if ((daturaBombs >= 3) && (cherryBombs >= 3) && (smokeDecoyBombs >= 3)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            StringBuilder sb = new StringBuilder();
            for (Integer bombEffect : bombEffects) {
                sb.append(bombEffect).append(", ");
            }
            String output = sb.substring(0, sb.lastIndexOf(","));
            System.out.print(output + System.lineSeparator());
        }

        if (bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            StringBuilder sb = new StringBuilder();
            for (Integer bombCasing : bombCasings) {
                sb.append(bombCasing).append(", ");
            }
            String output = sb.substring(0, sb.lastIndexOf(","));
            System.out.print(output + System.lineSeparator());
        }

        System.out.printf("Cherry Bombs: %d%n", cherryBombs);
        System.out.printf("Datura Bombs: %d%n", daturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombs);
    }
}
