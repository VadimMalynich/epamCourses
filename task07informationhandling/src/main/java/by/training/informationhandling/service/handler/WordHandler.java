package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends BaseHandler {
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("^[^A-Za-z\\s]$");

    public WordHandler() {
        pattern = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]|[-]|[,]|[:]|[;]");
    }

    public WordHandler(Handler handler) {
        super.next = handler;
        pattern = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]|[-]|[,]|[:]|[;]");
    }

    @Override
    public void parse(String text, Composite root) throws ServiceException {
        text = text.trim();
        Matcher markMatcher = pattern.matcher(text);
        Matcher expressionMatcher = EXPRESSION_PATTERN.matcher(text);
        if (markMatcher.find()) {
            String[] strings = pattern.split(text);
            if (strings.length != 0) {
                Composite symbol = new Composite(Type.SYMBOL);
                root.add(symbol);
                next.parse(strings[0], symbol);
            }
            Composite mark = new Composite(Type.MARK);
            root.add(mark);
            next.parse(markMatcher.group(), mark);
        } else if (expressionMatcher.find()) {
            next.parse(expressionMatcher.group(), root);
        } else {
            Composite symbol = new Composite(Type.SYMBOL);
            root.add(symbol);
            next.parse(text, symbol);
        }
    }
}
