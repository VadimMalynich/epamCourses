package tasks;

import by.training.tasks.ThirtyThirdTask;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ThirtyThirdTaskTest {
    ThirtyThirdTask thirtyThirdTask = new ThirtyThirdTask();

    @DataProvider(name = "testGetSymbolPositionProvider")
    public Object[][] createDataForGetSymbolPosition() {
        return new Object[][]{
                {"d7wqdsa", 100},
                {"<", 60},
                {"|", 124},
                {"0", 48},
        };
    }

    @DataProvider(name = "testGetPreviousSymbolProvider")
    public Object[][] createDataForGetPreviousSymbol() {
        return new Object[][]{
                {100, 'c'},
                {60, ';'},
                {124, '{'},
                {48, '/'},
        };
    }

    @DataProvider(name = "testGetNextSymbolProvider")
    public Object[][] createDataForGetNextSymbol() {
        return new Object[][]{
                {100, 'e'},
                {60, '='},
                {124, '}'},
                {48, '1'},
        };
    }

    @Test(description = "Positive scenario of finding the symbol number", dataProvider = "testGetSymbolPositionProvider")
    public void testGetSymbolPosition(String str, int result) {
        double actual = thirtyThirdTask.getPositions(str);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of finding the previous symbol", dataProvider = "testGetPreviousSymbolProvider")
    public void testGetPreviousSymbol(int serialNumber, char result) {
        double actual = thirtyThirdTask.getPreviousSymbol(serialNumber);
        assertEquals(actual, result, 0.001);
    }

    @Test(description = "Positive scenario of finding the next symbol", dataProvider = "testGetNextSymbolProvider")
    public void testGetNextSymbol(int serialNumber, char result) {
        double actual = thirtyThirdTask.getNextSymbol(serialNumber);
        assertEquals(actual, result, 0.001);
    }
}