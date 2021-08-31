package by.training.multithreading.dao.impl;

import by.training.multithreading.bean.Matrix;
import by.training.multithreading.dao.DaoException;
import by.training.multithreading.dao.MatrixDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MatrixCreatorDao implements MatrixDao {
    @Override
    public void createFromFile(Matrix matrix, File f) throws DaoException {
        int size = matrix.getSize();
        int amountElements = size * size;
        CreateFile.createMatrixFile(amountElements, f);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix.setElement(i, j, Integer.parseInt(br.readLine()));
                }
            }
            for (int i = 0; i < size; i++) {
                matrix.setElement(i, i, 0);
            }
        } catch (IOException ex) {
            throw new DaoException(ex);
        }
    }
}
