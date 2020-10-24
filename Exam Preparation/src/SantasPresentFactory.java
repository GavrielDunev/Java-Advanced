import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> boxesWithMaterials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(boxesWithMaterials::push);
        ArrayDeque<Integer> magicValues = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int dolls = 0;
        int woodenTrains = 0;
        int teddyBears = 0;
        int bicycles = 0;

        while (!(boxesWithMaterials.isEmpty() || magicValues.isEmpty())) {
            int box = boxesWithMaterials.peek();
            int magic = magicValues.peek();
            int multiplication = box * magic;
            switch (multiplication){
                case 150:
                    dolls++;
                    boxesWithMaterials.pop();
                    magicValues.poll();
                    break;
                case 250:
                    woodenTrains++;
                    boxesWithMaterials.pop();
                    magicValues.poll();
                    break;
                case 300:
                    teddyBears++;
                    boxesWithMaterials.pop();
                    magicValues.poll();
                    break;
                case 400:
                    bicycles++;
                    boxesWithMaterials.pop();
                    magicValues.poll();
                    break;
                default:
                    if (multiplication < 0) {
                        int sum = box + magic;
                        boxesWithMaterials.pop();
                        magicValues.poll();
                        boxesWithMaterials.push(sum);
                    } else if (multiplication > 0) {
                        magicValues.poll();
                        boxesWithMaterials.pop();
                        boxesWithMaterials.push(box + 15);
                    }
                    if (magic == 0) {
                        magicValues.poll();
                    }
                    if (box == 0) {
                        boxesWithMaterials.pop();
                    }
                    break;
            }
        }

        if ((dolls > 0 && woodenTrains > 0) || (teddyBears > 0 && bicycles > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!boxesWithMaterials.isEmpty()) {
            String materials = boxesWithMaterials.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Materials left: " + materials);
        }
        if (!magicValues.isEmpty()) {
            String magics = magicValues.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Magic left: " + magics);
        }

        if (bicycles > 0) {
            System.out.printf("Bicycle: %d%n", bicycles);
        }
        if (dolls > 0) {
            System.out.printf("Doll: %d%n", dolls);
        }
        if (teddyBears > 0) {
            System.out.printf("Teddy bear: %d%n", teddyBears);
        }
        if (woodenTrains > 0) {
            System.out.printf("Wooden train: %d%n", woodenTrains);
        }
    }
}
