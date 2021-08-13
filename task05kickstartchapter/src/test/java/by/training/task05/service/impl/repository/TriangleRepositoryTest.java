package by.training.task05.service.impl.repository;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.TriangleRepository;
import by.training.task05.service.repository.search.*;
import by.training.task05.service.repository.sorting.SortById;
import by.training.task05.service.repository.sorting.SortByName;
import by.training.task05.service.repository.sorting.SortByX;
import by.training.task05.service.repository.sorting.SortByY;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleRepositoryTest {
    Triangle triangle1, triangle2, triangle3, triangle4, triangle5;
    static TriangleRepository triangleRepository;

    @BeforeGroups("findSpecification")
    public void initialize() {
        /*ReadDataServiceImpl readDataService = new ReadDataServiceImpl();
        ValidateDataServiceImpl validator = new ValidateDataServiceImpl();
        CreateTriangleImpl creator = new CreateTriangleImpl();
        List<String> fileData = readDataService.readData(new File("data/tests/correct.txt"));
        fileData = validator.validateReadData(fileData);
        List<Triangle> triangles = creator.createTriangles(fileData);
        triangle1 = triangles.get(0);
        triangle2 = triangles.get(1);
        triangle3 = triangles.get(2);
        triangle4 = triangles.get(3);
        triangle5 = triangles.get(4);*/
        triangle1 = new Triangle(1, "triangle1");
        triangle1.addPoint(triangle1.new Point(5, 3.5));
        triangle1.addPoint(triangle1.new Point(5, 0));
        triangle1.addPoint(triangle1.new Point(0, 0));

        triangle2 = new Triangle(2, "triangle69");
        triangle2.addPoint(triangle1.new Point(-2.6, -1));
        triangle2.addPoint(triangle1.new Point(1.3, -1.75));
        triangle2.addPoint(triangle1.new Point(-1, 2.05));

        triangle3 = new Triangle(3, "triangle24");
        triangle3.addPoint(triangle1.new Point(-3.4, -0.8));
        triangle3.addPoint(triangle1.new Point(-4.6, -1.6));
        triangle3.addPoint(triangle1.new Point(-4, -2.3));

        triangle4 = new Triangle(4, "tr2");
        triangle4.addPoint(triangle1.new Point(-6.9, 4.02));
        triangle4.addPoint(triangle1.new Point(-5.74, 5));
        triangle4.addPoint(triangle1.new Point(-6.12, 4.49));

        triangle5 = new Triangle(5, "triaNG");
        triangle5.addPoint(triangle1.new Point(3.6, -2.99));
        triangle5.addPoint(triangle1.new Point(4.86, -1.15));
        triangle5.addPoint(triangle1.new Point(6.12, -3.30));

        triangleRepository = new TriangleRepository();
        triangleRepository.add(triangle1);
        triangleRepository.add(triangle2);
        triangleRepository.add(triangle3);
        triangleRepository.add(triangle4);
        triangleRepository.add(triangle5);
    }

    @Test(groups = {"findSpecification"})
    public void findById() {
        FindByTriangleId byId = new FindByTriangleId(4);
        List<Triangle> result = new ArrayList<>();
        result.add(triangle4);
        assertEquals(triangleRepository.findBySpecification(byId), result);
    }

    @Test(groups = {"findSpecification"})
    public void findByName() {
        FindByTriangleName byName = new FindByTriangleName("triangle69");
        List<Triangle> result = new ArrayList<>();
        result.add(triangle2);
        assertEquals(triangleRepository.findBySpecification(byName), result);
    }

    @Test(groups = {"findSpecification"})
    public void findByFirstQuadrant() {
        FindByFirstQuadrant byFirstQuadrant = new FindByFirstQuadrant();
        List<Triangle> result = new ArrayList<>();
        result.add(triangle1);
        assertEquals(triangleRepository.findBySpecification(byFirstQuadrant), result);
    }

    @Test(groups = {"findSpecification"})
    public void findBySecondQuadrant() {
        FindBySecondQuadrant bySecondQuadrant = new FindBySecondQuadrant();
        List<Triangle> result = new ArrayList<>();
        result.add(triangle4);
        assertEquals(triangleRepository.findBySpecification(bySecondQuadrant), result);
    }

    @Test(groups = {"findSpecification"})
    public void findByThirdQuadrant() {
        FindByThirdQuadrant byThirdQuadrant = new FindByThirdQuadrant();
        List<Triangle> result = new ArrayList<>();
        result.add(triangle3);
        assertEquals(triangleRepository.findBySpecification(byThirdQuadrant), result);
    }

    @Test(groups = {"findSpecification"})
    public void findByFourthQuadrant() {
        FindByFourthQuadrant byFourthQuadrant = new FindByFourthQuadrant();
        List<Triangle> result = new ArrayList<>();
        result.add(triangle5);
        assertEquals(triangleRepository.findBySpecification(byFourthQuadrant), result);
    }

    @Test(groups = {"findSpecification"})
    public void findByRangeFromOrigin() {
        FindByRangeFromOrigin byRangeFromOrigin = new FindByRangeFromOrigin(5);
        List<Triangle> result = new ArrayList<>();
        result.add(triangle2);
        result.add(triangle3);
        assertEquals(triangleRepository.findBySpecification(byRangeFromOrigin), result);
    }

    @BeforeGroups("sortSpecification")
    public void init() {
        triangle1 = new Triangle(59, "triangle1");
        triangle1.addPoint(triangle1.new Point(5, 3.5));
        triangle1.addPoint(triangle1.new Point(5, 0));
        triangle1.addPoint(triangle1.new Point(0, 0));

        triangle2 = new Triangle(200654842l, "tree");
        triangle2.addPoint(triangle1.new Point(-2.6, -1));
        triangle2.addPoint(triangle1.new Point(1.3, -1.75));
        triangle2.addPoint(triangle1.new Point(-1, 2.05));

        triangle3 = new Triangle(5, "lake");
        triangle3.addPoint(triangle1.new Point(-3.4, -0.8));
        triangle3.addPoint(triangle1.new Point(-4.6, -1.6));
        triangle3.addPoint(triangle1.new Point(-4, -2.3));

        triangleRepository = new TriangleRepository();
        triangleRepository.deleteAll();
        triangleRepository.add(triangle1);
        triangleRepository.add(triangle2);
        triangleRepository.add(triangle3);
    }

    @Test(groups = {"sortSpecification"})
    public void sortById() {
        SortById sortById = new SortById();
        List<Triangle> result = new ArrayList<>();
        result.add(triangle3);
        result.add(triangle1);
        result.add(triangle2);
        assertEquals(triangleRepository.sortBySpecification(sortById), result);
    }

    @Test(groups = {"sortSpecification"})
    public void sortByName() {
        SortByName sortByName = new SortByName();
        List<Triangle> result = new ArrayList<>();
        result.add(triangle3);
        result.add(triangle2);
        result.add(triangle1);
        assertEquals(triangleRepository.sortBySpecification(sortByName), result);
    }

    @Test(groups = {"sortSpecification"})
    public void sortByX() {
        SortByX sortByX = new SortByX();
        List<Triangle> result = new ArrayList<>();
        Triangle triangle1 = new Triangle(59, "triangle1");
        triangle1.addPoint(triangle1.new Point(0, 0));
        triangle1.addPoint(triangle1.new Point(5, 0));
        triangle1.addPoint(triangle1.new Point(5, 3.5));

        Triangle triangle2 = new Triangle(200654842l, "tree");
        triangle2.addPoint(triangle1.new Point(-2.6, -1));
        triangle2.addPoint(triangle1.new Point(-1, 2.05));
        triangle2.addPoint(triangle1.new Point(1.3, -1.75));

        Triangle triangle3 = new Triangle(5, "lake");
        triangle3.addPoint(triangle1.new Point(-4.6, -1.6));
        triangle3.addPoint(triangle1.new Point(-4, -2.3));
        triangle3.addPoint(triangle1.new Point(-3.4, -0.8));

        result.add(triangle3);
        result.add(triangle2);
        result.add(triangle1);
        assertEquals(triangleRepository.sortBySpecification(sortByX), result);
    }

    @Test(groups = {"sortSpecification"})
    public void sortByY() {
        SortByY sortByY = new SortByY();
        List<Triangle> result = new ArrayList<>();
        Triangle triangle1 = new Triangle(59, "triangle1");
        triangle1.addPoint(triangle1.new Point(0, 0));
        triangle1.addPoint(triangle1.new Point(5, 0));
        triangle1.addPoint(triangle1.new Point(5, 3.5));

        Triangle triangle2 = new Triangle(200654842l, "tree");
        triangle2.addPoint(triangle1.new Point(1.3, -1.75));
        triangle2.addPoint(triangle1.new Point(-2.6, -1));
        triangle2.addPoint(triangle1.new Point(-1, 2.05));

        Triangle triangle3 = new Triangle(5, "lake");
        triangle3.addPoint(triangle1.new Point(-4, -2.3));
        triangle3.addPoint(triangle1.new Point(-4.6, -1.6));
        triangle3.addPoint(triangle1.new Point(-3.4, -0.8));

        result.add(triangle3);
        result.add(triangle2);
        result.add(triangle1);
        assertEquals(triangleRepository.sortBySpecification(sortByY), result);
    }
}
