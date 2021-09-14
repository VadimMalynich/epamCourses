package by.training.informationhandling.service.impl;

import by.training.informationhandling.service.ServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class ReadDataServiceImplTest {
    private ReadDataServiceImpl readDataService = new ReadDataServiceImpl();
    StringBuilder builder = new StringBuilder();
    @BeforeTest
    public void initialize(){
        builder.append("\t").append("Many people are fond of pets. They keep different animals and birds as pets. More often they are dogs, cats, hamsters, guinea-pigs, parrots and fish.").append(System.lineSeparator());
        builder.append("\t").append("As for me I like parrots. They are my favourite pets. They are clever and nice. I've got a parrot. His name is Kesha. He's blue. He's not big, he's little. He has got a small head, a yellow beak, a short neck, two beautiful wings and a long tail. He lives in a cage.").append(System.lineSeparator());
        builder.append("\t").append("I teach him to talk. He knows many words and can speak well. He can answer to his name. I take care of my pet. I give him food and water every day. He likes fruit and vegetables. He likes to fly, play and talk.").append(System.lineSeparator());
        builder.append("\t").append("I love him very much. He is a member of our family.");
    }


    @DataProvider(name = "testReadDataPositiveProvider")
    public Object[][] createFilesForReadData() {
        return new Object[][]{
                {new File("data/test.txt")}
        };
    }
    @DataProvider(name = "testReadDataNegativeProvider")
    public Object[][] createFilesForReadDataNegative() {
        return new Object[][]{
                {new File("data/te.txt")},
                {new File("data/test.tt")},
                {new File("data/test.")},
                {new File("test.txt")}
        };
    }

    @Test(description = "Positive scenario of read text from file", dataProvider = "testReadDataPositiveProvider")
    public void testReadDataPositive(File file) throws ServiceException {
        String actual = readDataService.readData(file);
        assertEquals(actual, builder.toString());
    }

    @Test(description = "Negative scenario of read text from file (Incorrect file path)", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "File doesn't exist!", dataProvider = "testReadDataNegativeProvider")
    public void testReadDataNegative(File file) throws ServiceException {
        String actual = readDataService.readData(file);
        assertEquals(actual, builder.toString());
    }
}