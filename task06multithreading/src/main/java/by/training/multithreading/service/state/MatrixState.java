package by.training.multithreading.service.state;

import by.training.multithreading.service.state.impl.InitializedState;
import by.training.multithreading.view.UserOutput;

public class MatrixState {
    private static UserOutput printer = new UserOutput();
    private State state = new InitializedState();

    public void initializationResult() {
        state.initializationResult(this);
    }

    public void changeResult() {
        state.changeResult(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        printer.printMessage("Change state to " + state.getName());
        this.state = state;
    }
}
