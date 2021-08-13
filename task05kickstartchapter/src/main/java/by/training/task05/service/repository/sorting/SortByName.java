package by.training.task05.service.repository.sorting;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.SortingSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByName implements SortingSpecification<Triangle> {
    @Override
    public List<Triangle> sort(List<Triangle> storage) {
        storage.sort(Comparator.comparing(Triangle::getName));
        return storage;
    }
}
