package by.training.multithreading.dao.impl;

import by.training.multithreading.dao.DaoException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

    private CreateFile() {
    }

    public static void createMatrixFile(int elementsAmount, File file) throws DaoException {
        final int MAX_VALUE = 1000;
        final int MIN_VALUE = -1000;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            int arr[] = new int[elementsAmount];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
                bw.write(String.valueOf(arr[i]));
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    public static void createThreadsValueFile(int amount, File file) throws DaoException {
        final int MAX_VALUE = 1000;
        int arr[] = new int[amount];
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (1 + Math.random() * MAX_VALUE);
                bw.write(String.valueOf(arr[i]));
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
