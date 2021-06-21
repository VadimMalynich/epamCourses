package by.training.decomposition.controller.command.impl;

import by.training.decomposition.controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequest implements Command {
    private static final Logger userLogger = LogManager.getLogger(WrongRequest.class);

    @Override
    public String execute(String request) {
        userLogger.fatal(request);
        return "This request does not exist!";
    }
}
