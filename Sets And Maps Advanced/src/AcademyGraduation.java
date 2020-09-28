import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] numbers = scanner.nextLine().split("\\s+");

            double average = 0.0;
            for (String number : numbers) {
                average = average + Double.parseDouble(number);
            }
            average = average / (double) numbers.length;
            students.put(name, average);
        }
        for (Map.Entry<String, Double> current : students.entrySet()) {
            System.out.printf("%s is graduated with " + current.getValue(), current.getKey());
            System.out.println();
        }
    }
}
