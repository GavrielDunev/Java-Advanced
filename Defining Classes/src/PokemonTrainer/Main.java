package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<Pokemon>> pokemons = new HashMap<>();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemons.putIfAbsent(trainerName, new ArrayList<>());
            pokemons.get(trainerName).add(pokemon);
            Trainer trainer = new Trainer(trainerName, pokemons);
            trainers.put(trainerName, trainer);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {

                for (Map.Entry<String, List<Pokemon>> entry : pokemons.entrySet()) {
                    List<Pokemon> currentListOfPokemons = entry.getValue();
                    boolean isElementContained = false;
                    for (Pokemon pokemon : currentListOfPokemons) {
                        if (pokemon.getElement().equals(input)) {
                            isElementContained = true;
                            break;
                        }
                    }
                    if (isElementContained) {
                        trainers.get(entry.getKey()).setBadges(trainers.get(entry.getKey()).getBadges() + 1);
                    } else {
                        List<Pokemon> toBeRemoved = new ArrayList<>();
                        for (Pokemon current : currentListOfPokemons) {
                            current.setHealth(current.getHealth() - 10);
                            if (current.getHealth() <= 0) {
                                toBeRemoved.add(current);
                            }
                        }
                        if (toBeRemoved.size() > 0) {
                            for (Pokemon s : toBeRemoved) {
                                currentListOfPokemons.remove(s);
                            }
                        }
                    }
                }

            input = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getBadges(), e1.getValue().getBadges()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue().getBadges()
                        + " " + pokemons.get(e.getKey()).size()));
    }
}
