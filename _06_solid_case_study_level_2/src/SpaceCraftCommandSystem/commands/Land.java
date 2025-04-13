package SpaceCraftCommandSystem.commands;

public class Land implements ICommand {
    @Override
    public void execute() {
        System.out.println("Land command executed.");
    }
}
