package SpaceCraftCommandSystem;

import SpaceCraftCommandSystem.commands.ICommand;

public class Logger {
    public void log (ICommand command) {
        System.out.println("Command Logged");
    }
}
