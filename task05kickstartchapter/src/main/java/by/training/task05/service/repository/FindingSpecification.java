package by.training.task05.service.repository;

public interface FindingSpecification<T> {
    /**
     * Checking the {@code Object T} parameters to match the specified parameters
     *
     * @param t {@code Object T} that will be checked on compliance need parameters
     * @return {@code true} if matches were found, {@code false} otherwise
     */
    boolean isExist(T t);
}
