package by.training.multithreading.service.state;

import by.training.multithreading.view.UserOutput;

public interface State {
    UserOutput PRINTER = new UserOutput();
    String getName();
    void initializationResult(MatrixState state);
    void changeResult(MatrixState state);
}
