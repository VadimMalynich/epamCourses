package by.training.task05.service;

import by.training.task05.bean.Triangle;

import java.util.List;

public interface ValidateDataService {
    /**
     * Validate {@code List<String>} to meet the requirements for creating a triangle
     *
     * @param lines {@code List<String>} that will be validate
     * @return validated {@code List<String>}
     * @throws ServiceException
     */
    List<String> validateReadData(List<String> lines) throws ServiceException;

    /**
     * Checks whether the points of the triangle can form a triangle
     *
     * @param triangles that will be checked
     * @return {@code true} if points form triangle, {@code false} otherwise
     * @throws ServiceException
     */
    boolean isTriangles(Triangle triangles) throws ServiceException;
}
