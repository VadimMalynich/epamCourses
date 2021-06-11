package by.training.task02.tasks.branches;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BranchesTasksTest {
    private BranchesTasks branchesTasks = new BranchesTasks();

    @DataProvider(name = "testComparisonPositiveProvider")
    public Object[][] createDataForComparisonPositive() {
        return new Object[][]{
                {new int[]{15, 69}, 69},
                {new int[]{-3, 3}, 3},
                {new int[]{-20, -250}, -20},
                {new int[]{0, 36}, 36},
                {new int[]{0, -2593}, 0},
                {new int[]{548, 0}, 548},
                {new int[]{-203, 0}, 0},
        };
    }

    @DataProvider(name = "testComparisonNegativeProvider")
    public Object[][] createDataForComparisonNegative() {
        return new Object[][]{
                {new int[]{0, 0}, 0},
                {new int[]{-14, -14}, -14},
                {new int[]{20547, 20547}, 20547},
        };
    }

    @DataProvider(name = "testIsEquilateralTrianglePositiveProvider")
    public Object[][] createDataForPositiveTriangle() {
        return new Object[][]{
                {new int[]{2, 2, 2}, true},
                {new int[]{15, 5, 20}, false},
                {new int[]{444, 444, 444}, true},
                {new int[]{36, 15, 4}, false},
        };
    }

    @DataProvider(name = "testIsEquilateralTriangleNegativeProvider")
    public Object[][] createDataForNegativeTriangle() {
        return new Object[][]{
                {new int[]{0, 0, 0}, false},
                {new int[]{0, 5, 20}, false},
                {new int[]{444, 0, 444}, false},
                {new int[]{36, 15, 0}, false},
                {new int[]{-5, -2, -6}, false},
                {new int[]{36, -15, 0}, false},
                {new int[]{-10, 5, 15}, false},
                {new int[]{10, 10, -10}, false},
        };
    }

    @DataProvider(name = "testCheckNumbersEqualsProvider")
    public Object[][] createDataForNumbers() {
        return new Object[][]{
                {new int[]{15, 69}, 69},
                {new int[]{-1, 58}, 58},
                {new int[]{230, -69}, 230},
                {new int[]{3, 3}, 0},
                {new int[]{-20, -250}, -20},
                {new int[]{0, 36}, 36},
                {new int[]{0, -2593}, 0},
                {new int[]{548, 0}, 548},
                {new int[]{-203, 0}, 0},
                {new int[]{0, 0}, 0},
                {new int[]{-19, -19}, 0},
        };
    }

    @DataProvider(name = "testTemperaturePositiveProvider")
    public Object[][] createDataForTemperaturePositive() {
        return new Object[][]{
                {59.9, "Temperature is normal."},
                {0, "Temperature is normal."},
                {36.6, "Temperature is normal."},
                {-20, "Temperature is normal."},
                {-5.4, "Temperature is normal."},
                {60.1, "Fire hazardous situation."},
                {60.01, "Fire hazardous situation."},
                {1000, "Fire hazardous situation."},
                {598.5, "Fire hazardous situation."},
        };
    }

    @DataProvider(name = "testTemperatureNegativeProvider")
    public Object[][] createDataForTemperatureNegative() {
        return new Object[][]{
                {-273.16, "Temperature is normal."},
                {-5000, "Temperature is normal."},
                {-275, "Temperature is normal."},
                {-273.151, "Temperature is normal."},
        };
    }

    @DataProvider(name = "testCheckPasswordPositiveProvider")
    public Object[][] createDataForPasswordPositive() {
        return new Object[][]{
                {9583, "Your access level allows you to interact with database modules A, B and C!"},
                {1747, "Your access level allows you to interact with database modules A, B and C!"},
                {3331, "Your access level allows you to interact with database modules B and C!"},
                {7922, "Your access level allows you to interact with database modules B and C!"},
                {9455, "Your access level allows you to interact with database module C!"},
                {8997, "Your access level allows you to interact with database module C!"},
                {9999, "Your access level not allows you to interact with database modules!"},
                {1000, "Your access level not allows you to interact with database modules!"},
                {1234, "Your access level not allows you to interact with database modules!"},
        };
    }

    @DataProvider(name = "testCheckPasswordNegativeProvider")
    public Object[][] createDataForPasswordNegative() {
        return new Object[][]{
                {999, "Error"},
                {10000, "Error"},
                {0, "Error"},
                {-544, "Error"},
                {900, "Error"},
                {10001, "Error"},
                {-4488, "Error"},
                {0000, "Error"},
        };
    }


    @Test(description = "Positive scenario of the compare", dataProvider = "testComparisonPositiveProvider")
    public void testComparisonPositive(int ab[], int result) {
        int actual = branchesTasks.comparison(ab[0], ab[1]);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of the compare", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Variables are equal!", dataProvider = "testComparisonNegativeProvider")
    public void testComparisonNegative(int ab[], int result) {
        int actual = branchesTasks.comparison(ab[0], ab[1]);
        assertEquals(actual, result);
    }

    @Test(description = "Positive equilateral triangle test", dataProvider = "testIsEquilateralTrianglePositiveProvider")
    public void testIsEquilateralTrianglePositive(int abc[], boolean result) {
        boolean actual = branchesTasks.isEquilateralTriangle(abc[0], abc[1], abc[2]);
        assertEquals(actual, result);
    }

    @Test(description = "Negative equilateral triangle test", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "One or more side has wrong value",
            dataProvider = "testIsEquilateralTriangleNegativeProvider")
    public void testIsEquilateralTriangleNegative(int abc[], boolean result) {
        boolean actual = branchesTasks.isEquilateralTriangle(abc[0], abc[1], abc[2]);
        assertEquals(actual, result);
    }

    @Test(description = "Number comparison test", dataProvider = "testCheckNumbersEqualsProvider")
    public void testCheckNumbersEquals(int mn[], int result) {
        int actual = branchesTasks.checkNumbersEquals(mn[0], mn[1]);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of the normal temperature", dataProvider = "testTemperaturePositiveProvider")
    public void testTemperaturePositive(double temperature, String result) {
        String actual = branchesTasks.checkTemperatureForNormal(temperature);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of the normal temperature", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Impossible value for temperature!",
            dataProvider = "testTemperatureNegativeProvider")
    public void testTemperatureNegative(double temperature, String result) {
        String actual = branchesTasks.checkTemperatureForNormal(temperature);
        assertEquals(actual, result);
    }

    @Test(description = "Positive scenario of enter password", dataProvider = "testCheckPasswordPositiveProvider")
    public void testCheckPasswordPositive(int password, String result) {
        String actual = branchesTasks.checkPassword(password);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of enter password", expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Password must be 4 characters!",
            dataProvider = "testCheckPasswordNegativeProvider")
    public void testCheckPasswordNegative(int password, String result) {
        String actual = branchesTasks.checkPassword(password);
        assertEquals(actual, result);
    }
}
