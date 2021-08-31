package by.training.multithreading.service.impl;

import by.training.multithreading.bean.CyclicBarrierThread;
import by.training.multithreading.bean.ThreadValues;
import by.training.multithreading.service.FillingMatrixDiagonalService;

import java.util.concurrent.CyclicBarrier;

public class FillingDiagonalByCyclicBarrier implements FillingMatrixDiagonalService {
    @Override
    public void fillingMainDiagonal() {
        ThreadValues threadValues = ThreadValues.getInstance();
        int size = threadValues.getSize();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);
        for (int i = 0; i < size; i++) {
            CyclicBarrierThread thread = new CyclicBarrierThread(cyclicBarrier, threadValues.getElement(i));
            thread.setName("Cyclic barrier thread # " + i);
            thread.start();
        }
    }
}
