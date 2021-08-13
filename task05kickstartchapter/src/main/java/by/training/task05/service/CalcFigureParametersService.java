package by.training.task05.service;

import by.training.task05.bean.Triangle;

public interface CalcFigureParametersService {
    /**
     * Calculate perimeter triangle
     *
     * @param triangle that was validated and created and contains data for calculate perimeter
     * @return calculated perimeter
     * @throws ServiceException
     */
    double calcPerimeter(Triangle triangle) throws ServiceException;

    /**
     * Calculate square triangle
     *
     * @param triangle that was validated and created and contains data for calculate perimeter
     * @return calculated square
     * @throws ServiceException
     */
    double calcSquare(Triangle triangle) throws ServiceException;

    /**
     * Calculate triangle side by points
     *
     * @param firstPoint coordinates of the first point
     * @param secondPoint coordinates of the first point
     * @return calculated triangle side
     * @throws ServiceException
     */
    double calcSideSize(Triangle.Point firstPoint, Triangle.Point secondPoint) throws ServiceException;
}
