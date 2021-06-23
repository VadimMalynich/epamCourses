package by.training.decomposition.controller;

import by.training.decomposition.controller.command.Command;
import by.training.decomposition.controller.command.CommandProvider;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    private static final char PARAM_DELIMETER = '-';

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(PARAM_DELIMETER));
        executionCommand = provider.takeCommand(commandName);

        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
