package by.training.informationhandling.service.sorting;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.service.ServiceException;
import by.training.informationhandling.service.impl.ReadDataServiceImpl;
import by.training.informationhandling.service.impl.TextParserServiceImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SortingParagraphsServiceTest {
    private SortingParagraphsService service = new SortingParagraphsService();
    private ReadDataServiceImpl readDataService = new ReadDataServiceImpl();
    private TextParserServiceImpl textParserService = new TextParserServiceImpl();
    private Composite composite;
    private List<String> result = new ArrayList<>();

    @BeforeTest
    public void init() throws ServiceException {
        String text = readDataService.readData(new File("data/test.txt"));
        composite = textParserService.parseText(text);
        result.add("I love him very much. He is a member of our family. ");
        result.add("Many people are fond of pets. They keep different animals and birds as pets. More often they are dogs, cats, hamsters, guinea- parrots and fish. ");
        result.add("I teach him to talk. He knows many words and can speak well. He can answer to his name. I take care of my pet. I give him food and water every day. He likes fruit and vegetables. He likes to fly, play and talk. ");
        result.add("As for me I like parrots. They are my favourite pets. They are clever and nice. I've got a parrot. His name is Kesha. He's blue. He's not big, he's little. He has got a small head, a yellow beak, a short neck, two beautiful wings and a long tail. He lives in a cage. ");
    }

    @Test(description = "Positive scenario of sorting paragraphs.")
    public void testGetSortedData() throws ServiceException {
        List<String> actual = service.getSortedData(composite);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of sorting paragraphs (composite doesn't exist).", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Can not sorting paragraphs by sentence count.")
    public void testGetSortedDataNegative() throws ServiceException {
        Composite composite = null;
        List<String> actual = service.getSortedData(composite);
        assertEquals(actual, result);
    }
}