package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalcFigureParametersServiceImplTest {
    private CalcFigureParametersServiceImpl parametersService = new CalcFigureParametersServiceImpl();
    private Triangle triangle1, triangle2, triangle3, triangle4, triangle5, triangle6;

    @BeforeTest
    public void initialize() {
        triangle1 = new Triangle("triangle1");
        triangle1.addPoint(triangle1.new Point(1, 3));
        triangle1.addPoint(triangle1.new Point(-6, 8));
        triangle1.addPoint(triangle1.new Point(9, 12));

        triangle2 = new Triangle("triangle2");
        triangle2.addPoint(triangle2.new Point(4, 1));
        triangle2.addPoint(triangle2.new Point(7, 6));
        triangle2.addPoint(triangle2.new Point(-3, 4));

        triangle3 = new Triangle("triangle3");
        triangle3.addPoint(triangle3.new Point(-1, -60));
        triangle3.addPoint(triangle3.new Point(-92, 0));
        triangle3.addPoint(triangle3.new Point(-1, 0));

        triangle4 = new Triangle("triangle4");
        triangle4.addPoint(triangle4.new Point(0, 0));
        triangle4.addPoint(triangle4.new Point(0, 3));
        triangle4.addPoint(triangle4.new Point(4, 0));

        triangle5 = new Triangle("triangle5");
        triangle5.addPoint(triangle5.new Point(1, 3));
        triangle5.addPoint(triangle5.new Point(-6, 3));
        triangle5.addPoint(triangle5.new Point(9, 3));

        triangle6 = new Triangle("triangle6");
        triangle6.addPoint(triangle6.new Point(1, 3));
        triangle6.addPoint(triangle6.new Point(1, 8));
        triangle6.addPoint(triangle6.new Point(1, 12));
    }

    @DataProvider(name = "testCalcPerimeterPositiveProvider")
    public Object[][] createDataForCalcPerimeter() {
        return new Object[][]{
                {triangle1, 36.16},
                {triangle2, 23.65},
                {triangle3, 260},
                {triangle4, 12.0},
        };
    }

    @DataProvider(name = "testCalcSquarePositiveProvider")
    public Object[][] createDataForCalcSquare() {
        return new Object[][]{
                {triangle1, 51.5},
                {triangle2, 22},
                {triangle3, 2730},
                {triangle4, 6.0},
        };
    }

    @DataProvider(name = "testCalcParametersNegativeProvider")
    public Object[][] createDataForCalcParametersNegative() {
        return new Object[][]{
                {triangle5, 0},
                {triangle6, 0},
        };
    }


    @Test(description = "Positive scenario of calculate triangle perimeter", dataProvider = "testCalcPerimeterPositiveProvider")
    public void testCalcPerimeterPositive(Triangle triangle, double result) throws ServiceException {
        double actual = parametersService.calcPerimeter(triangle);
        assertEquals(actual, result, 0.01);
    }

    @Test(description = "Negative scenario of calculate triangle perimeter", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "The figure is not a triangle", dataProvider = "testCalcParametersNegativeProvider")
    public void testCalcPerimeterNegative(Triangle triangle, double result) throws ServiceException {
        double actual = parametersService.calcPerimeter(triangle);
        assertEquals(actual, result, 0.01);
    }

    @Test(description = "Positive scenario for calculating the area of a triangle",
            dataProvider = "testCalcSquarePositiveProvider")
    public void testCalcSquarePositive(Triangle triangle, double result) throws ServiceException {
        double actual = parametersService.calcSquare(triangle);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Negative scenario for calculating the area of a triangle", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "The figure is not a triangle", dataProvider = "testCalcParametersNegativeProvider")
    public void testCalcSquareNegative(Triangle triangle, double result) throws ServiceException {
        double actual = parametersService.calcSquare(triangle);
        assertEquals(actual, result, 0.01);
    }
}