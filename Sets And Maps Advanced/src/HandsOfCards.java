import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] cards = input.split(": ")[1].split(", ");
            players.putIfAbsent(name, new LinkedHashSet<>());
            players.get(name).addAll(Arrays.asList(cards));
            input = scanner.nextLine();
        }

        Map<String, Integer> calculatedCards = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> player : players.entrySet()) {
            Map<Character, Integer> symbols = getPowers();
            int sum = 0;
            for (String cards : player.getValue()) {
                int power;
                int type;
                    if (cards.contains("10")) {
                        power = 10;
                        type = symbols.get(cards.charAt(2));
                    } else {
                        power = symbols.get(cards.charAt(0));
                        type = symbols.get(cards.charAt(1));
                    }
                sum += power * type;
            }
            calculatedCards.put(player.getKey(), sum);
        }
        for (Map.Entry<String, Integer> player : calculatedCards.entrySet()) {
            System.out.printf("%s: %d%n", player.getKey(), player.getValue());
        }


    }
    public static HashMap<Character,Integer> getPowers() {
        HashMap<Character, Integer> symbols = new HashMap<>();
        symbols.put('2', 2);
        symbols.put('3', 3);
        symbols.put('4', 4);
        symbols.put('5', 5);
        symbols.put('6', 6);
        symbols.put('7', 7);
        symbols.put('8', 8);
        symbols.put('9', 9);
        symbols.put('J', 11);
        symbols.put('Q', 12);
        symbols.put('K', 13);
        symbols.put('A', 14);
        symbols.put('S', 4);
        symbols.put('H', 3);
        symbols.put('D', 2);
        symbols.put('C', 1);
        return symbols;
    }
}
