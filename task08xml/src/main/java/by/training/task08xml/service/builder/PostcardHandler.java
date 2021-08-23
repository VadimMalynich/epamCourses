package by.training.task08xml.service.builder;

import by.training.task08xml.bean.AdPostcard;
import by.training.task08xml.bean.GreetingPostcard;
import by.training.task08xml.bean.Postcard;
import by.training.task08xml.bean.PostcardsXMLTag;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

import static by.training.task08xml.service.validators.ValidateData.*;

public class PostcardHandler extends DefaultHandler {
    private Set<Postcard> postcards;
    private Set<AdPostcard> adPostcards;
    private Set<GreetingPostcard> greetingPostcards;
    private Postcard postcard;
    private AdPostcard adCard;
    private GreetingPostcard greetingCard;
    private PostcardsXMLTag currentXMLTag;
    private EnumSet<PostcardsXMLTag> withText;
    private static final String ELEMENT_POSTCARD = "postcard";
    private static final String ELEMENT_AD_POSTCARD = "ad-card";
    private static final String ELEMENT_GREETING_POSTCARD = "greeting-card";
    private static final String SERIAL_NUMBER = PostcardsXMLTag.SERIAL_NUMBER.getValue();
    private static final String VALUABLE = PostcardsXMLTag.VALUABLE.getValue();
    private int cardType;

    public PostcardHandler() {
        postcards = new HashSet<>();
        adPostcards = new HashSet<>();
        greetingPostcards = new HashSet<>();
        withText = EnumSet.range(PostcardsXMLTag.COUNTRY, PostcardsXMLTag.PHONE_NUMBER);
    }

    public Set<Postcard> getPostcards() {
        return postcards;
    }

    public Set<AdPostcard> getAdPostcards() {
        return adPostcards;
    }

    public Set<GreetingPostcard> getGreetingPostcards() {
        return greetingPostcards;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (ELEMENT_POSTCARD.equals(qName)) {
            cardType = 1;
            postcard = new Postcard();
            postcard.setSerialNumber(attributes.getValue(SERIAL_NUMBER));
            if (attributes.getIndex(VALUABLE) != -1) {
                postcard.setValuable(attributes.getValue(attributes.getIndex(VALUABLE)));
            }
            if (attributes.getIndex(PostcardsXMLTag.AUTHOR.getValue()) != -1) {
                postcard.setAuthor(attributes.getValue(attributes.getIndex(PostcardsXMLTag.AUTHOR.getValue())));
            }
        } else if (ELEMENT_AD_POSTCARD.equals(qName)) {
            cardType = 2;
            adCard = new AdPostcard();
            adCard.setSerialNumber(attributes.getValue(SERIAL_NUMBER));
            if (attributes.getIndex(VALUABLE) != -1) {
                adCard.setValuable(attributes.getValue(attributes.getIndex(VALUABLE)));
            }
        } else if (ELEMENT_GREETING_POSTCARD.equals(qName)) {
            cardType = 3;
            greetingCard = new GreetingPostcard();
            greetingCard.setSerialNumber(attributes.getValue(SERIAL_NUMBER));
            if (attributes.getIndex(VALUABLE) != -1) {
                greetingCard.setValuable(attributes.getValue(attributes.getIndex(VALUABLE)));
            }
            if (attributes.getIndex(PostcardsXMLTag.HOLIDAY.getValue()) != -1) {
                String date = attributes.getValue(attributes.getIndex(PostcardsXMLTag.HOLIDAY.getValue()));
                greetingCard.setHoliday(convertHoliday(date));
            }
        } else {
            currentXMLTag = null;
            PostcardsXMLTag temp = PostcardsXMLTag.valueOf(qName.toUpperCase().replace('-', '_'));
            if (withText.contains(temp)) {
                currentXMLTag = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (ELEMENT_POSTCARD.equals(qName)) {
            postcards.add(postcard);
        } else if (ELEMENT_AD_POSTCARD.equals(qName)) {
            adPostcards.add(adCard);
        } else if (ELEMENT_GREETING_POSTCARD.equals(qName)) {
            greetingPostcards.add(greetingCard);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).strip();
        if (currentXMLTag != null) {
            switch (currentXMLTag) {
                case COUNTRY:
                    if (cardType == 1) {
                        postcard.setCountry(data);
                    } else if (cardType == 2) {
                        adCard.setCountry(data);
                    } else if (cardType == 3) {
                        greetingCard.setCountry(data);
                    }
                    break;
                case YEAR:
                    if (cardType == 1) {
                        postcard.setYear(convertYear(data));
                    } else if (cardType == 2) {
                        adCard.setYear(convertYear(data));
                    } else if (cardType == 3) {
                        greetingCard.setYear(convertYear(data));
                    }
                    break;
                case THEME:
                    postcard.setTheme(data);
                    break;
                case COMPANY:
                    adCard.setCompany(data);
                    break;
                case PHONE_NUMBER:
                    adCard.setPhoneNumber(Integer.parseInt(data));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentXMLTag.getDeclaringClass(), currentXMLTag.name());
            }
        }
        currentXMLTag = null;
    }
}
