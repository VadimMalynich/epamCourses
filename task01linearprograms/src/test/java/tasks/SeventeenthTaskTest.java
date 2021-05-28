package tasks;

import by.training.tasks.SeventeenthTask;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SeventeenthTaskTest {
    SeventeenthTask seventeenthTask = new SeventeenthTask();

    @DataProvider(name = "testAverageProvider")
    public Object[][] createDataForAverage() {
        return new Object[][]{
                {new double[]{4, 38.21}, 27925.3783305},
                {new double[]{0, 0}, 0},
                {new double[]{2.5, 1}, 8.3125},
                {new double[]{0, 8.25}, 280.7578125},
                {new double[]{10, 0}, 500},
        };
    }

    @DataProvider(name = "testGeometricMeanProvider")
    public Object[][] createDataForGeometricMean() {
        return new Object[][]{
                {new double[]{4, 2}, 2.8284271},
                {new double[]{0, 0}, 0},
                {new double[]{0, 254.3654}, 0},
                {new double[]{547.354, 0}, 0},
                {new double[]{10.574, 32.4}, 18.50939221},
                {new double[]{-54, -23.44}, 35.57752099},
                {new double[]{-20.5, 14}, 16.94107434},
                {new double[]{10, -10}, 10},
        };
    }

    @Test(description = "Positive calculate average of variables a^3 and b^3", dataProvider = "testAverageProvider")
    public void testAverage(double ab[], double result) {
        double actual = seventeenthTask.average(ab[0], ab[1]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive calculate geometric mean", dataProvider = "testGeometricMeanProvider")
    public void testGeometricMean(double ab[], double result) {
        double actual = seventeenthTask.geometricMean(ab[0], ab[1]);
        assertEquals(actual, result, 0.001);
    }
}