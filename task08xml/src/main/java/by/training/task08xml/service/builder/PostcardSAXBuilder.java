package by.training.task08xml.service.builder;
import by.training.task08xml.service.exceptions.PostCardErrorHandler;
import by.training.task08xml.service.exceptions.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Parser class that will be parsed xml file by SAX model. Extends from {@link AbstractPostcardsBuilder}
 */
public class PostcardSAXBuilder extends AbstractPostcardsBuilder{
    private PostcardHandler handler = new PostcardHandler();
    private XMLReader reader;

    public PostcardSAXBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        reader.setErrorHandler(new PostCardErrorHandler());
        reader.setContentHandler(handler);
    }

    public void buildSetPostcards(String filename) throws ServiceException {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            throw new ServiceException(e);
        }
        postcards = handler.getPostcards();
        adPostcards = handler.getAdPostcards();
        greetingPostcards = handler.getGreetingPostcards();
    }
}
