package tasks;

import by.training.tasks.NinthTask;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NinthTaskTest {
    private NinthTask ninthTask = new NinthTask();

    @DataProvider(name = "testCalcPositiveProvider")
    public Object[][] createDataForPositiveCalc() {
        return new Object[][]{
                {new double[]{8, 4, 2, 1}, 1},
                {new double[]{-3.5, 10.69, 25, 12}, 0.08333333333333},
                {new double[]{0, 0, 5.64, 6.265}, 0.15961691939},
                {new double[]{0, 6.02, 3.47, 9}, 0.1111111111},
                {new double[]{0.75, 0, 1.863, 8.145}, 0.12277470841},
        };
    }

    @DataProvider(name = "testCalcNegativeProvider")
    public Object[][] createDataForNegativeCalc() {
        return new Object[][]{
                {new double[]{5, 20.36, 0, 0}, 0},
                {new double[]{-36, -104.62, 0, -3.5}, 0},
                {new double[]{0, 0, 0, 0}, 0},
                {new double[]{0, 0, 0, 9}, 0},
                {new double[]{0, 0, 154.2, 0}, 0},
                {new double[]{14.25, 54.5, 154.2, 0}, 0},
        };
    }

    @Test(description = "Positive expression decision script", dataProvider = "testCalcPositiveProvider")
    public void testCalcPositive(double abcd[], double result) {
        double actual = ninthTask.calcResult(abcd[0], abcd[1], abcd[2], abcd[3]);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Negative expression decision script", expectedExceptions = IllegalArgumentException.class,
            dataProvider = "testCalcNegativeProvider")
    public void testCalcNegative(double abcd[], double result) {
        double actual = ninthTask.calcResult(abcd[0], abcd[1], abcd[2], abcd[3]);
        assertEquals(actual, result, 0.001);
    }
}
