package tasks;

import by.training.tasks.TwentyFifthTask;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TwentyFifthTaskTest {
    private TwentyFifthTask twentyFifthTask = new TwentyFifthTask();

    @DataProvider(name = "testCalcDiscriminantPositiveProvider")
    public Object[][] createDataForCalcDiscriminant() {
        return new Object[][]{
                {new double[]{1, 6, 2}, 28},
                {new double[]{10, 5, 0}, 25},
                {new double[]{1.5, 2.9, 0.7}, 4.210000000},
                {new double[]{5, -4, -3}, 76},
                {new double[]{-2.6, 5.9, -1.4}, 20.25000000},
        };
    }

    @DataProvider(name = "testCalcDiscriminantNegativeProvider")
    public Object[][] createDataForNegativeQuotient() {
        return new Object[][]{
                {new double[]{0, 5, 6}, 0},
                {new double[]{0, -21.5488, 36.1}, 0},
                {new double[]{0, -21, -6.3}, 0},
                {new double[]{0, 1.5, -6.47}, 0},
                {new double[]{0, 0, 0}, 0},
        };
    }

    @DataProvider(name = "testCalcTwoRootsProvider")
    public Object[][] createDataForCalcTwoRoots() {
        return new Object[][]{
                {new double[]{6, 0}, 0},
                {new double[]{5, 10}, -1},
                {new double[]{-4, 8}, 1},
        };
    }

    @DataProvider(name = "testCalcFirstRootProvider")
    public Object[][] createDataForFirstRoot() {
        return new Object[][]{
                {new double[]{14, 6, 36}, 0},
                {new double[]{2.54, 8.21, 32.8601}, -0.487721854},
                {new double[]{-0.8, -2.36, 0.8335999999}, -2.04563561},
                {new double[]{-5.2, 5, 6.2799999999}, 0.23980838},
        };
    }

    @DataProvider(name = "testCalcSecondRootProvider")
    public Object[][] createDataForSecondRoot() {
        return new Object[][]{
                {new double[]{14, 6, 36}, -0.42857142},
                {new double[]{2.54, 8.21, 32.8601}, -2.744561610},
                {new double[]{-0.8, -2.36, 0.8335999999}, -0.90436438},
                {new double[]{-5.2, 5, 6.2799999999}, 0.7217300785},
        };
    }


    @Test(description = "Positive scenario for finding the discriminant", dataProvider = "testCalcDiscriminantPositiveProvider")
    public void testCalcDiscriminantPositive(double abc[], double result) {
        double actual = twentyFifthTask.calcDiscriminant(abc[0], abc[1], abc[2]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Negative scenario for finding the discriminant", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Argument a = 0", dataProvider = "testCalcDiscriminantNegativeProvider")
    public void testCalcDiscriminantNegative(double abc[], double result) {
        double actual = twentyFifthTask.calcDiscriminant(abc[0], abc[1], abc[2]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario for finding roots when discriminant = 0", dataProvider = "testCalcTwoRootsProvider")
    public void testCalcTwoRoots(double xy[], double result) {
        double actual = twentyFifthTask.calcTwoRoots(xy[0], xy[1]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of finding first root", dataProvider = "testCalcFirstRootProvider")
    public void testCalcFirstRoot(double abd[], double result) {
        double actual = twentyFifthTask.calcFirstRoot(abd[0], abd[1], abd[2]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of finding second root", dataProvider = "testCalcSecondRootProvider")
    public void testCalcSecondRoot(double abd[], double result) {
        double actual = twentyFifthTask.calcSecondRoot(abd[0], abd[1], abd[2]);
        assertEquals(actual, result, 0.001);
    }
}