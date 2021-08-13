package by.training.task05.service.repository;

import java.util.List;

public interface Repository<T> {
    /**
     * Add {@code Object T} to storage
     *
     * @param t {@code Object T} that should add to storage
     */
    void add(T t);

    /**
     * Delete {@code Object T} from storage by id
     *
     * @param id of {@code Object T} that should delete from storage
     */
    void delete(int id);

    /**
     * Delete all {@code Object T} from storage
     */
    void deleteAll();

    /**
     * Replace old {@code Object T} with the new one
     *
     * @param oldT {@code Object T} that should replace from storage
     * @param newT {@code Object T} that should add to storage
     */
    void update(T oldT, T newT);

    /**
     * Get all {@code Object T} that stored in storage
     *
     * @return {@code List<Object T>} of all {@code Object T} in storage
     */
    List<T> getAll();

    /**
     * Find data in storage by specification
     *
     * @param findingSpecification search condition
     * @return {@code List<Object T>} that suit specification parameters
     */
    List<T> findBySpecification(FindingSpecification findingSpecification);

    /**
     * Sort data in storage by specification
     *
     * @param specification sorting condition
     * @return {@code List<Object T>} sorted storage data
     */
    List<T> sortBySpecification(SortingSpecification specification);
}
