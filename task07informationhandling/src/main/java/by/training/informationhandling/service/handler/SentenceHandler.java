package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceHandler extends BaseHandler {
    public SentenceHandler() {
        pattern = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]");
    }

    public SentenceHandler(Handler handler) {
        super.next = handler;
        pattern = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]");
    }

    @Override
    public void parse(String text, Composite root) throws ServiceException {
        text = text.trim();
        StringBuilder builder = new StringBuilder(text);
        String[] strings = pattern.split(text);
        Matcher matcher = pattern.matcher(text);
        List<String> signs = new ArrayList<>();
        while (matcher.find()) {
            signs.add(matcher.group());
        }
        for (int i = 0; i < strings.length; i++) {
            Composite lexeme = new Composite(Type.LEXEME);
            root.add(lexeme);
            strings[i] += signs.get(i);
            if (next != null) {
                next.parse(strings[i], lexeme);
            }
        }
    }
}
