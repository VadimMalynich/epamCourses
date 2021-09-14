package by.training.informationhandling.controller.command.impl;

import by.training.informationhandling.controller.Controller;
import by.training.informationhandling.view.UserOutput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger userLogger = LogManager.getLogger(Main.class);
    private static final UserOutput PRINTER = new UserOutput();

    public static void main(String[] args) {
        Controller controller = new Controller();
        PRINTER.printMessage(controller.executeTask("parse_data-"));
        PRINTER.printEmptyString();
        PRINTER.printMessage(controller.executeTask("sort_paragraphs-"));
        PRINTER.printEmptyString();
        PRINTER.printMessage(controller.executeTask("sort_words-"));
        PRINTER.printEmptyString();
        PRINTER.printMessage(controller.executeTask("sort_lexemes-s"));
        PRINTER.printEmptyString();

    }
}
