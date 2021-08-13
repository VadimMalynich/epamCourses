package by.training.task05.service;

import java.io.File;
import java.util.List;

public interface ReadDataService {
    /**
     * Class that read all data that will be contained in file
     *
     * @param file from that will be read data
     * @return {@code List} of strings with data
     * @throws ServiceException
     */
    List<String> readData(File file) throws ServiceException;
}
