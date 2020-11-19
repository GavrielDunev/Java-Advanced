package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static class MethodCompareByName implements Comparator<Method> {
        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) {

        Class<?> clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();
        Set<Field> mistakenFields = new TreeSet<>(Comparator.comparing(Field::getName));
        mistakenFields.addAll(
                Arrays.stream(fields)
                        .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                        .collect(Collectors.toList()));

        mistakenFields.forEach(f -> System.out.println(f.getName() + " must be private!"));

        Method[] declaredMethods = clazz.getDeclaredMethods();
        Set<Method> mistakenGetters = new TreeSet<>(new MethodCompareByName());
        Set<Method> mistakenSetters = new TreeSet<>(new MethodCompareByName());
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get") && declaredMethod.getParameterCount() == 0
                    && !Modifier.isPublic(declaredMethod.getModifiers())) {
                mistakenGetters.add(declaredMethod);
            } else if (declaredMethod.getName().startsWith("set") && declaredMethod.getParameterCount() == 1
                    && !Modifier.isPrivate(declaredMethod.getModifiers())) {
                mistakenSetters.add(declaredMethod);
            }
        }
        mistakenGetters.stream()
                .map(g -> String.format("%s have to be public!", g.getName()))
                .forEach(System.out::println);

        mistakenSetters.stream()
                .map(s -> s.getName() + " have to be private!")
                .forEach(System.out::println);

    }
}
