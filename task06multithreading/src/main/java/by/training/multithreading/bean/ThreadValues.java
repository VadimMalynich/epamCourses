package by.training.multithreading.bean;

import java.util.Arrays;

public class ThreadValues {
    private int arr[];
    private static ThreadValues instance;

    private ThreadValues(int size) {
        arr = new int[size];
    }

    public static ThreadValues getInstance() {
        return instance;
    }

    public static ThreadValues getInstance(int size) {
        if (instance == null) {
            instance = new ThreadValues(size);
        }
        return instance;
    }

    public void setElement(int i, int value) {
        arr[i] = value;
    }

    public int getElement(int i) {
        return arr[i];
    }

    public int getSize() {
        return arr.length;
    }

    @Override
    public String toString() {
        return "ThreadValues{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
