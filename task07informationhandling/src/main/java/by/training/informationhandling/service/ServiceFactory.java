package by.training.informationhandling.service;

import by.training.informationhandling.service.impl.ReadDataServiceImpl;
import by.training.informationhandling.service.impl.TextParserServiceImpl;
import by.training.informationhandling.service.sorting.SortingLexemes;
import by.training.informationhandling.service.sorting.SortingParagraphsService;
import by.training.informationhandling.service.sorting.SortingWordsService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    private final ReadDataService readDataService = new ReadDataServiceImpl();
    private final TextParserService textParserService = new TextParserServiceImpl();
    private final SortingTextPartsService sortingParagraphs = new SortingParagraphsService();
    private final SortingTextPartsService sortingWords = new SortingWordsService();
    private final SortLexemesService sortLexemes = new SortingLexemes();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ReadDataService getReadDataService() {
        return readDataService;
    }

    public TextParserService getTextParserService() {
        return textParserService;
    }

    public SortingTextPartsService getSortingParagraphs() {
        return sortingParagraphs;
    }

    public SortingTextPartsService getSortingWords() {
        return sortingWords;
    }

    public SortLexemesService getSortLexemes() {
        return sortLexemes;
    }
}
