package tasks;

import by.training.tasks.FirstTask;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstTaskTest {
    private FirstTask firstTask = new FirstTask();

    @DataProvider(name = "testSumProvider")
    public Object[][] createDataForSum() {
        return new Object[][]{
                {new double[]{3.6, 5.9}, 9.5},
                {new double[]{-3, 3}, 0},
                {new double[]{0, 0}, 0},
                {new double[]{-200.9, 10.8}, -190.1},
                {new double[]{0, -6.6666}, -6.6666},
                {new double[]{0, 5}, 5},
                {new double[]{203, 0}, 203},
                {new double[]{-69.365, 0}, -69.365},
        };
    }

    @DataProvider(name = "testDifferenceProvider")
    public Object[][] createDataForDifference() {
        return new Object[][]{
                {new double[]{15.69, 5.9}, 9.79},
                {new double[]{-3, 3}, -6},
                {new double[]{0, 0}, 0},
                {new double[]{-20.9, 100.8}, -121.7},
                {new double[]{0, -15.659}, 15.659},
                {new double[]{0, 53}, -53},
                {new double[]{2.987553, 0}, 2.987553},
                {new double[]{-54.3658, 0}, -54.3658},
        };
    }

    @DataProvider(name = "testProductProvider")
    public Object[][] createDataForProduct() {
        return new Object[][]{
                {new double[]{2.5, 5}, 12.5},
                {new double[]{-3, 3}, -9},
                {new double[]{0, 0}, 0},
                {new double[]{-36.985, 10}, -369.85},
                {new double[]{0, -6.6666}, 0},
                {new double[]{0, 5}, 0},
                {new double[]{203, 0}, 0},
                {new double[]{-69.365, 0}, 0},
                {new double[]{15.699874, 54.02143}, 848.12964429982},
        };
    }

    @DataProvider(name = "testQuotientPositiveProvider")
    public Object[][] createDataForPositiveQuotient() {
        return new Object[][]{
                {new double[]{5, 2}, 2.5},
                {new double[]{-3, 3}, -1},
                {new double[]{-25.21, -25.21}, 1},
                {new double[]{0, 59.63}, 0},
                {new double[]{-36.25, 10}, -3.625},
                {new double[]{0, -6.6666}, 0},
                {new double[]{458.254, 998.5542}, 0.4589175029257},
                {new double[]{50.668, 4.698}, 10.7850148999},
        };
    }

    @DataProvider(name = "testQuotientNegativeProvider")
    public Object[][] createDataForNegativeQuotient() {
        return new Object[][]{
                {new double[]{5, 0}, 0},
                {new double[]{-3, 0}, 0},
                {new double[]{59.3654, 0}, 0},
                {new double[]{-23.365, 0}, 0},
                {new double[]{0, 0}, 0},
                {new double[]{-23.36, 23.36}, -1},
        };
    }

    @Test(description = "Positive scenario of the amount", dataProvider = "testSumProvider")
    public void testSum(double xy[], double result) {
        double actual = firstTask.sum(xy[0], xy[1]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of the difference", dataProvider = "testDifferenceProvider")
    public void testDifference(double xy[], double result) {
        double actual = firstTask.difference(xy[0], xy[1]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of the product", dataProvider = "testProductProvider")
    public void testProduct(double xy[], double result) {
        double actual = firstTask.product(xy[0], xy[1]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of the quotient", dataProvider = "testQuotientPositiveProvider")
    public void testQuotientPositive(double xy[], double result) {
        double actual = firstTask.quotient(xy[0], xy[1]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Negative scenario of the quotient", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Division by 0", dataProvider = "testQuotientNegativeProvider")
    public void testQuotientNegative(double xy[], double result) {
        double actual = firstTask.quotient(xy[0], xy[1]);
        assertEquals(actual, result, 0.001);
    }
}
