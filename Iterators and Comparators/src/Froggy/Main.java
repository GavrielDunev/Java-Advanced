package Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbers = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();
        Lake lake = new Lake(numbers);

        Iterator iterator = lake.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(", ");
        }
        System.out.println(sb.substring(0, sb.lastIndexOf(",")));
    }
}
