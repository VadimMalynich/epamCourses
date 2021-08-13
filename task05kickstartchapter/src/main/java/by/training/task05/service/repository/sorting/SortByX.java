package by.training.task05.service.repository.sorting;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.SortingSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByX implements SortingSpecification<Triangle> {
    @Override
    public List<Triangle> sort(List<Triangle> storage) {
        for (Triangle triangle : storage) {
            triangle.getPoints().sort(Comparator.comparing(Triangle.Point::getX).thenComparing(Triangle.Point::getY));
        }
        return storage;
    }
}
