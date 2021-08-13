package by.training.task05.service.observer;

import by.training.task05.bean.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleObservable {
    private Triangle triangle;
    private List<Observer<Triangle>> observers = new ArrayList<>();

    public void addObservers(Observer<Triangle> observer) {
        observers.add(observer);
    }

    public void deleteObservers(Observer<Triangle> observer) {
        observers.remove(observer);
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
        notifyObservers();
    }

    public void updateTrianglePoints(Triangle.Point oldPoint, Triangle.Point newPoint) {
        triangle.setPoint(oldPoint, newPoint);
        notifyObservers();
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(triangle));
    }
}
