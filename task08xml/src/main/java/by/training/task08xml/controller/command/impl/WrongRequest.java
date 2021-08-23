package by.training.task08xml.controller.command.impl;

import by.training.task08xml.controller.command.ConsoleCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequest implements ConsoleCommand {
    private static final Logger userLogger = LogManager.getLogger(WrongRequest.class);

    @Override
    public void execute(String request) {
        userLogger.fatal(request);
        userLogger.info("This request does not exist!");
    }
}
