package by.training.task08xml.service.builder;

import by.training.task08xml.bean.AdPostcard;
import by.training.task08xml.bean.GreetingPostcard;
import by.training.task08xml.bean.Postcard;
import by.training.task08xml.service.exceptions.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static by.training.task08xml.service.validators.ValidateData.*;

/**
 * Parser class that will be parsed xml file by DOM model. Extends from {@link AbstractPostcardsBuilder}
 */
public class PostcardDOMBuilder extends AbstractPostcardsBuilder{
    private DocumentBuilder docBuilder;

    public PostcardDOMBuilder() throws ServiceException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ServiceException(e);
        }
    }

    public void buildSetPostcards(String filename) throws ServiceException {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();

            NodeList postcardsList = root.getElementsByTagName("postcard");
            NodeList adCardsList = root.getElementsByTagName("ad-card");
            NodeList greetingCardsList = root.getElementsByTagName("greeting-card");

            for (int i = 0; i < postcardsList.getLength(); i++) {
                Element postcardElement = (Element) postcardsList.item(i);
                Postcard postcard = buildPostcard(postcardElement);
                postcards.add(postcard);
            }

            for (int i = 0; i < adCardsList.getLength(); i++) {
                Element adCardElement = (Element) adCardsList.item(i);
                AdPostcard adCard = buildAdCard(adCardElement);
                adPostcards.add(adCard);
            }

            for (int i = 0; i < greetingCardsList.getLength(); i++) {
                Element greetingCardElement = (Element) greetingCardsList.item(i);
                GreetingPostcard greetingCard = buildGreetingCard(greetingCardElement);
                greetingPostcards.add(greetingCard);
            }
        } catch (IOException | SAXException e) {
            throw new ServiceException(e);
        }
    }

    private Postcard buildPostcard(Element postcardElement) {
        Postcard postcard = new Postcard();
        postcard.setSerialNumber(postcardElement.getAttribute("serial-number"));
        if (postcardElement.hasAttribute("valuable")) {
            postcard.setValuable(postcardElement.getAttribute("valuable"));
        }
        if (postcardElement.hasAttribute("author")) {
            postcard.setAuthor(postcardElement.getAttribute("author"));
        }
        postcard.setCountry(getElementTextContent(postcardElement, "country"));
        postcard.setYear(convertYear(getElementTextContent(postcardElement, "year")));
        postcard.setTheme(getElementTextContent(postcardElement, "theme"));
        return postcard;
    }

    private AdPostcard buildAdCard(Element adCardElement) {
        AdPostcard adPostcard = new AdPostcard();
        adPostcard.setSerialNumber(adCardElement.getAttribute("serial-number"));
        if (adCardElement.hasAttribute("valuable")) {
            adPostcard.setValuable(adCardElement.getAttribute("valuable"));
        }
        adPostcard.setCountry(getElementTextContent(adCardElement, "country"));
        adPostcard.setYear(convertYear(getElementTextContent(adCardElement, "year")));
        adPostcard.setCompany(getElementTextContent(adCardElement, "company"));
        adPostcard.setPhoneNumber(Integer.parseInt(getElementTextContent(adCardElement, "phone-number")));
        return adPostcard;
    }

    private GreetingPostcard buildGreetingCard(Element greetingCardElement) {
        GreetingPostcard greetingPostcard = new GreetingPostcard();
        greetingPostcard.setSerialNumber(greetingCardElement.getAttribute("serial-number"));
        if (greetingCardElement.hasAttribute("valuable")) {
            greetingPostcard.setValuable(greetingCardElement.getAttribute("valuable"));
        }
        if (greetingCardElement.hasAttribute("holiday")) {
            greetingPostcard.setHoliday(convertHoliday(greetingCardElement.getAttribute("holiday")));
        }
        greetingPostcard.setCountry(getElementTextContent(greetingCardElement, "country"));
        greetingPostcard.setYear(convertYear(getElementTextContent(greetingCardElement, "year")));
        return greetingPostcard;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}