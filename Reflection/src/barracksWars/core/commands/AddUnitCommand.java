package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

@NamedCommand(commandName = "add")
public class AddUnitCommand extends Command {
    Repository repository;
    UnitFactory unitFactory;

    public AddUnitCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd;
        try {
            unitToAdd = this.unitFactory.createUnit(unitType);
            this.repository.addUnit(unitToAdd);
            return unitType + " added!";

        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
    }
}
