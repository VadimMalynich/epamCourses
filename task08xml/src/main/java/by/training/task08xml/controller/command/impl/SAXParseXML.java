package by.training.task08xml.controller.command.impl;

import by.training.task08xml.controller.command.ConsoleCommand;
import by.training.task08xml.service.builder.AbstractPostcardsBuilder;
import by.training.task08xml.service.builder.PostcardBuilderFactory;
import by.training.task08xml.service.exceptions.ServiceException;
import by.training.task08xml.service.validators.XMLFileValidator;
import by.training.task08xml.view.PrintPostcards;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SAXParseXML implements ConsoleCommand {
    private static final Logger userLogger = LogManager.getLogger(SAXParseXML.class);
    private static final String FILE_NAME = "src/main/resources/data/oldCards.xml";
    private static final String SCHEMA_FILE = "src/main/resources/data/oldCards.xsd";
    private static final String SAX_MESSAGE = "\n====================================================== SAX Parser =====================================================\n";

    @Override
    public void execute(String request) {
        try {
            XMLFileValidator validator = new XMLFileValidator();
            validator.validateXMLFile(FILE_NAME, SCHEMA_FILE);
            AbstractPostcardsBuilder postcardsBuilder = PostcardBuilderFactory.createPostcardBuilder("SAX");
            postcardsBuilder.buildSetPostcards(FILE_NAME);
            PrintPostcards printer = new PrintPostcards();
            printer.printMessage(SAX_MESSAGE);
            printer.printAllTypesPostcards(postcardsBuilder.getPostcards(), postcardsBuilder.getAdPostcards(),
                    postcardsBuilder.getGreetingPostcards());
        } catch (ServiceException e) {
            userLogger.error(e);
        }
    }
}
