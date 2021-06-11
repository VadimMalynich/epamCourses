package by.training.task02.tasks.cycles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CyclesTasksTest {
    private CyclesTasks cyclesTasks = new CyclesTasks();

    @DataProvider(name = "testGetNumbersStringPositiveProvider")
    public Object[][] createDataForNumbersStringPositive() {
        return new Object[][]{
                {new int[]{0, 4}, "0; 1; 2; 3; 4."},
                {new int[]{0, 0}, "0."},
                {new int[]{-4, 4}, "-4; -3; -2; -1; 0; 1; 2; 3; 4."},
                {new int[]{-15, -11}, "-15; -14; -13; -12; -11."},
                {new int[]{58, 60}, "58; 59; 60."},
        };
    }

    @DataProvider(name = "testGetNumbersStringNegativeProvider")
    public Object[][] createDataForNumbersStringNegative() {
        return new Object[][]{
                {new int[]{6, 4}, null},
                {new int[]{-20, -56}, null},
                {new int[]{4, -4}, null},
        };
    }

    @DataProvider(name = "testCalcSumSquaresPositiveProvider")
    public Object[][] createDataForSumSquaresPositive() {
        return new Object[][]{
                {100, 338350},
                {30, 9455},
                {54, 53955},
                {8, 204},
        };
    }

    @DataProvider(name = "testCalcSumSquaresNegativeProvider")
    public Object[][] createDataForSumSquaresNegative() {
        return new Object[][]{
                {-200, 0},
                {-4, 0},
                {0, 0},
        };
    }

    @DataProvider(name = "testSolveExpressionProvider")
    public Object[][] createDataForExpression() {
        return new Object[][]{
                {new int[]{5, 6}, 151200},
                {new int[]{-3, -14}, 10461394944000l},
                {new int[]{0, 15}, 0},
                {new int[]{-1, 3}, 0},
                {new int[]{-7, 4}, 840},
                {new int[]{-32, 3}, -29760},
        };
    }

    @DataProvider(name = "testCalcFactorialPositiveProvider")
    public Object[][] createDataForFactorialPositive() {
        return new Object[][]{
                {20, 2432902008176640000l},
                {5, 120},
                {0, 1},
                {9, 362880},
        };
    }

    @DataProvider(name = "testCalcFactorialNegativeProvider")
    public Object[][] createDataForFactorialNegative() {
        return new Object[][]{
                {-6, 0},
                {-1, 0},
                {-203, 0},
                {21, 0},
                {95, 0}
        };
    }

    @DataProvider(name = "testFindBiggestDigitPositiveProvider")
    public Object[][] createDataForFindBiggestDigitPositive() {
        return new Object[][]{
                {544223156l, 6},
                {3465498653189348452l, 9},
                {2, 2},
                {14, 4},
        };
    }

    @DataProvider(name = "testFindBiggestDigitNegativeProvider")
    public Object[][] createDataForFindBiggestDigitNegative() {
        return new Object[][]{
                {-6, 0},
                {-6545298653214564l, 0},
                {-203, 0},
                {-0, 0},
        };
    }

    @Test(description = "Positive scenario for getting a string with numbers",
            dataProvider = "testGetNumbersStringPositiveProvider")
    public void testGetNumbersStringPositive(int ab[], String numberString) {
        String actual = cyclesTasks.getNumbersString(ab[0], ab[1]);
        assertEquals(actual, numberString);
    }

    @Test(description = "Negative scenario for getting a string with numbers",
            expectedExceptions = IllegalArgumentException.class, dataProvider = "testGetNumbersStringNegativeProvider")
    public void testGetNumbersString(int ab[], String numberString) {
        String actual = cyclesTasks.getNumbersString(ab[0], ab[1]);
        assertEquals(actual, numberString);
    }

    @Test(description = "Positive scenario of calculating sum of squares",
            dataProvider = "testCalcSumSquaresPositiveProvider")
    public void testCalcSumSquaresPositive(int n, long sum) {
        long actual = cyclesTasks.calcSumOfSquares(n);
        assertEquals(actual, sum);
    }

    @Test(description = "Negative scenario of calculating sum of squares", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "For calculate sum of squares number should be > 0!",
            dataProvider = "testCalcSumSquaresNegativeProvider")
    public void testCalcSumSquaresNegative(int n, long sum) {
        long actual = cyclesTasks.calcSumOfSquares(n);
        assertEquals(actual, sum);
    }

    @Test(description = "Positive scenario of solving expression of the form: a(a+1)...(a+n-1)",
            dataProvider = "testSolveExpressionProvider")
    public void testSolveExpression(int an[], long result) {
        long actual = cyclesTasks.solveExpression(an[0], an[1]);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of calculating factorial",
            dataProvider = "testCalcFactorialPositiveProvider")
    public void testCalcFactorialPositive(int n, long factorial) {
        long actual = cyclesTasks.calcFactorial(n);
        assertEquals(actual, factorial);
    }

    @Test(description = "Negative scenario of calculating factorial", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Invalid value for calculate factorial!",
            dataProvider = "testCalcFactorialNegativeProvider")
    public void testCalcFactorialNegative(int n, long factorial) {
        long actual = cyclesTasks.calcFactorial(n);
        assertEquals(actual, factorial);
    }

    @Test(description = "Positive scenario of finding the biggest digit in number",
            dataProvider = "testFindBiggestDigitPositiveProvider")
    public void testFindBiggestDigitPositive(long n, int digit) {
        long actual = cyclesTasks.findBiggestDigit(n);
        assertEquals(actual, digit);
    }

    @Test(description = "Negative scenario of finding the biggest digit in number", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "It's not natural number!",
            dataProvider = "testFindBiggestDigitNegativeProvider")
    public void testFindBiggestDigitNegative(long n, int digit) {
        long actual = cyclesTasks.findBiggestDigit(n);
        assertEquals(actual, digit);
    }


}
