package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Symbol;
import by.training.informationhandling.service.ServiceException;

public class SymbolHandler extends BaseHandler {

    @Override
    public void parse(String text, Composite root) throws ServiceException {
        text = text.trim();
        char[] symbols = text.toCharArray();
        for (Character s : symbols) {
            Symbol symbol = new Symbol(s);
            root.add(symbol);
        }
    }
}
