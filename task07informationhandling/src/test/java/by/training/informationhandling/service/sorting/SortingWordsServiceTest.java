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

public class SortingWordsServiceTest {
    private SortingWordsService service = new SortingWordsService();
    private ReadDataServiceImpl readDataService = new ReadDataServiceImpl();
    private TextParserServiceImpl textParserService = new TextParserServiceImpl();
    private Composite composite;
    private List<String> result = new ArrayList<>();

    @BeforeTest
    public void init() throws ServiceException {
        String text = readDataService.readData(new File("data/test.txt"));
        composite = textParserService.parseText(text);
        result.add(". of are Many fond pets people ");
        result.add(". as and They keep pets birds animals different ");
        result.add(", , , - . are and More they dogs cats fish often guinea parrots hamsters ");
        result.add("I . As me for like parrots ");
        result.add(". my are They pets favourite ");
        result.add(". are and They nice clever ");
        result.add("a . got I've parrot ");
        result.add(". is His name Kesha ");
        result.add(". He's blue ");
        result.add(", . not big He's he's little ");
        result.add("a , a , a , a . He has got two and head beak neck long tail small short wings yellow beautiful ");
        result.add("a . He in cage lives ");
        result.add("I . to him talk teach ");
        result.add(". He and can many well knows words speak ");
        result.add(". He to can his name answer ");
        result.add("I . of my pet take care ");
        result.add("I . him and day give food water every ");
        result.add(". He and likes fruit vegetables ");
        result.add(", . He to fly and play talk likes ");
        result.add("I . him love very much ");
        result.add("a . He is of our member family ");
    }

    @Test(description = "Positive scenario of sorting words in sentence.")
    public void testGetSortedData() throws ServiceException {
        List<String> actual = service.getSortedData(composite);
        assertEquals(actual, result);
    }

    @Test(description = "Negative scenario of sorting words in sentence (composite doesn't exist).", expectedExceptions = ServiceException.class,
            expectedExceptionsMessageRegExp = "Can not sorting paragraphs by sentence count.")
    public void testGetSortedDataNegative() throws ServiceException {
        Composite composite = null;
        List<String> actual = service.getSortedData(composite);
        assertEquals(actual, result);
    }
}