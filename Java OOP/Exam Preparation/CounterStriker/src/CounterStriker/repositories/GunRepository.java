package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository<T extends Gun> implements Repository<T> {
    private Collection<T> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
