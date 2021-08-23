package by.training.task08xml.service.saxparser;

import by.training.task08xml.service.exceptions.PostCardErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxConsoleMain {
    public static void main(String[] args) {
        try {
            // SAX parser creating & configuring
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ConsolePostcardHandler());
            reader.setErrorHandler(new PostCardErrorHandler());
            reader.parse("src/main/resources/data/oldCards.xml");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
