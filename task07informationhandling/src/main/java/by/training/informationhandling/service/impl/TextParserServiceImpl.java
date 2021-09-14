package by.training.informationhandling.service.impl;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.TextParserService;
import by.training.informationhandling.service.handler.*;

public class TextParserServiceImpl implements TextParserService {
    public Composite parseText(String text) throws ServiceException {
        if (text == null || text.length() <= 0) {
            throw new ServiceException("Incorrect text for parsing.");
        }
        Composite composite = new Composite(Type.TEXT);
        SymbolHandler symbolHandler = new SymbolHandler();
        WordHandler wordHandler = new WordHandler(symbolHandler);
        LexemeHandler lexemeHandler = new LexemeHandler(wordHandler);
        SentenceHandler sentenceHandler = new SentenceHandler(lexemeHandler);
        ParagraphHandler paragraphHandler = new ParagraphHandler(sentenceHandler);
        TextHandler textHandler = new TextHandler(paragraphHandler);
        textHandler.parse(text, composite);
        return composite;
    }
}
