package by.training.task04.controller.command;

import by.training.task04.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();
    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.GENERATE_DATA, new GenerateData());
        commands.put(CommandName.BLOCK_ACTIVATE_ALL, new BlockOrActiveAll());
        commands.put(CommandName.BLOCK_ACTIVATE_BY_ID, new BlockOrActiveByID());
        commands.put(CommandName.CALC_BALANCE_SUM, new CalcSumAccounts());
        commands.put(CommandName.FIND_BY_ACCOUNT_NUMBER, new FindByAccountNumber());
        commands.put(CommandName.FIND_BY_FIO, new FindByFIO());
        commands.put(CommandName.SORT_DATA, new SortData());
        commands.put(CommandName.FILTER_STATUS, new FilterDataStatus());
        commands.put(CommandName.FILTER_AMOUNT, new FilterDataBalance());
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
