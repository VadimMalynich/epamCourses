package by.training.informationhandling.service;

import by.training.informationhandling.bean.Composite;

import java.util.List;

public interface SortLexemesService {
    /**
     * Sort the tokens in the text in descending order of the number of occurrences of a given
     * character, and in case of equality – alphabetically.
     *
     * @param composite object that contains all text parts
     * @param symbol that count checks in lexemes
     * @return sorted text like {@code List<String>} by specification
     * @throws ServiceException
     */
    List<String> getSortedData(Composite composite, char symbol) throws ServiceException;
}
