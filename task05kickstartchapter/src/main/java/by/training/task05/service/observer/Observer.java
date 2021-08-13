package by.training.task05.service.observer;

import by.training.task05.bean.Triangle;

public interface Observer<T extends Triangle> {
    void update(T item);
}
