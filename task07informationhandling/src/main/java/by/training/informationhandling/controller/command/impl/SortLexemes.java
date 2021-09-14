package by.training.informationhandling.controller.command.impl;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.controller.Controller;
import by.training.informationhandling.controller.command.Command;
import by.training.informationhandling.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SortLexemes implements Command {
    private static final Logger userLogger = LogManager.getLogger(SortLexemes.class);

    @Override
    public String execute(String request) {
        String data[] = request.split("-");
        char symbol = data[1].charAt(0);
        Controller controller = new Controller();
        ServiceFactory factory = ServiceFactory.getInstance();
        SortLexemesService service = factory.getSortLexemes();
        TextParserService parserService = factory.getTextParserService();
        String text = controller.executeTask("read_data-");
        Composite composite;
        StringBuilder builder = new StringBuilder();
        try {
            composite = parserService.parseText(text);
            List<String> list = service.getSortedData(composite, symbol);
            list.forEach(s -> builder.append(s).append(System.lineSeparator()));
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        return builder.toString();
    }
}
