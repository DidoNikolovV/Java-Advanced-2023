package barracksWars.core.commands;

import barracksWars.interfaces.Repository;


@NamedCommand(commandName = "report")
public class ReportCommand extends Command{

    Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
