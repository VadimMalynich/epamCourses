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

public class DefineTrianglesType implements Command {
    private static final Logger userLogger = LogManager.getLogger(DefineTrianglesType.class);

    @Override
    public void execute(String request) {
        File file = new File(request);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ReadDataService readDataService = serviceFactory.getReadDataService();
        CreateTriangleService createTriangleService = serviceFactory.getCreateTriangle();
        DefineFigureTypeService defineFigureTypeService = serviceFactory.getDefineFigureTypeService();

        List<String> list = new ArrayList<>();
        List<Triangle> triangles;

        try {
            list = readDataService.readData(file);
            triangles = createTriangleService.createTriangles(list);
            list.clear();
            for (Triangle tr : triangles) {
                list.add(defineFigureTypeService.defineTriangleType(tr));
            }
        } catch (ServiceException e) {
            userLogger.error(e);
        }
        userLogger.info(Arrays.toString(list.toArray()));
    }
}
