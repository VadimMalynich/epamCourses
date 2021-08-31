package by.training.multithreading.controller.command.impl;

import by.training.multithreading.bean.ThreadValues;
import by.training.multithreading.controller.Controller;
import by.training.multithreading.service.state.MatrixState;
import by.training.multithreading.view.MessageManager;
import by.training.multithreading.view.UserOutput;
import by.training.multithreading.view.UserReader;

public class Main {

    public static void main(String[] args) {
        MessageManager messageManager = MessageManager.EN;
        UserReader reader = new UserReader();
        UserOutput print = new UserOutput();
        Controller controller = new Controller();
        MatrixState matrixState = new MatrixState();

        print.printMessage(messageManager.getString("enterMatrixSize"));
        int matrixSize = reader.enterInt(messageManager);
        print.printMessage(messageManager.getString("enterThreadsCount"));
        int threadCounts = reader.enterInt(messageManager);
        ThreadValues threadValues = ThreadValues.getInstance(threadCounts);

        controller.executeTask("create_data-" + matrixSize + "-" + threadCounts);
        print.printEmptyString();
        print.printMessage(threadValues.toString());
        matrixState.initializationResult();
        controller.executeTask("filling_by_cyclic_barrier-");
        matrixState.changeResult();
        matrixState.changeResult();
    }
}
