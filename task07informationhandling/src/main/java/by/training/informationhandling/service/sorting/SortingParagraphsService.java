package by.training.informationhandling.service.sorting;

import by.training.informationhandling.bean.Component;
import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.bean.Type;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.SortingTextPartsService;

import java.util.*;
import java.util.stream.Collectors;

public class SortingParagraphsService implements SortingTextPartsService {
    public List<String> getSortedData(Composite composite) throws ServiceException {
        if (composite == null) {
            throw new ServiceException("Can not sorting paragraphs by sentence count.");
        }
        Map<String, Integer> hashMap = new HashMap<>();
        getParagraphs(composite.getComponents(), hashMap);
        List<String> list = hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(s -> s.getKey()).collect(Collectors.toList());
        return list;
    }

    private void getParagraphs(List<Component> components, Map<String, Integer> map) {
        for (Component component : components) {
            Composite c = (Composite) component;
            if (Type.SENTENCE.equals(c.getType())) {
                map.put(c.collect(), c.getComponentsCount());
            } else {
                getParagraphs(c.getComponents(), map);
            }
        }
    }
}
