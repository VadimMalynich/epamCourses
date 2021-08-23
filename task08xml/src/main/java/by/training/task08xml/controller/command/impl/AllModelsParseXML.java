package by.training.task08xml.controller.command.impl;

import by.training.task08xml.controller.command.ConsoleCommand;
import by.training.task08xml.service.builder.AbstractPostcardsBuilder;
import by.training.task08xml.service.builder.PostcardBuilderFactory;
import by.training.task08xml.service.exceptions.ServiceException;
import by.training.task08xml.service.validators.XMLFileValidator;
import by.training.task08xml.view.PrintPostcards;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AllModelsParseXML implements ConsoleCommand {
    private static final Logger userLogger = LogManager.getLogger(AllModelsParseXML.class);
    private static final String FILE_NAME = "src/main/resources/data/test.xml";
    private static final String SCHEMA_FILE = "src/main/resources/data/oldCards.xsd";
    private static final String DOM_MESSAGE = "\n====================================================== DOM Parser =====================================================\n";
    private static final String SAX_MESSAGE = "\n====================================================== SAX Parser =====================================================\n";
    private static final String STAX_MESSAGE = "\n===================================================== STAX Parser =====================================================\n";

    @Override
    public void execute(String request) {
        try {
            XMLFileValidator validator = new XMLFileValidator();
            validator.validateXMLFile(FILE_NAME, SCHEMA_FILE);
            AbstractPostcardsBuilder domBuilder = PostcardBuilderFactory.createPostcardBuilder("DOM");
            AbstractPostcardsBuilder saxBuilder = PostcardBuilderFactory.createPostcardBuilder("SAX");
            AbstractPostcardsBuilder staxBuilder = PostcardBuilderFactory.createPostcardBuilder("STAX");
            domBuilder.buildSetPostcards(FILE_NAME);
            saxBuilder.buildSetPostcards(FILE_NAME);
            staxBuilder.buildSetPostcards(FILE_NAME);
            PrintPostcards printer = new PrintPostcards();
            printer.printMessage(DOM_MESSAGE);
            printer.printAllTypesPostcards(domBuilder.getPostcards(), domBuilder.getAdPostcards(),
                    domBuilder.getGreetingPostcards());
            printer.printMessage(SAX_MESSAGE);
            printer.printAllTypesPostcards(saxBuilder.getPostcards(), saxBuilder.getAdPostcards(),
                    saxBuilder.getGreetingPostcards());
            printer.printMessage(STAX_MESSAGE);
            printer.printAllTypesPostcards(staxBuilder.getPostcards(), staxBuilder.getAdPostcards(),
                    staxBuilder.getGreetingPostcards());
        } catch (ServiceException e) {
            userLogger.error(e);
        }
    }
}
