package by.training.task08xml.service.builder;

import by.training.task08xml.bean.AdPostcard;
import by.training.task08xml.bean.GreetingPostcard;
import by.training.task08xml.bean.Postcard;
import by.training.task08xml.bean.PostcardsXMLTag;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static by.training.task08xml.service.validators.ValidateData.*;

/**
 * Parser class that will be parsed xml file by StAX model. Extends from {@link AbstractPostcardsBuilder}
 */
public class PostcardStAXBuilder extends AbstractPostcardsBuilder {
    private XMLInputFactory inputFactory;

    public PostcardStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildSetPostcards(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(PostcardsXMLTag.POSTCARD.getValue())) {
                        Postcard postcard = buildPostcard(reader);
                        postcards.add(postcard);
                    } else if (name.equals(PostcardsXMLTag.AD_CARD.getValue())) {
                        AdPostcard adCard = buildAdPostcard(reader);
                        adPostcards.add(adCard);
                    } else if (name.equals(PostcardsXMLTag.GREETING_CARD.getValue())) {
                        GreetingPostcard greetingCard = buildGreetingPostcard(reader);
                        greetingPostcards.add(greetingCard);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Postcard buildPostcard(XMLStreamReader reader) throws XMLStreamException {
        Postcard postcard = new Postcard();
        postcard.setSerialNumber(reader.getAttributeValue(null, PostcardsXMLTag.SERIAL_NUMBER.getValue()));
        if (reader.getAttributeValue(null, PostcardsXMLTag.VALUABLE.getValue()) != null) {
            postcard.setValuable(reader.getAttributeValue(null, PostcardsXMLTag.VALUABLE.getValue()));
        }
        if (reader.getAttributeValue(null, PostcardsXMLTag.AUTHOR.getValue()) != null) {
            postcard.setAuthor(reader.getAttributeValue(null, PostcardsXMLTag.AUTHOR.getValue()));
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PostcardsXMLTag.valueOf(name.toUpperCase())) {
                        case COUNTRY -> postcard.setCountry(getXMLText(reader));
                        case YEAR -> postcard.setYear(convertYear(getXMLText(reader)));
                        case THEME -> postcard.setTheme(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PostcardsXMLTag.valueOf(name.toUpperCase()) == PostcardsXMLTag.POSTCARD) {
                        return postcard;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag <postcard>");
    }

    private AdPostcard buildAdPostcard(XMLStreamReader reader) throws XMLStreamException {
        AdPostcard adPostcard = new AdPostcard();
        adPostcard.setSerialNumber(reader.getAttributeValue(null, PostcardsXMLTag.SERIAL_NUMBER.getValue()));
        if (reader.getAttributeValue(null, PostcardsXMLTag.VALUABLE.getValue()) != null) {
            adPostcard.setValuable(reader.getAttributeValue(null, PostcardsXMLTag.VALUABLE.getValue()));
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName().replace('-', '_');
                    switch (PostcardsXMLTag.valueOf(name.toUpperCase())) {
                        case COUNTRY -> adPostcard.setCountry(getXMLText(reader));
                        case YEAR -> adPostcard.setYear(convertYear(getXMLText(reader)));
                        case COMPANY -> adPostcard.setCompany(getXMLText(reader));
                        case PHONE_NUMBER -> adPostcard.setPhoneNumber(Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName().replace('-', '_');
                    if (PostcardsXMLTag.valueOf(name.toUpperCase()) == PostcardsXMLTag.AD_CARD) {
                        return adPostcard;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag <ad-card>");
    }

    private GreetingPostcard buildGreetingPostcard(XMLStreamReader reader) throws XMLStreamException {
        GreetingPostcard greetingPostcard = new GreetingPostcard();
        greetingPostcard.setSerialNumber(reader.getAttributeValue(null, PostcardsXMLTag.SERIAL_NUMBER.getValue()));
        if (reader.getAttributeValue(null, PostcardsXMLTag.VALUABLE.getValue()) != null) {
            greetingPostcard.setValuable(reader.getAttributeValue(null, PostcardsXMLTag.VALUABLE.getValue()));
        }
        if (reader.getAttributeValue(null, PostcardsXMLTag.HOLIDAY.getValue()) != null) {
            greetingPostcard.setHoliday(convertHoliday(reader.getAttributeValue(null,
                    PostcardsXMLTag.HOLIDAY.getValue())));
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PostcardsXMLTag.valueOf(name.toUpperCase())) {
                        case COUNTRY -> greetingPostcard.setCountry(getXMLText(reader));
                        case YEAR -> greetingPostcard.setYear(convertYear(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName().replace('-', '_');
                    if (PostcardsXMLTag.valueOf(name.toUpperCase()) == PostcardsXMLTag.GREETING_CARD) {
                        return greetingPostcard;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag <greeting-card>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}