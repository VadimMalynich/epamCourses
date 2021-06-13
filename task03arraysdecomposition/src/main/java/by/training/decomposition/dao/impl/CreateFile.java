package by.training.decomposition.dao.impl;

import by.training.decomposition.dao.DAOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public void createFile(File file) throws DAOException {
        final int MAX_VALUE = 1000;
        final int MIN_VALUE = -1000;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            int arr[] = new int[1000];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
                bw.write(String.valueOf(arr[i]));
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
