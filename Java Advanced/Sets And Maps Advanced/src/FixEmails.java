import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        int count = 1;
        String name = "";
        while (!input.equals("stop")) {
            if (count % 2 != 0) {
                name = input;
            } else {
                emails.put(name, input);
            }
            input = scanner.nextLine();
            count++;
        }

        List<String> namesToBeRemoved = new ArrayList<>();
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            int lastIndex = entry.getValue().lastIndexOf(".");
            String domain = entry.getValue().substring(lastIndex + 1);
            if (domain.equalsIgnoreCase("uk") || domain.equalsIgnoreCase("us")
            || domain.equalsIgnoreCase("com")) {
                namesToBeRemoved.add(entry.getKey());
            }
        }

        for (String currentName : namesToBeRemoved) {
            emails.remove(currentName);
        }

        emails.forEach((key,value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
