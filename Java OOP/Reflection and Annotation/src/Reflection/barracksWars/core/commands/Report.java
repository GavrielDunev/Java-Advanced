package barracksWars.core.commands;

import barracksWars.core.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Report extends Command {
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.reportCommand();
    }

    private String reportCommand() {
        return super.getRepository().getStatistics();
    }
}
