package SpaceCraftCommandSystem;

import SpaceCraftCommandSystem.commands.CommandExecutionManager;
import SpaceCraftCommandSystem.commands.ICommand;
import SpaceCraftCommandSystem.commands.Move;
import SpaceCraftCommandSystem.spacecrafts.ISpaceCraft;
import SpaceCraftCommandSystem.spacecrafts.SpaceCraftFactory;

public class SpaceCraftManager {
    public static void main(String[] args) {
        ISpaceCraft spaceCraft = SpaceCraftFactory.create(SpaceCraftType.LANDER);
        ICommand command = new Move();
        CommandExecutionManager executionManager= new CommandExecutionManager(new Logger(), new Simulator(), new Validator());

        spaceCraft.setCommand(command);
        spaceCraft.setexEcutionManager(executionManager);

        spaceCraft.executeCommand();

    }
}
