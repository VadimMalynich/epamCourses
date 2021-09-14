package by.training.informationhandling.controller.command;

import by.training.informationhandling.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();
    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.READ_DATA, new ReadData());
        commands.put(CommandName.PARSE_DATA, new ParseData());
        commands.put(CommandName.SORT_PARAGRAPHS, new SortParagraphs());
        commands.put(CommandName.SORT_LEXEMES, new SortLexemes());
        commands.put(CommandName.SORT_WORDS, new SortWords());
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
