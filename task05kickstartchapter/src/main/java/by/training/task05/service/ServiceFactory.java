package by.training.task05.service;

import by.training.task05.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    private final CalcFigureParametersService calcFigureParametersService = new CalcFigureParametersServiceImpl();
    private final CreateTriangleService createTriangleService = new CreateTriangleServiceImpl();
    private final DefineFigureTypeService defineFigureTypeService = new DefineFigureTypeServiceImpl();
    private final ReadDataService readDataService = new ReadDataServiceImpl();
    private final ValidateDataService validateDataService = new ValidateDataServiceImpl();


    public static ServiceFactory getInstance() {
        return instance;
    }

    public CalcFigureParametersService getCalcFigureParametersService() {
        return calcFigureParametersService;
    }

    public CreateTriangleService getCreateTriangle() {
        return createTriangleService;
    }

    public DefineFigureTypeService getDefineFigureTypeService() {
        return defineFigureTypeService;
    }

    public ReadDataService getReadDataService() {
        return readDataService;
    }

    public ValidateDataService getValidateDataService() {
        return validateDataService;
    }
}
