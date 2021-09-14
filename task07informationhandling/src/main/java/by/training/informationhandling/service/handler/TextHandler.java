package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;

import java.rmi.ServerException;

public class TextHandler extends BaseHandler {
    public TextHandler(Handler handler) {
        super.next = handler;
    }

    @Override
    public void parse(String text, Composite root) throws ServiceException {
        if (text.length() > 0) {
            Composite paragraph = new Composite(Type.PARAGRAPH);
            root.add(paragraph);
            if (next != null) {
                next.parse(text, paragraph);
            }
        }
        else{
            throw new ServiceException("There is no text for parsing");
        }
    }
}
