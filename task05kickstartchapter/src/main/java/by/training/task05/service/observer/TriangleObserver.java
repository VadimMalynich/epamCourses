package by.training.task05.service.observer;

import by.training.task05.bean.Triangle;
import by.training.task05.bean.TriangleParameters;
import by.training.task05.service.ServiceException;
import by.training.task05.service.impl.CalcFigureParametersServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class TriangleObserver implements Observer<Triangle> {
    private static TriangleObserver instance = new TriangleObserver();
    private static final CalcFigureParametersServiceImpl CALC_PARAMETERS = new CalcFigureParametersServiceImpl();

    private Map<Long, TriangleParameters> parametersMap = new HashMap<>();

    private TriangleObserver() {
    }

    public static TriangleObserver getInstance() {
        return instance;
    }

    @Override
    public void update(Triangle item) {
        try {
            double perimeter = CALC_PARAMETERS.calcPerimeter(item);
            double square = CALC_PARAMETERS.calcSquare(item);

            TriangleParameters parameters = new TriangleParameters(perimeter, square);
            parametersMap.put(item.getId(), parameters);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public TriangleParameters getParametersMap(Long id) {
        return parametersMap.get(id);
    }
}
