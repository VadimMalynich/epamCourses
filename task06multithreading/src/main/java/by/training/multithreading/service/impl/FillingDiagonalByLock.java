package by.training.multithreading.service.impl;

import by.training.multithreading.bean.LockThread;
import by.training.multithreading.bean.Matrix;
import by.training.multithreading.bean.ThreadValues;
import by.training.multithreading.service.FillingMatrixDiagonalService;
import by.training.multithreading.service.ServiceException;

import java.util.concurrent.locks.ReentrantLock;

public class FillingDiagonalByLock implements FillingMatrixDiagonalService {

    @Override
    public void fillingMainDiagonal() {
        ThreadValues threadValues = ThreadValues.getInstance();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < threadValues.getSize(); i++) {
            Thread lockThread = new Thread(new LockThread(locker, threadValues.getElement(i)));
            lockThread.setName("Lock thread # " + i);
            lockThread.start();
        }
    }
}
