package by.training.task05.service.repository.search;

import by.training.task05.bean.Triangle;
import by.training.task05.service.repository.FindingSpecification;

public class FindByTriangleName implements FindingSpecification<Triangle> {
    private String triangleName;

    public FindByTriangleName(String name) {
        this.triangleName = name;
    }

    @Override
    public boolean isExist(Triangle triangle) {
        return triangle.getName().equalsIgnoreCase(triangleName);
    }
}
