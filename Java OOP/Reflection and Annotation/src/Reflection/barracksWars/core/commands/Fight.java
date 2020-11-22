package barracksWars.core.commands;

import barracksWars.core.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Fight extends Command {
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.fightCommand();
    }

    private String fightCommand() {
        return "fight";
    }
}
