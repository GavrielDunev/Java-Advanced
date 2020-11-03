package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfAnimal = scanner.nextLine();

        while (!typeOfAnimal.equals("Beast!")) {
            String[] animalData = scanner.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            try {
                if (age <= 0) {
                    throw new IllegalArgumentException();
                }

                if (!gender.equals("Male") && !gender.equals("Female")) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
                typeOfAnimal = scanner.nextLine();
                continue;
            }

            switch (typeOfAnimal) {
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog.toString());
                    break;
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat.toString());
                    break;
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog.toString());
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten.toString());
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat.toString());
                    break;
            }

            typeOfAnimal = scanner.nextLine();
        }
    }
}
