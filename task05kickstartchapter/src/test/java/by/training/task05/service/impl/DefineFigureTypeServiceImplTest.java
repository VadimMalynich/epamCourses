package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class DefineFigureTypeServiceImplTest {
    private DefineFigureTypeServiceImpl typeService = new DefineFigureTypeServiceImpl();
    private Triangle triangle1, triangle2, triangle3, triangle4, triangle5, triangle6, triangle7;
    List<Triangle> triangles;

    @BeforeTest
    public void initialize() throws ServiceException {
        triangle1 = new Triangle("triangle1");
        triangle1.addPoint(triangle1.new Point(0, 0));
        triangle1.addPoint(triangle1.new Point(4, 5));
        triangle1.addPoint(triangle1.new Point(4, -5));

        triangle2 = new Triangle("triangle2");
        triangle2.addPoint(triangle2.new Point(-2, -2));
        triangle2.addPoint(triangle2.new Point(0.5, 2.330127018922193233));
        triangle2.addPoint(triangle2.new Point(-4.5, 2.330127018922193233));

        triangle3 = new Triangle("triangle3");
        triangle3.addPoint(triangle3.new Point(-5, -6));
        triangle3.addPoint(triangle3.new Point(8, 15));
        triangle3.addPoint(triangle3.new Point(-3, 14));

        triangle4 = new Triangle("triangle4");
        triangle4.addPoint(triangle4.new Point(0, 0));
        triangle4.addPoint(triangle4.new Point(0, 3));
        triangle4.addPoint(triangle4.new Point(4, 0));

        triangle5 = new Triangle("triangle5");
        triangle5.addPoint(triangle5.new Point(1, 1));
        triangle5.addPoint(triangle5.new Point(-4.25, -6.12));
        triangle5.addPoint(triangle5.new Point(3, -1.86));

        triangle6 = new Triangle("triangle6");
        triangle6.addPoint(triangle6.new Point(-1, -5.65));
        triangle6.addPoint(triangle6.new Point(-92, -5.65));
        triangle6.addPoint(triangle6.new Point(-1, -5.65));

        triangle7 = new Triangle("triangle7");
        triangle7.addPoint(triangle7.new Point(4, 1));
        triangle7.addPoint(triangle7.new Point(4, 6));
        triangle7.addPoint(triangle7.new Point(4, 4));
        /*ReadDataServiceImpl readDataService = new ReadDataServiceImpl();
        ValidateDataServiceImpl validator = new ValidateDataServiceImpl();
        CreateTriangleImpl creator = new CreateTriangleImpl();
        List<String> fileData = readDataService.readData(new File("data/tests/correct.txt"));
        fileData = validator.validateReadData(fileData);
        triangles = creator.createTriangles(fileData);*/

    }


    @DataProvider(name = "testDefineTriangleTypePositiveProvider")
    public Object[][] createDataForDefineTypePositive() {
        return new Object[][]{
                {triangle1, "Isosceles triangle"},
                {triangle2, "Equilateral triangle"},
                {triangle3, "Obtuse triangle"},
                {triangle4, "Right triangle"},
                {triangle5, "Acute-angled triangle"},
//                {triangles.get(0), "Right triangle"},
//                {triangles.get(1), "Equilateral triangle"},
//                {triangles.get(2), "Obtuse triangle"},
//                {triangles.get(3), "Right triangle"},
//                {triangles.get(4), "Acute-angled triangle"},
        };
    }

    @DataProvider(name = "testDefineTriangleTypeNegativeProvider")
    public Object[][] createDataForDefineTypeNegative() {
        return new Object[][]{
                {triangle6, "Isosceles triangle"},
                {triangle7, "Equilateral triangle"},
        };
    }

    @Test(description = "Positive scenario of defining triangle type", dataProvider = "testDefineTriangleTypePositiveProvider")
    public void testDefineTriangleTypePositive(Triangle triangle, String result) throws ServiceException {
        String actual = typeService.defineTriangleType(triangle);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of defining triangle type", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "The figure is not a triangle",
            dataProvider = "testDefineTriangleTypeNegativeProvider")
    public void testDefineTriangleTypeNegative(Triangle triangle, String result) throws ServiceException {
        String actual = typeService.defineTriangleType(triangle);
        assertEquals(actual, result);
    }
}