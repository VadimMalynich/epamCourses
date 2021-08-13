package by.training.task05.service;

import by.training.task05.bean.Triangle;

public interface DefineFigureTypeService {
    /**
     * defines one of the triangle types (Equilateral triangle, Isosceles triangle, Right triangle, Obtuse triangle or
     * Acute-angled triangle)
     *
     * @param triangle that was validated and created and contains data for calculate perimeter
     * @return {@code String} triangle type
     * @throws ServiceException
     */
    String defineTriangleType(Triangle triangle) throws ServiceException;
}

