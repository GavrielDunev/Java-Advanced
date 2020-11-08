package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peopleTokens = scanner.nextLine().split(";");
        String[] productsTokens = scanner.nextLine().split(";");

        Map<String, Person> people = new HashMap<>();
        Map<String, Product> products = new HashMap<>();

        try {
            addPeopleToMap(peopleTokens, people);
            addProductsToMap(productsTokens, products);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }


        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];
            try {
                people.get(personName).buyProduct(products.get(productName));
            }
            catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            input = scanner.nextLine();
        }

        printPeople(people);
    }

    private static void printPeople(Map<String, Person> people) {
        people.values().forEach(p -> System.out.println(p.toString()));
    }


    private static void addProductsToMap(String[] productsTokens, Map<String, Product> productsAndCosts) {
        for (String currentProduct : productsTokens) {
            String[] tokens = currentProduct.split("=");
            productsAndCosts.put(tokens[0], new Product(tokens[0], Double.parseDouble(tokens[1])));
        }
    }

    private static void addPeopleToMap(String[] peopleTokens, Map<String, Person> peopleAndMoney) {
        for (String currentPerson : peopleTokens) {
            String[] tokens = currentPerson.split("=");
            peopleAndMoney.put(tokens[0], new Person(tokens[0], Double.parseDouble(tokens[1])));
        }
    }
}
