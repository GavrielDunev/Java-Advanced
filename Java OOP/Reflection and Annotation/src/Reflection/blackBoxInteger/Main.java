package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, InstantiationException {
        Class<BlackBoxInt> blackBoxInt = BlackBoxInt.class;
        Constructor<?> ctor = blackBoxInt.getDeclaredConstructor(int.class);
        ctor.setAccessible(true);
        BlackBoxInt instance = (BlackBoxInt) ctor.newInstance(0);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            Method method = blackBoxInt.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(instance, value);
            Field innerValue = blackBoxInt.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            int number = innerValue.getInt(instance);
            System.out.println(number);
            input = scanner.nextLine();
        }
    }
}
