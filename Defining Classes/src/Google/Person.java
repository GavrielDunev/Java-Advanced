package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> children;
    private Car car;

    public Person() {
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.children;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
