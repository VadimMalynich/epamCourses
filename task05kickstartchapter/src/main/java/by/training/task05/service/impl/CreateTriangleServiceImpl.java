package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.CreateTriangleService;
import by.training.task05.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class CreateTriangleServiceImpl implements CreateTriangleService {
    private static ValidateDataServiceImpl validator = new ValidateDataServiceImpl();
    private long id = 1;

    @Override
    public Triangle createTriangle(String line) throws ServiceException {
        if (!validator.validateLine(line)) {
            throw new ServiceException("There is no correct data for creating triangle");
        }
        return getTriangle(line);
    }

    @Override
    public List<Triangle> createTriangles(List<String> lines) throws ServiceException {
        List<String> validatedLines = validator.validateReadData(lines);
        if (validatedLines.isEmpty()) {
            throw new ServiceException("There is no correct data for creating triangles");
        }
        id = 1;
        //List<Triangle> triangles = lines.stream().map(this::getTriangle).collect(Collectors.toList());
        List<Triangle> triangles = new ArrayList<>();
        for (String line : validatedLines) {
            Triangle triangle = getTriangle(line);
            triangles.add(triangle);
        }
        return triangles;
    }

    /**
     * Create triangle from line that was validated
     *
     * @param line valid {@code String} with data for create triangle
     * @return created triangle
     */
    private Triangle getTriangle(String line) {
        line = line.trim();
        String[] stringValues = line.split("[ ]+");
        Triangle triangle = new Triangle(id++, stringValues[0]);
        triangle.addPoint(triangle.new Point(Double.parseDouble(stringValues[1]), Double.parseDouble(stringValues[2])));
        triangle.addPoint(triangle.new Point(Double.parseDouble(stringValues[3]), Double.parseDouble(stringValues[4])));
        triangle.addPoint(triangle.new Point(Double.parseDouble(stringValues[5]), Double.parseDouble(stringValues[6])));
        return triangle;
    }

}
