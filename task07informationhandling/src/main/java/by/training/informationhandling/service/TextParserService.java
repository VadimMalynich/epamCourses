package by.training.informationhandling.service;

import by.training.informationhandling.bean.Composite;

public interface TextParserService {
    /**
     * Method parse text for all {@link by.training.informationhandling.bean.Type}
     *
     * @param text that was read from file
     * @return object of {@code Composite}
     * @throws ServiceException
     */
    Composite parseText(String text) throws ServiceException;
}
