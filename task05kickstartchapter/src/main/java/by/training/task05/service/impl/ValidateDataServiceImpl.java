package by.training.task05.service.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ServiceException;
import by.training.task05.service.ValidateDataService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidateDataServiceImpl implements ValidateDataService {
    private static Pattern wrongCharPattern = Pattern.compile("[^-. 0-9]");
    private static Pattern valuePattern = Pattern.compile("[-]?\\d+([.]\\d+)?");

    @Override
    public List<String> validateReadData(List<String> lines) throws ServiceException {
        if (lines.isEmpty()) {
            throw new ServiceException("No lines for validate!");
        }
        lines = lines.stream().filter(s -> validateLine(s)).collect(Collectors.toList());
//        List<String> temp = new ArrayList<>();
//        for (String line : lines) {
//            // Matcher matcher = wrongCharPattern.matcher(line);
//            // if (!matcher.find()) {
//            if (validateLine(line)) {
//                temp.add(line);
//            }
////            } else {
////                throw new ServiceException("Incorrect line with data for create object");
////            }
//        }
//        return temp;
        return lines;
    }

    @Override
    public boolean isTriangles(Triangle triangle) throws ServiceException {
        if (triangle == null) {
            throw new ServiceException("No triangle for check on correct points");
        }
        boolean flag = false;
        List<Triangle.Point> points = triangle.getPoints();
        if (((points.get(0).getX() != points.get(1).getX() || points.get(0).getX() != points.get(2).getX())
                && (points.get(0).getY() != points.get(1).getY() || points.get(0).getY() != points.get(2).getY()))
                && checkSides(triangle)) {
            flag = true;
        }
        return flag;
    }

    /**
     * Calculate triangle sides by {@link CalcFigureParametersServiceImpl#calcSideSize(Triangle.Point, Triangle.Point)}
     * and checks whether the sides can create a triangle
     *
     * @param triangle valid {@code Triangle} without calculated sides
     * @return {@code true} if can make a triangle from the sides, {@code false} otherwise
     * @throws ServiceException
     */
    private boolean checkSides(Triangle triangle) throws ServiceException {
        CalcFigureParametersServiceImpl calcParameters = new CalcFigureParametersServiceImpl();
        boolean flag = false;
        List<Triangle.Point> points = triangle.getPoints();
        triangle.setFirstSideLength(calcParameters.calcSideSize(points.get(0), points.get(1)));
        triangle.setSecondSideLength(calcParameters.calcSideSize(points.get(0), points.get(2)));
        triangle.setThirdSideLength(calcParameters.calcSideSize(points.get(1), points.get(2)));
        if (triangle.getFirstSideLength() + triangle.getSecondSideLength() > triangle.getThirdSideLength()
                && triangle.getFirstSideLength() + triangle.getThirdSideLength() > triangle.getSecondSideLength()
                && triangle.getSecondSideLength() + triangle.getThirdSideLength() > triangle.getFirstSideLength()) {
            flag = true;
        }
        return flag;
    }

    public boolean validateLine(String line) {
        boolean flag = false;
        line = line.trim();
        String[] stringValues = line.split("[ ]+");
        if (stringValues.length == 7 && checkPoint(stringValues[1]) && checkPoint(stringValues[2]) && checkPoint(stringValues[3])
                && checkPoint(stringValues[4]) && checkPoint(stringValues[5]) && checkPoint(stringValues[6])) {
            flag = true;
        }
        return flag;
    }

    /**
     * Check {@code String} to match the pattern {@link ValidateDataServiceImpl#valuePattern}
     *
     * @param value {@code String} that will be match
     * @return {@code true} if {@code String} match requirements, {@code else} otherwise
     */
    private boolean checkPoint(String value) {
        Matcher matcher = valuePattern.matcher(value);
        return matcher.find();
    }
}
