package StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        int result = first.getName().length() - second.getName().length();
        if (result == 0) {
            result = first.getName().toLowerCase().compareTo(second.getName().toLowerCase());
        }
        return result;
    }
}
