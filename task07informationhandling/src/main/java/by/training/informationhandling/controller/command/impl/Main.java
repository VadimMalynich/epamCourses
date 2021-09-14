package by.training.informationhandling.controller.command.impl;

import by.training.informationhandling.controller.Controller;
import by.training.informationhandling.view.UserOutput;

public class Main {
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
