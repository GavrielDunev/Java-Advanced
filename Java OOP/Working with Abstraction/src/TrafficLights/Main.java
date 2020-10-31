package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] colors = scanner.nextLine().split(" ");
        List<TrafficLight> trafficLightList = new ArrayList<>();
        for (String color : colors) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(color));
            trafficLightList.add(trafficLight);
        }
        int countOfUpdates = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countOfUpdates; i++) {
            for (TrafficLight trafficLight : trafficLightList) {
                trafficLight.update();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
