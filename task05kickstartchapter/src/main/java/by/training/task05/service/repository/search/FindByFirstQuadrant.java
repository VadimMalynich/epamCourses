package by.training.task05.service.repository.search;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.FindingSpecification;

public class FindByFirstQuadrant implements FindingSpecification<Triangle> {
    public FindByFirstQuadrant() {
    }

    @Override
    public boolean isExist(Triangle triangle) {
        for (Triangle.Point points : triangle.getPoints()) {
            if (points.getX() < 0 || points.getY() < 0) {
                return false;
            }
        }
        return true;
    }
}
