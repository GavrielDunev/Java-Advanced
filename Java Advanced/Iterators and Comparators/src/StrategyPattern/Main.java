package StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> peopleSortedByName = new TreeSet<Person>(new ComparatorByName());
        TreeSet<Person> peopleSortedByAge = new TreeSet<Person>(new ComparatorByAge());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }
        peopleSortedByName.forEach(System.out::println);
        peopleSortedByAge.forEach(System.out::println);
    }
}
