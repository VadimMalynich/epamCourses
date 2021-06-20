package by.training.task04.controller;

import by.training.task04.controller.command.Command;
import by.training.task04.controller.command.CommandProvider;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = '-';

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.takeCommand(commandName);

        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
