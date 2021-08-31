package by.training.multithreading.controller.command;

import by.training.multithreading.controller.command.impl.CreateData;
import by.training.multithreading.controller.command.impl.FillingByCyclicBarrier;
import by.training.multithreading.controller.command.impl.FillingByLock;
import by.training.multithreading.controller.command.impl.WrongRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();
    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.CREATE_DATA, new CreateData());
        commands.put(CommandName.FILLING_BY_LOCK, new FillingByLock());
        commands.put(CommandName.FILLING_BY_CYCLIC_BARRIER, new FillingByCyclicBarrier());
    }

    public Command takeCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            userLogger.warn("Unable to receive command!", e);
            command = commands.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
