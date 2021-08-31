package by.training.multithreading.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierThread extends Thread {
    private static final Logger userLogger = LogManager.getLogger(CyclicBarrierThread.class);

    private Matrix matrix;
    private CyclicBarrier barrier;
    private int threadValue;

    public CyclicBarrierThread(CyclicBarrier barrier, int threadValue) {
        this.matrix = Matrix.getInstance();
        this.barrier = barrier;
        this.threadValue = threadValue;
    }

    @Override
    public void run() {
        try {
            userLogger.debug(Thread.currentThread().getName() + " start work");
            for (int i = 0; i < matrix.getSize(); i++) {
                barrier.await(100, TimeUnit.MILLISECONDS);

                if (matrix.getElement(i, i).getValue() == 0) {
                    matrix.changeDiagonalElement(i, threadValue);
                    userLogger.debug(Thread.currentThread().getName() + " continue work");
                }
                TimeUnit.MILLISECONDS.sleep(50);

            }
            // this.barrier.await();
            userLogger.debug(Thread.currentThread().getName() + " end work");
        } catch (TimeoutException | BrokenBarrierException | InterruptedException e) {
            userLogger.error(e);
        }
    }
}
