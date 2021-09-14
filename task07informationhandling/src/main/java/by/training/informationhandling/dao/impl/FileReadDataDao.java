package by.training.informationhandling.dao.impl;

import by.training.informationhandling.dao.DaoException;
import by.training.informationhandling.dao.ReadDataDao;

import java.io.*;

public class FileReadDataDao implements ReadDataDao {
    public String readData(File file) throws DaoException {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fin = new FileInputStream(file)) {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            for (byte b : buffer) {
                stringBuilder.append((char) b);
            }
        } catch (IOException ex) {
            throw new DaoException(ex);
        }
        return stringBuilder.toString();
    }

}
