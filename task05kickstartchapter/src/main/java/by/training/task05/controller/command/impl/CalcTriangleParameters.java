package by.training.task05.controller.command.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.bean.TriangleParameters;
import by.training.task05.controller.command.Command;
import by.training.task05.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcTriangleParameters implements Command {
    private static final Logger userLogger = LogManager.getLogger(CalcTriangleParameters.class);

    @Override
    public void execute(String request) {
        File file = new File(request);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReadDataService readDataService = serviceFactory.getReadDataService();
        CreateTriangleService createTriangleService = serviceFactory.getCreateTriangle();
        CalcFigureParametersService calcFigureParametersService = serviceFactory.getCalcFigureParametersService();

        List<String> fileData;
        List<Triangle> triangles;
        List<TriangleParameters> triangleParametersList = new ArrayList<>();

        try {
            fileData = readDataService.readData(file);
            triangles = createTriangleService.createTriangles(fileData);
            for (Triangle tr : triangles) {
                TriangleParameters triangleParameters = new TriangleParameters(calcFigureParametersService.calcPerimeter(tr),
                        calcFigureParametersService.calcSquare(tr));
                triangleParametersList.add(triangleParameters);
            }
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        userLogger.info(Arrays.toString(triangleParametersList.toArray()));
    }
}
