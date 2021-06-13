package by.training.decomposition.dao.impl;

import by.training.decomposition.bean.Matrix;
import by.training.decomposition.dao.DAOException;
import by.training.decomposition.dao.MatrixDao;

import java.io.*;

public class MatrixCreatorDAO implements MatrixDao {
    @Override
    public void fillRandomized(Matrix matrix, int minValue, int maxValue) throws DAOException {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
                matrix.setElement(i, j, value);
            }
        }
    }

    @Override
    public int[][] createArray(int n, int m, int minValue, int maxValue) throws DAOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random() * (maxValue - minValue)) + minValue);
            }
        }
        return arr;
    }

    @Override
    public void createFromFile(Matrix matrix, File f) throws DAOException {
        if (!f.isFile()) {
            CreateFile cf = new CreateFile();
            cf.createFile(f);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (int i = 0; i < matrix.getVerticalSize(); i++) {
                for (int j = 0; j < matrix.getHorizontalSize(); j++) {
                    matrix.setElement(i, j, Integer.parseInt(br.readLine()));
                }
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }
}
