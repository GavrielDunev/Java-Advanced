package PokemonTrainer;

import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int badges;
    private Map<String, List<Pokemon>> pokemons;

    public Trainer(String name, Map<String, List<Pokemon>> pokemons) {
        this.name = name;
        this.badges = 0;
        this.pokemons = pokemons;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public int getBadges() {
        return this.badges;
    }
}