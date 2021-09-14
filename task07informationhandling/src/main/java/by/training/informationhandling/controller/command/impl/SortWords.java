package by.training.informationhandling.controller.command.impl;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.controller.Controller;
import by.training.informationhandling.controller.command.Command;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.ServiceFactory;
import by.training.informationhandling.service.SortingTextPartsService;
import by.training.informationhandling.service.TextParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SortWords implements Command {
    private static final Logger userLogger = LogManager.getLogger(SortWords.class);

    @Override
    public String execute(String request) {
        Controller controller = new Controller();
        ServiceFactory factory = ServiceFactory.getInstance();
        SortingTextPartsService service = factory.getSortingWords();
        TextParserService parserService = factory.getTextParserService();
        String text = controller.executeTask("read_data-");
        Composite composite;
        StringBuilder builder = new StringBuilder();
        try {
            composite = parserService.parseText(text);
            List<String> list = service.getSortedData(composite);
            list.forEach(s -> builder.append(s).append(System.lineSeparator()));
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return builder.toString();
    }
}
