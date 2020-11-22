package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        Map<String, List<Field>> fieldsWithModifiers = new HashMap<>();
        fieldsWithModifiers.put("private", new ArrayList<>());
        fieldsWithModifiers.put("protected", new ArrayList<>());
        fieldsWithModifiers.put("public", new ArrayList<>());
        fieldsWithModifiers.put("all", new ArrayList<>());

        for (Field field : declaredFields) {
            fieldsWithModifiers.get(Modifier.toString(field.getModifiers())).add(field);
            fieldsWithModifiers.get("all").add(field);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        StringBuilder sb = new StringBuilder();
        while (!input.equals("HARVEST")) {
            sb.append(fieldsWithModifiers.get(input)
                    .stream().map(f -> String.format("%s %s %s", Modifier.toString(f.getModifiers()),
                            f.getType().getSimpleName(), f.getName()))
                    .collect(Collectors.joining(System.lineSeparator())
                    ));
            sb.append(System.lineSeparator());
            input = bufferedReader.readLine();
        }
        System.out.println(sb.toString().trim());
    }
}
