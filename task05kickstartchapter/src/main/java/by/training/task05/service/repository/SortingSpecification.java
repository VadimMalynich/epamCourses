package by.training.task05.service.repository;

import java.util.List;

public interface SortingSpecification<T> {
    /**
     * Sort data by specified parameters
     *
     * @param storage data that will be sorted by specified parameters
     * @return sorted data
     */
    List<T> sort(List<T> storage);
}
