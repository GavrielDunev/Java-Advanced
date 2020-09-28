import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();
        while(!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        shops.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((innerKey, innerValue) -> System.out.printf("Product: %s, Price: %.1f%n", innerKey, innerValue));
        });
    }
}
