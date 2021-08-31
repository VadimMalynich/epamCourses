package by.training.multithreading.service.state.impl;

import by.training.multithreading.bean.Matrix;
import by.training.multithreading.service.state.MatrixState;
import by.training.multithreading.service.state.State;

public class InitializedState implements State {
    private static final String NAME = "initialized state";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void initializationResult(MatrixState state) {
        Matrix matrix = Matrix.getInstance();
        if (matrix != null) {
            PRINTER.printMessage("Initialized matrix: \n");
            PRINTER.printMessage(matrix.toString());
        } else {
            PRINTER.printMessage("Matrix didn't initialized");
        }
    }

    @Override
    public void changeResult(MatrixState state) {
        state.setState(new ChangedState());
    }
}
