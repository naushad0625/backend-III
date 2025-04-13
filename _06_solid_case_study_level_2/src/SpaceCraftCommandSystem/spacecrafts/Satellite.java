package SpaceCraftCommandSystem.spacecrafts;

import SpaceCraftCommandSystem.commands.CommandExecutionManager;
import SpaceCraftCommandSystem.commands.ICommand;

public class Satellite implements ISpaceCraft {
    private ICommand command;
    private CommandExecutionManager executionManager;

    @Override
    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void setexEcutionManager(CommandExecutionManager executionManager) {
        this.executionManager = executionManager;
    }

    @Override
    public void executeCommand() {
        //TODO
        executionManager.log(command).validate(command).simulate(command).execute(command);
    }
}
