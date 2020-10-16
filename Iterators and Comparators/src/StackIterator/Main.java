package StackIterator;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Stack stack = new Stack();
        while (!line.equals("END")) {
            line = line.replaceAll(",", " ");
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Push":
                    stack.push(Arrays.stream(tokens).skip(1).mapToInt(Integer::parseInt)
                            .boxed()
                            .toArray(Integer[]::new));
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
            line = scanner.nextLine();
        }
        for (Integer integer : stack) {
            System.out.println(integer);
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
