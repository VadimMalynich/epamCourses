package by.training.informationhandling.service;

import java.io.File;
import java.util.List;

public interface ReadDataService {
    /**
     * Class that read all data that will be contained in file
     *
     * @param file from that will be read data
     * @return {@code String} with data
     * @throws ServiceException
     */
    String readData(File file) throws ServiceException;
}
