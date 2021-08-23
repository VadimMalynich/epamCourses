package by.training.task08xml.service.saxparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConsolePostcardHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String tagData = qName + " ";
        for (int i = 0; i < attributes.getLength(); i++) {
            tagData += " " + attributes.getQName(i) + "=" + attributes.getValue(i);
        }
        System.out.print(tagData);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print(" " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nParsing ended");
    }
}
