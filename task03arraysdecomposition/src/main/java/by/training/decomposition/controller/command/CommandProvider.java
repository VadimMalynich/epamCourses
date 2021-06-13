package by.training.decomposition.controller.command;

import by.training.decomposition.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();
    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.MULTIPLY_MATRICES, new MultiplyMatrices());
        commands.put(CommandName.TRANSPOSE_MATRIX, new TransposeMatrix());
        commands.put(CommandName.MULTIPLY_MATRIX_ON_VALUE, new MultiplyMatrixOnValue());
        commands.put(CommandName.SUM_OR_DIFF_MATRICES, new SumAndDiffMatrices());
        commands.put(CommandName.BINARY_MERGE_SORT, new BinaryMerge());
        commands.put(CommandName.BUBBLE_SORT, new Bubble());
        commands.put(CommandName.INSERT_SORT, new InsertSort());
        commands.put(CommandName.SHAKER_SORT, new Shaker());
        commands.put(CommandName.SHELL_SORT, new Shell());
        commands.put(CommandName.SIMPLE_SELECTION_SORT, new SimpleSelection());
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
