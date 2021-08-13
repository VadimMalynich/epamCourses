package by.training.task05.service.repository;

import by.training.task05.bean.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleStorage {
    private List<Triangle> triangleList;

    private static TriangleStorage instance = new TriangleStorage();

    private TriangleStorage() {
        triangleList = new ArrayList<>();
    }

    public static TriangleStorage getInstance() {
        return instance;
    }

    public TriangleStorage(List<Triangle> triangleList) {
        this.triangleList = triangleList;
    }

    public List<Triangle> getTriangleList() {
        return triangleList;
    }
}
