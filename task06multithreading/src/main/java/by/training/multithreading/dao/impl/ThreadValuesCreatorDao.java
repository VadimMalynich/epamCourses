package by.training.multithreading.dao.impl;

import by.training.multithreading.bean.ThreadValues;
import by.training.multithreading.dao.DaoException;
import by.training.multithreading.dao.ThreadValuesDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThreadValuesCreatorDao implements ThreadValuesDao {
    @Override
    public void createFromFile(ThreadValues values, File f) throws DaoException {
        int size = values.getSize();
        CreateFile.createThreadsValueFile(size, f);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (int i = 0; i < size; i++) {
                values.setElement(i, Integer.parseInt(br.readLine()));
            }
        } catch (IOException ex) {
            throw new DaoException(ex);
        }
    }
}
