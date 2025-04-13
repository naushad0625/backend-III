package SpaceCraftCommandSystem.commands;

import SpaceCraftCommandSystem.Logger;
import SpaceCraftCommandSystem.Simulator;
import SpaceCraftCommandSystem.Validator;

public class CommandExecutionManager {

    private Logger logger;
    private Simulator simulator;
    private Validator validator;
    private ICommand command;

    public CommandExecutionManager(Logger logger, Simulator simulator, Validator validator) {
        this.logger = logger;
        this.simulator = simulator;
        this.validator = validator;
    }

    public CommandExecutionManager log (ICommand command) {
        //TODO
        logger.log(command);
        return this;
    }

    public CommandExecutionManager validate (ICommand command) {
        //TODO
        validator.validate(command);
        return this;
    }

    public CommandExecutionManager simulate (ICommand command) {
        //TODO
        simulator.simulate(command);
        return this;
    }

    public void execute (ICommand command) {
        //TODO
        command.execute();
    }
}
