package by.training.task05.service.repository.sorting;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.SortingSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByY implements SortingSpecification<Triangle> {
    @Override
    public List<Triangle> sort(List<Triangle> storage) {
        for (Triangle triangle : storage) {
            triangle.getPoints().sort(Comparator.comparing(Triangle.Point::getY).thenComparing(Triangle.Point::getX));
        }
        return storage;
    }
}
