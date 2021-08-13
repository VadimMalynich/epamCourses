package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ServiceException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ValidateDataServiceImplTest {
    private ValidateDataServiceImpl validateDataService = new ValidateDataServiceImpl();
    private Triangle triangle1, triangle2, triangle3, triangle4, triangle5, triangle6;

    private List<String> expectedResult1, expectedResult2, expectedResult3, firstFileData, secondFileData, thirdFileData;
    private static final String FIRST_PATH = "data/tests/correct.txt";
    private static final String SECOND_PATH = "data/tests/correctAndIncorrect.txt";
    private static final String THIRD_PATH = "data/tests/incorrect.txt";

    @BeforeTest
    public void initialize() throws ServiceException {
        triangle1 = new Triangle("triangle1");
        triangle1.addPoint(triangle1.new Point(1, 3));
        triangle1.addPoint(triangle1.new Point(-6, 8));
        triangle1.addPoint(triangle1.new Point(9, 12));

        triangle2 = new Triangle("triangle2");
        triangle2.addPoint(triangle2.new Point(1, 3));
        triangle2.addPoint(triangle2.new Point(-6, 3));
        triangle2.addPoint(triangle2.new Point(9, 3));

        triangle3 = new Triangle("triangle3");
        triangle3.addPoint(triangle3.new Point(1, 3));
        triangle3.addPoint(triangle3.new Point(1, 8));
        triangle3.addPoint(triangle3.new Point(1, 12));

        triangle4 = new Triangle("triangle4");
        triangle4.addPoint(triangle4.new Point(0, 0));
        triangle4.addPoint(triangle4.new Point(0, 3));
        triangle4.addPoint(triangle4.new Point(4, 0));

        triangle5 = new Triangle("triangle5");
        triangle5.addPoint(triangle5.new Point(4, 1));
        triangle5.addPoint(triangle5.new Point(7, 6));
        triangle5.addPoint(triangle5.new Point(-3, 4));

        triangle6 = new Triangle("triangle6");
        triangle6.addPoint(triangle6.new Point(-1, -60));
        triangle6.addPoint(triangle6.new Point(-92, 0));
        triangle6.addPoint(triangle6.new Point(-1, 0));

        ReadDataServiceImpl readDataService = new ReadDataServiceImpl();
        firstFileData = readDataService.readData(new File(FIRST_PATH));
        secondFileData = readDataService.readData(new File(SECOND_PATH));
        thirdFileData = readDataService.readData(new File(THIRD_PATH));

        expectedResult1 = new ArrayList<>();
        expectedResult1.add("triangle1 5 3.5 5 0 0 0");
        expectedResult1.add("triangle69 -2.6 -1 1.3 -1.75 -1 2.05");
        expectedResult1.add("triangle24 -3.4 -0.8 -4.6 -1.6 -4 -2.3");
        expectedResult1.add("tr2 -6.9 4.02 -5.74 5 -6.12 4.49");
        expectedResult1.add("triaNG 3.6 -2.99 4.86 -1.15 6.12 -3.30");

        expectedResult2 = new ArrayList<>();
        expectedResult2.add("triangle1 5 3.5 5 0 0 0");
        expectedResult2.add("tr2 -6.9 4.02 -5.74 5 -6.12 4.49");
        expectedResult3 = new ArrayList<>();

    }

    @DataProvider(name = "testValidateReadDataProvider")
    public Object[][] createDataForValidateDataFromFile() {
        return new Object[][]{
                {firstFileData, expectedResult1},
                {secondFileData, expectedResult2},
                {thirdFileData, expectedResult3},

        };
    }

    @DataProvider(name = "testIsTrianglesProvider")
    public Object[][] createDataForDefineTriangle() {
        return new Object[][]{
                {triangle1, true},
                {triangle2, false},
                {triangle3, false},
                {triangle4, true},
                {triangle5, true},
                {triangle6, true},
        };
    }

    @DataProvider(name = "testValidateLineProvider")
    public Object[][] createDataForValidateLines() {
        return new Object[][]{
                {"name -5.0 -9.2 -1.0 -6.84 -6 -1.02", true},
                {"triangle5 3.1 4 2 8.3 4 9.47", true},
                {"triangle5 -3.1 4 2 -8.3 -4 9.47", true},
                {"failure", false},
                {"mines 5.1 5.23 4 6.0 4.96 2.120 2.3", false},
                {"lakes 5 3.1 54 20", false},
                {"tree -5.2 6 as -6.2 5.4 s", false},
                {"tree -5.2 6 .2 -6.2 5.4 0.56", true},
        };
    }

    @Test(description = "Positive scenario of validating data that read from file",
            dataProvider = "testValidateReadDataProvider")
    public void testValidateReadData(List<String> fileData, List<String> result) throws ServiceException {
        List<String> actual = validateDataService.validateReadData(fileData);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of defining is figure triangle", dataProvider = "testIsTrianglesProvider")
    public void testIsTriangles(Triangle triangle, boolean result) throws ServiceException {
        boolean actual = validateDataService.isTriangles(triangle);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of validating lines", dataProvider = "testValidateLineProvider")
    public void testValidateLine(String str, boolean result) {
        boolean actual = validateDataService.validateLine(str);
        assertEquals(actual, result);
    }
}