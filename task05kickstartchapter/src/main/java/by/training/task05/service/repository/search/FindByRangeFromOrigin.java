package by.training.task05.service.repository.search;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.FindingSpecification;

public class FindByRangeFromOrigin implements FindingSpecification<Triangle> {
    private double range;

    public FindByRangeFromOrigin(double range) {
        this.range = range;
    }

    @Override
    public boolean isExist(Triangle triangle) {
        for (Triangle.Point points : triangle.getPoints()) {
            if (range < calcPointDistance(points)) {
                return false;
            }
        }
        return true;
    }

    private double calcPointDistance(Triangle.Point point) {
        double distance = 0;
        distance = Math.sqrt(Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2));
        return distance;
    }
}
