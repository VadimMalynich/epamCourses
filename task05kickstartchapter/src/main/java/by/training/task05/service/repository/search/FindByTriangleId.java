package by.training.task05.service.repository.search;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.FindingSpecification;

public class FindByTriangleId implements FindingSpecification<Triangle> {
    private long triangleId;

    public FindByTriangleId(long triangleId) {
        this.triangleId = triangleId;
    }

    @Override
    public boolean isExist(Triangle triangle) {
        return triangle.getId() == triangleId;
    }
}
