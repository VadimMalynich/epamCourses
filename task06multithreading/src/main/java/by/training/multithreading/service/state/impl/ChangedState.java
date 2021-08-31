package by.training.multithreading.service.state.impl;

import by.training.multithreading.bean.Matrix;
import by.training.multithreading.service.state.MatrixState;
import by.training.multithreading.service.state.State;

public class ChangedState implements State {
    private static final String NAME = "changed state";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void initializationResult(MatrixState state) {
        state.setState(new InitializedState());
    }

    @Override
    public void changeResult(MatrixState state) {
        PRINTER.printMessage("Changed matrix: \n");
        Matrix matrix = Matrix.getInstance();
        PRINTER.printMessage(matrix.toString());
        StringBuilder stringBuilder = new StringBuilder("The number of modified main diagonal elements:\n");
        for (int i = 0; i < matrix.getSize(); i++) {
            stringBuilder.append(matrix.getElement(i, i).getChangeCounter()).append("; ");
        }
        PRINTER.printMessage(stringBuilder.toString());
    }
}
