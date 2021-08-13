package by.training.task05.service;

import by.training.task05.bean.Triangle;

import java.util.List;

public interface CreateTriangleService {
    /**
     * Create triangle from {@code String} data
     *
     * @param str {code String} data that will be validated for create triangle
     * @return valid triangle
     * @throws ServiceException
     */
    Triangle createTriangle(String str) throws ServiceException;

    /**
     * Create triangles from {@code List<String>} data
     *
     * @param lines {code List<String>} data that will be validated for create triangles
     * @return valid {@code List<Triangle>}
     * @throws ServiceException
     */
    List<Triangle> createTriangles(List<String> lines) throws ServiceException;
}
