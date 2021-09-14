package by.training.informationhandling.controller.command.impl;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.controller.Controller;
import by.training.informationhandling.controller.command.Command;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.ServiceFactory;
import by.training.informationhandling.service.TextParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParseData implements Command {
    private static final Logger userLogger = LogManager.getLogger(ParseData.class);

    @Override
    public String execute(String request) {
        Controller controller = new Controller();
        ServiceFactory factory = ServiceFactory.getInstance();
        TextParserService parserService = factory.getTextParserService();
        String text = controller.executeTask("read_data-");
        Composite composite = new Composite(Type.TEXT);
        try {
            composite = parserService.parseText(text);
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return composite.collect();
    }
}
