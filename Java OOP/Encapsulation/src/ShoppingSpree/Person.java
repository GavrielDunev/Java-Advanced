package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
        this.products.add(product);
        this.money = this.money - product.getCost();
        System.out.println(this.name + " bought " + product.getName());
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String products = this.products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        if (this.products.isEmpty()) {
            products = "Nothing bought";
        }
        return this.name + " - " + products;
    }
}
