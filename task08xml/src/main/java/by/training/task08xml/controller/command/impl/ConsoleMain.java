package by.training.task08xml.controller.command.impl;

import by.training.task08xml.controller.Controller;

public class ConsoleMain {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.executeTask("all_models_parse_xml");
    }
}
