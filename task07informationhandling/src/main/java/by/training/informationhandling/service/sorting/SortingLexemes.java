package by.training.informationhandling.service.sorting;

import by.training.informationhandling.bean.Component;
import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.SortLexemesService;

import java.util.*;
import java.util.stream.Collectors;

public class SortingLexemes implements SortLexemesService {
    public List<String> getSortedData(Composite composite, char symbol) throws ServiceException {
        if (composite == null) {
            throw new ServiceException("It is not possible to sort tokens by the specified character.");
        }
        List<String> list = new ArrayList<>();
        sortLexemes(composite.getComponents(), list, symbol);
        return list;
    }

    private void sortLexemes(List<Component> components, List<String> list, char symbol) {
        List<String> strings = new ArrayList<>();
        for (Component component : components) {
            Composite c = (Composite) component;
            if (Type.WORD.equals(c.getType())) {
                strings.add(c.collect());
            } else {
                sortLexemes(c.getComponents(), list, symbol);
            }
        }
        if (!strings.isEmpty()) {
            Map<String, Integer> hashMap = new HashMap<>();
            for (String s : strings) {
                char[] c = s.toCharArray();
                int count = 0;
                for (int i = 0; i < c.length; i++) {
                    if (symbol == c[i]) {
                        count++;
                    }
                }
                hashMap.put(s, count);
            }
            StringBuilder builder = new StringBuilder();
            List<String> temp = hashMap.entrySet().stream().filter(e -> e.getValue() > 0).sorted(Map.Entry.comparingByValue()).
                    map(s -> s.getKey()).collect(Collectors.toList());
            Collections.reverse(temp);
            temp.stream().forEach(s -> builder.append(s).append(" "));
            temp.clear();
            temp = hashMap.entrySet().stream().filter(e -> e.getValue() == 0)
                    .map(s -> s.getKey()).collect(Collectors.toList());
            temp.stream().sorted().forEach(s -> builder.append(s).append(" "));
            list.add(builder.toString());
        }
    }
}
