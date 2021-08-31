package by.training.multithreading.controller.command.impl;

import by.training.multithreading.bean.Matrix;
import by.training.multithreading.bean.MatrixValues;
import by.training.multithreading.controller.command.Command;
import by.training.multithreading.service.FillingMatrixDiagonalService;
import by.training.multithreading.service.ServiceFactory;
import by.training.multithreading.view.UserOutput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class FillingByCyclicBarrier implements Command {
    private static final Logger userLogger = LogManager.getLogger(FillingByCyclicBarrier.class);

    @Override
    public void execute(String request) {

        UserOutput printer = new UserOutput();
        ServiceFactory factory = ServiceFactory.getInstance();
        FillingMatrixDiagonalService fillingMatrixDiagonalService = factory.getFillingByCyclicBarrier();
        fillingMatrixDiagonalService.fillingMainDiagonal();
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            userLogger.error(e);
        }

        printer.printMessage("Diagonal elements changed once: " + fillingMatrixDiagonalService.checkNumberChanges());

    }
}
