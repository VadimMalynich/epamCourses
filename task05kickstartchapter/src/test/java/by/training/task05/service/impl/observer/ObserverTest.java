package by.training.task05.service.impl.observer;

import by.training.task05.bean.Triangle;
import by.training.task05.bean.TriangleParameters;
import by.training.task05.service.observer.TriangleObservable;
import by.training.task05.service.observer.TriangleObserver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ObserverTest {
    private Triangle triangle;
    private TriangleObserver observer = TriangleObserver.getInstance();
    private TriangleObservable observable = new TriangleObservable();

    private List<Triangle.Point> points;

    private static final double DELTA = 0.001;
    private static final double START_PERIMETER = 12;
    private static final double FINISH_PERIMETER = 12.94427190999916;
    private static final double START_SQUARE = 6;
    private static final double FINISH_SQUARE = 8;


    @BeforeTest
    public void initialize() {
        triangle = new Triangle(5452123159544l, "triangle");
        triangle.addPoint(triangle.new Point(4, 3));
        triangle.addPoint(triangle.new Point(4, 0));
        triangle.addPoint(triangle.new Point(0, 0));
        points = triangle.getPoints();
        observable.addObservers(observer);

    }

    @Test(description = "Checking the operation of the observer pattern")
    public void testNotifications() {
        observable.setTriangle(triangle);
        TriangleParameters startParameters = new TriangleParameters(START_PERIMETER, START_SQUARE);
        assertEquals(startParameters, observer.getParametersMap(triangle.getId()));

        observable.updateTrianglePoints(points.get(0), triangle.new Point(2, 4));
        TriangleParameters finishParameters = new TriangleParameters(FINISH_PERIMETER, FINISH_SQUARE);
        assertEquals(finishParameters, observer.getParametersMap(triangle.getId()));
    }
}
