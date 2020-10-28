import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            Double grade = Double.parseDouble(line[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            List<Double> currentList = entry.getValue();
            double currentAverage = 0.0;
            for (int i = 0; i < currentList.size(); i++) {
                currentAverage += currentList.get(i);
            }
            currentAverage = currentAverage / currentList.size();
            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().forEach(grade -> System.out.printf("%.2f ",grade));
            System.out.printf("(avg: %.2f)%n", currentAverage);
        }
    }
}
