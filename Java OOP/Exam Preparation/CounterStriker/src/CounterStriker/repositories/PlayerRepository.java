package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository<T extends Player> implements Repository<T> {
    private Collection<T> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(p -> p.getUsername().equals(name)).findFirst().orElse(null);
    }
}
