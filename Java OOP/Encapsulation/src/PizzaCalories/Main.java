package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] pizzaTokens = scanner.nextLine().split("\\s+");
            Pizza pizza = new Pizza(pizzaTokens[1], Integer.parseInt(pizzaTokens[2]));

            String[] doughTokens = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);

            String toppingInput = scanner.nextLine();
            while (!toppingInput.equals("END")) {
                Topping topping = new Topping(toppingInput.split("\\s+")[1],
                        Double.parseDouble(toppingInput.split("\\s+")[2]));
                toppingInput = scanner.nextLine();
                pizza.addTopping(topping);
            }
            System.out.println(pizza.toString());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
