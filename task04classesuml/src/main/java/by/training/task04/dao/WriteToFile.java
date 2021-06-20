package by.training.task04.dao;

import by.training.task04.bean.Bank;

import java.io.File;

public interface WriteToFile {

    /**
     * Method that write to file random generated data
     *
     * @param file in that will be writing generated data
     * @param bank generated data that should be written in file
     * @throws DAOException
     */
    void writeGenerateData(File file, Bank bank) throws DAOException;
}
