package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;

import java.util.regex.Pattern;

public class ParagraphHandler extends BaseHandler {

    public ParagraphHandler() {
        pattern = Pattern.compile("\r\n|\n");
    }

    public ParagraphHandler(Handler handler) {
        super.next = handler;
        pattern = Pattern.compile("\r\n|\n");
    }

    @Override
    public void parse(String text, Composite root) throws ServiceException {
        String[] strings = pattern.split(text);
        for (int i = 0; i < strings.length; i++) {
            Composite sentence = new Composite(Type.SENTENCE);
            root.add(sentence);
            if (next != null) {
                next.parse(strings[i], sentence);
            }
        }
    }
}
