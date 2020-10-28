package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Point bottomLeft = new Point(tokens[0], tokens[1]);
        Point topRight = new Point(tokens[2], tokens[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            scanner.nextLine();
            System.out.println(rectangle.contains(new Point(left, right)));
        }
    }
}
