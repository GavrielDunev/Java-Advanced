import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> products = new ArrayDeque<>();
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        String[] names = scanner.nextLine().split(";");
        String[] time = scanner.nextLine().split(":");
        int hoursToSeconds = Integer.parseInt(time[0]) * 3600;
        int minutesToSeconds = Integer.parseInt(time[1]) * 60;
        long totalSeconds = hoursToSeconds + minutesToSeconds + Integer.parseInt(time[2]);

        addRobots(robots, names);
        int[] workTime = new int[robots.size()];
        String product = scanner.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            totalSeconds++;
            boolean isAssigned = false;

            for (int i = 0; i < workTime.length; i++) {
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            for (int i = 0; i < workTime.length; i++) {
                if (workTime[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> current : robots.entrySet()) {
                        if (count == i) {
                            workTime[i] = current.getValue();
                            long takenHours = totalSeconds / 3600 % 24;
                            long takenMinutes = totalSeconds / 60 % 60;
                            long takenSeconds = totalSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", current.getKey(), currentProduct, takenHours, takenMinutes, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }

    }

    private static void addRobots(LinkedHashMap<String, Integer> robots, String[] names) {
        for (String name : names) {
            String currentName = name.split("-")[0];
            int currentTime = Integer.parseInt(name.split("-")[1]);
            robots.put(currentName, currentTime);
        }
    }
}
