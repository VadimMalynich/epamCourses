package by.training.task05.controller.command;

import by.training.task05.controller.command.impl.CalcTriangleParameters;
import by.training.task05.controller.command.impl.DefineTrianglesType;
import by.training.task05.controller.command.impl.WrongRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();
    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.CALC_TRIANGLE_PARAMETERS, new CalcTriangleParameters());
        commands.put(CommandName.DEFINE_TRIANGLES_TYPE, new DefineTrianglesType());
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
