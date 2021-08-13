package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CreateTriangleServiceImplTest {
    private CreateTriangleServiceImpl create = new CreateTriangleServiceImpl();
    private Triangle triangle1, triangle2;
    private List<String> fileData, incorrectData;
    private List<Triangle> triangles = new ArrayList<>();


    @BeforeTest
    public void initialization() throws ServiceException {
        ReadDataServiceImpl readData = new ReadDataServiceImpl();
        fileData = readData.readData(new File("data/tests/correctAndIncorrect.txt"));
        incorrectData = readData.readData(new File("data/tests/incorrect.txt"));

        triangle1 = new Triangle(1,"triangle1");
        triangle1.addPoint(triangle1.new Point(5, 3.5));
        triangle1.addPoint(triangle1.new Point(5, 0));
        triangle1.addPoint(triangle1.new Point(0, 0));

        triangle2 = new Triangle(2,"tr2");
        triangle2.addPoint(triangle2.new Point(-6.9, 4.02));
        triangle2.addPoint(triangle2.new Point(-5.74, 5));
        triangle2.addPoint(triangle2.new Point(-6.12, 4.49));

        triangles.add(triangle1);
        triangles.add(triangle2);
    }

    @DataProvider(name = "testCreateTriangleProvider")
    public Object[][] createDataForCreateTriangle() {
        return new Object[][]{
                {"triangle1 5 3.5 5 0 0 0", triangle1},
                {"tr2 -6.9 4.02 -5.74 5 -6.12 4.49", triangle2},
        };
    }

    @DataProvider(name = "testCreateTriangleNegativeProvider")
    public Object[][] createDataForCreateTriangleNegative() {
        return new Object[][]{
                {"triangle69 -s -1 1.3 -1.75 -1 2.05", triangle1},
                {"triangle24 -3.w -0.8 ffs -1.6 -4 -2.3", triangle2},
                {"triaNG 3.6 -2.99 4.86 -1.15 6.12 -3.30 -55.2", triangle1},
                {"triangle24", triangle2},
                {"-3.4 -0.8 -4.6 -1.6 -4 -2.3", triangle2},
        };
    }

    @Test(description = "Positive scenario of creating triangle", dataProvider = "testCreateTriangleProvider")
    public void testCreateTriangle(String str, Triangle result) throws ServiceException {
        Triangle actual = create.createTriangle(str);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of creating triangle (incorrect data)", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "There is no correct data for creating triangle",
            dataProvider = "testCreateTriangleNegativeProvider")
    public void testCreateTriangleNegative(String str, Triangle result) throws ServiceException {
        Triangle actual = create.createTriangle(str);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of creating triangles")
    public void testCreateTriangles() throws ServiceException {
        List<Triangle> actual = create.createTriangles(fileData);
        assertEquals(actual, triangles);
    }

    @Test(description = "Negative scenario of creating triangles (all data from file is incorrect)",
            expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "There is no correct data for creating triangles")
    public void testCreateTrianglesNegative() throws ServiceException {
        List<Triangle> actual = create.createTriangles(incorrectData);
        assertEquals(actual, triangles);
    }
}