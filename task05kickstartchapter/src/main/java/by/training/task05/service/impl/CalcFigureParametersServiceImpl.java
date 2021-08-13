package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.CalcFigureParametersService;
import by.training.task05.service.ServiceException;

public class CalcFigureParametersServiceImpl implements CalcFigureParametersService {

    @Override
    public double calcPerimeter(Triangle triangle) throws ServiceException {
        if (triangle == null) {
            throw new ServiceException("It is impossible to calculate the perimeter. The triangle does not exist");
        }
        ValidateDataServiceImpl validator = new ValidateDataServiceImpl();
        if (!validator.isTriangles(triangle)) {
            throw new ServiceException("The figure is not a triangle");
        }
        return triangle.getFirstSideLength() + triangle.getSecondSideLength() + triangle.getThirdSideLength();
    }

    @Override
    public double calcSquare(Triangle triangle) throws ServiceException {
        if (triangle == null) {
            throw new ServiceException("It is impossible to calculate the square. The triangle does not exist");
        }
        double semiPerimeter = calcPerimeter(triangle) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getFirstSideLength())
                * (semiPerimeter - triangle.getSecondSideLength()) * (semiPerimeter - triangle.getThirdSideLength()));
    }

    @Override
    public double calcSideSize(Triangle.Point firstPoint, Triangle.Point secondPoint) throws ServiceException {
        if (firstPoint == null || secondPoint == null) {
            throw new ServiceException("It is impossible to calculate the length of the side of the triangle");
        }
        double legX = firstPoint.getX() - secondPoint.getX();
        double lexY = firstPoint.getY() - secondPoint.getY();

        return Math.sqrt(legX * legX + lexY * lexY);
    }
}
