package SpaceCraftCommandSystem.commands;

public class Move implements ICommand {
    @Override
    public void execute() {
        System.out.println("Move command executed.");
    }
}
