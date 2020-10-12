package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        CustomList<String> customList = new CustomList<String>();
        while (!input[0].equals("END")) {
            switch (input[0]) {
                case "Add":
                    String element = input[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = input[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = input[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }

            input = scanner.nextLine().split("\\s+");
        }
    }
}
