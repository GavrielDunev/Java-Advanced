import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();

        int count = 1;
        String input = scanner.nextLine();
        String resource = "";
        while (!input.equals("stop")) {
            if (count % 2 != 0) {
                resource = input;
            } else {
                if (resources.containsKey(resource)) {
                    resources.put(resource, resources.get(resource) + Integer.parseInt(input));
                } else {
                    resources.put(resource, Integer.parseInt(input));
                }
            }

            input = scanner.nextLine();
            count++;
        }

        resources.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
