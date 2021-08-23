package by.training.task08xml.service.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PostCardErrorHandler implements ErrorHandler {
//    private static final Logger userLogger = LogManager.getLogger(PostCardErrorHandler.class);

    public void warning(SAXParseException e) {
        System.out.println((getLineColumnNumber(e) + "-" + e.getMessage()));
    }
    public void error(SAXParseException e) {
        System.out.println(getLineColumnNumber(e) + " - " + e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        System.out.println(getLineColumnNumber(e) + " - " + e.getMessage());
    }
    private String getLineColumnNumber(SAXParseException e) {
        // determine line and position of error
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
