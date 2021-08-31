package by.training.multithreading.controller.command.impl;

import by.training.multithreading.bean.Matrix;
import by.training.multithreading.controller.command.Command;
import by.training.multithreading.service.FillingMatrixDiagonalService;
import by.training.multithreading.service.ServiceFactory;
import by.training.multithreading.view.UserOutput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class FillingByLock implements Command {
    private static final Logger userLogger = LogManager.getLogger(FillingByLock.class);


    @Override
    public void execute(String request) {

        UserOutput printer = new UserOutput();
        ServiceFactory factory = ServiceFactory.getInstance();
        FillingMatrixDiagonalService fillingMatrixDiagonalService = factory.getFillingByLock();
        fillingMatrixDiagonalService.fillingMainDiagonal();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            userLogger.error(e);
        }
        printer.printMessage("Diagonal elements changed once: " + fillingMatrixDiagonalService.checkNumberChanges());

    }
}
