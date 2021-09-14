package by.training.informationhandling.service;

import by.training.informationhandling.bean.Composite;

import java.util.List;

public interface SortingTextPartsService {
    /**
     * Method that sorted parts of parsed text
     * @param composite object that contains all text parts
     * @return sorted text like {@code List<String>} by specification
     * @throws ServiceException
     */
    List<String> getSortedData(Composite composite) throws ServiceException;
}
