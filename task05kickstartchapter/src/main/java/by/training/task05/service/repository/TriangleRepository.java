package by.training.task05.service.repository;

import by.training.task05.bean.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepository implements Repository<Triangle> {
    private List<Triangle> storage;

    public TriangleRepository() {
        storage = TriangleStorage.getInstance().getTriangleList();
    }

    @Override
    public void add(Triangle triangle) {
        storage.add(triangle);
    }

    @Override
    public void delete(int id) {
        for (Triangle triangle : storage) {
            if (triangle.getId() == id) {
                storage.remove(triangle);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }


    @Override
    public void update(Triangle oldTriangle, Triangle newTriangle) {
        if (storage.contains(oldTriangle)) {
            int oldTriangleIndex = storage.indexOf(oldTriangle);
            storage.set(oldTriangleIndex, newTriangle);
        } else {
            System.out.println("This triangle is not in the storage");
        }
    }

    @Override
    public List<Triangle> getAll() {
        return storage;
    }

    @Override
    public List<Triangle> findBySpecification(FindingSpecification findingSpecification) {
        List<Triangle> triangleList = new ArrayList<>();
        for (Triangle triangle : storage) {
            if (findingSpecification.isExist(triangle)) {
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }

    @Override
    public List<Triangle> sortBySpecification(SortingSpecification specification) {
        List<Triangle> triangleList = specification.sort(getAll());
        return triangleList;
    }
}
