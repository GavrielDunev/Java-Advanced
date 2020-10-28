package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Person> people= new HashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            Person person = new Person();
            people.putIfAbsent(personName, person);
            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person = people.get(personName);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person = people.get(personName);
                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    person = people.get(personName);
                    person.getParents().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children children = new Children(childName, childBirthday);
                    person = people.get(personName);
                    person.getChildren().add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    person = people.get(personName);
                    person.setCar(car);
                    break;

            }

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("Company:");
        if (people.get(name).getCompany() != null) {
            System.out.println(people.get(name).getCompany().toString());
        }
        System.out.println("Car:");
        if (people.get(name).getCar() != null) {
            System.out.println(people.get(name).getCar().toString());
        }
        System.out.println("Pokemon:");
        if (people.get(name).getPokemons().size() > 0) {
            people.get(name).getPokemons().forEach(p -> System.out.println(p.toString()));
        }
        System.out.println("Parents:");
        if (people.get(name).getParents().size() > 0) {
            people.get(name).getParents().forEach(p -> System.out.println(p.toString()));
        }
        System.out.println("Children:");
        if (people.get(name).getChildren().size() > 0) {
            people.get(name).getChildren().forEach(c -> System.out.println(c.toString()));
        }
    }
}
