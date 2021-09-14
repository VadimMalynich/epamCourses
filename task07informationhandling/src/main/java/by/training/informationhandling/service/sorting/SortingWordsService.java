package by.training.informationhandling.service.sorting;

import by.training.informationhandling.bean.Component;
import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.SortingTextPartsService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortingWordsService implements SortingTextPartsService {
    private static final Pattern PATTERN = Pattern.compile("[.]{3}|[.]|[?][!]|[?]|[!]");

    public List<String> getSortedData(Composite composite) throws ServiceException {
        if (composite == null) {
            throw new ServiceException("Can not sorting paragraphs by sentence count.");
        }
        List<String> list = new ArrayList<>();
        collectWords(composite.getComponents(), list);
        list = sortWordsInSentenceByLength(list);
        return list;
    }

    private void collectWords(List<Component> components, List<String> list) {
        List<String> strings = new ArrayList<>();
        for (Component component : components) {
            Composite c = (Composite) component;
            if (Type.SYMBOL.equals(c.getType())) {
                strings.add(c.collect());
            } else if (Type.MARK.equals(c.getType())) {
                strings.add(c.collect());
            } else {
                collectWords(c.getComponents(), list);
            }
        }
        if (!strings.isEmpty()) {
            list.addAll(strings);
        }
    }

    private List<String> sortWordsInSentenceByLength(List<String> list) {
        List<String> sentence = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (String str : list) {
            Matcher matcher = PATTERN.matcher(str);
            if (matcher.find()) {
                temp.add(str);
                temp.sort(Comparator.comparing(String::length));
                StringBuilder builder = new StringBuilder();
                for (String s : temp) {
                    builder.append(s).append(" ");
                }
                temp.clear();
                sentence.add(builder.toString());
            } else {
                temp.add(str);
            }
        }
        return sentence;
    }
}
