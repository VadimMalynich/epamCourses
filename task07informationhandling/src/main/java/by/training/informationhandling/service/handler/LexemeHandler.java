package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;

import java.util.regex.Pattern;

public class LexemeHandler extends BaseHandler {
    public LexemeHandler() {
        //pattern = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]|[-]|[,]|[:]|[;]");
        pattern = Pattern.compile("[ ]+");
    }

    public LexemeHandler(Handler handler) {
        super.next = handler;
        pattern = Pattern.compile("[ ]+");
        //pattern = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]|[-]|[,]|[:]|[;]");
    }

    @Override
    public void parse(String text, Composite root) throws ServiceException {
        text = text.trim();
        String[] strings = pattern.split(text);
        for (int i = 0; i < strings.length; i++) {
            Composite word = new Composite(Type.WORD);
            root.add(word);
            if (next != null) {
                next.parse(strings[i], word);
            }
        }
    }
}
