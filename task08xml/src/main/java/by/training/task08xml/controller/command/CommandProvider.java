package by.training.task08xml.controller.command;

import by.training.task08xml.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, ConsoleCommand> consoleCommands = new HashMap<>();
    private Map<CommandName, WebCommand> webCommands = new HashMap<>();
//    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        consoleCommands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        consoleCommands.put(CommandName.DOM_PARSE_XML, new DOMParseXML());
        consoleCommands.put(CommandName.SAX_PARSE_XML, new SAXParseXML());
        consoleCommands.put(CommandName.STAX_PARSE_XML, new StAXParseXML());
        consoleCommands.put(CommandName.ALL_MODELS_PARSE_XML, new AllModelsParseXML());
       // webCommands.put(CommandName.PARSE_UPLOAD_FILE, new ParseUploadFile());
    }

    public ConsoleCommand takeConsoleCommand(String name) {
        CommandName commandName = null;
        ConsoleCommand consoleCommand = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            consoleCommand = consoleCommands.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            final Logger userLogger = LogManager.getLogger(CommandProvider.class);
            userLogger.warn("Unable to receive command!", e);
            consoleCommand = consoleCommands.get(CommandName.WRONG_REQUEST);
        }
        return consoleCommand;
    }

    public WebCommand takeWebCommand(String name) {
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return webCommands.get(commandName);
    }
}
