package by.training.task05.controller;

import by.training.task05.controller.command.Command;
import by.training.task05.controller.command.CommandProvider;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    private static final char PARAM_DELIMETER = '-';

    public void executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(PARAM_DELIMETER));
        executionCommand = provider.takeCommand(commandName);

        executionCommand.execute(request);
    }
}
