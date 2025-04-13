package SpaceCraftCommandSystem.spacecrafts;

import SpaceCraftCommandSystem.commands.CommandExecutionManager;
import SpaceCraftCommandSystem.commands.ICommand;

public interface ISpaceCraft {
    public void setCommand (ICommand command);
    public void setexEcutionManager(CommandExecutionManager executionManager);
    public void executeCommand ();
}
