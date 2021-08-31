package by.training.multithreading.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockThread implements Runnable {
    private static final Logger userLogger = LogManager.getLogger(LockThread.class);

    private Matrix matrix;
    private ReentrantLock locker;
    private int threadValue;

    public LockThread(ReentrantLock locker, int threadValue) {
        this.matrix = Matrix.getInstance();
        this.locker = locker;
        this.threadValue = threadValue;
    }

    @Override
    public void run() {
        try {
            userLogger.debug(Thread.currentThread().getName() + " start work");
            for (int i = 0; i < matrix.getSize(); i++) {
                locker.lock();
                if (matrix.getElement(i, i).getValue() == 0) {
                    matrix.changeDiagonalElement(i, threadValue);
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                locker.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locker.isLocked()) {
                locker.unlock();
            }
            userLogger.debug(Thread.currentThread().getName() + " end work");
        }
    }
}
