package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.DefineFigureTypeService;
import by.training.task05.service.ServiceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefineFigureTypeServiceImpl implements DefineFigureTypeService {
    private ValidateDataServiceImpl validator = new ValidateDataServiceImpl();

    @Override
    public String defineTriangleType(Triangle triangle) throws ServiceException {
        if (triangle == null) {
            throw new ServiceException("Impossible to define triangle type! Triangle does not exist");
        }
        if (!validator.isTriangles(triangle)) {
            throw new ServiceException("The figure is not a triangle");
        }
        String triangleType;
        List<Double> sides = sortTriangleSides(triangle);
        double biggestSide = Math.pow(sides.get(2), 2);
        double sumOtherSides = Math.pow(sides.get(0), 2) + Math.pow(sides.get(1), 2);
        if (triangle.getFirstSideLength() == triangle.getSecondSideLength()
                && triangle.getFirstSideLength() == triangle.getThirdSideLength()) {
            triangleType = "Equilateral triangle";
        } else if (triangle.getFirstSideLength() == triangle.getSecondSideLength()
                || triangle.getFirstSideLength() == triangle.getThirdSideLength()
                || triangle.getSecondSideLength() == triangle.getThirdSideLength()) {
            triangleType = "Isosceles triangle";
        } else if (biggestSide == sumOtherSides) {
            triangleType = "Right triangle";
        } else if (biggestSide > sumOtherSides) {
            triangleType = "Obtuse triangle";
        } else {
            triangleType = "Acute-angled triangle";
        }
        return triangleType;
    }

    private List<Double> sortTriangleSides(Triangle triangle) {
        List<Double> values = new ArrayList<>();
        values.add(triangle.getFirstSideLength());
        values.add(triangle.getSecondSideLength());
        values.add(triangle.getThirdSideLength());
        Collections.sort(values);
        return values;
    }
}
