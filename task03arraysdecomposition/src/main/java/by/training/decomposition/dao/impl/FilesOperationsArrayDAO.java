package by.training.decomposition.dao.impl;

import by.training.decomposition.bean.Array;
import by.training.decomposition.dao.ArrayDAO;
import by.training.decomposition.dao.DAOException;

import java.io.*;

public class FilesOperationsArrayDAO implements ArrayDAO {
    @Override
    public void createFromFile(Array array, File f) throws DAOException {
        int size = array.getLength();
        if (!f.isFile()) {
            CreateFile cf = new CreateFile();
            cf.createFile(f);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (int i = 0; i < size; i++) {
                array.setValue(Double.parseDouble(br.readLine()), i);
            }
        } catch (IOException ex) {
            throw new DAOException(ex);
        }
    }

    @Override
    public String writeSortingResults(Array array, File f) throws DAOException {
        int length = array.getLength();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, false))) {
            for (int i = 0; i < length; i++) {
                bw.write(String.valueOf(array.getValue(i)));
                bw.write(" ");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        return f.getPath();
    }
}
