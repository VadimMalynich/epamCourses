package by.training.multithreading.controller;

import by.training.multithreading.controller.command.Command;
import by.training.multithreading.controller.command.CommandProvider;

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
