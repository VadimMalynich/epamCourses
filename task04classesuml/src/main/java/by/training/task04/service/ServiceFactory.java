package by.training.task04.service;

import by.training.task04.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    CalcAccountsAmountService calcAccountsAmountService = new CalcAccountsAmountServiceImpl();
    FilterDataService filterDataService = new FilterDataServiceImpl();
    FindDataService findDataService = new FindDataServiceImpl();
    GenerateDataService generateDataService = new GenerateDataServiceImpl();
    ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
    SortAccountsService sortAccountsService = new SortAccountsServiceImpl();
    WorkWithStatusService workWithStatusService = new WorkWithStatusServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CalcAccountsAmountService getCalcAccountsAmountService() {
        return calcAccountsAmountService;
    }

    public FilterDataService getFilterDataService() {
        return filterDataService;
    }

    public FindDataService getFindDataService() {
        return findDataService;
    }

    public GenerateDataService getGenerateDataService() {
        return generateDataService;
    }

    public ReadFromFileService getReadFromFileService() {
        return readFromFileService;
    }

    public SortAccountsService getSortAccountsService() {
        return sortAccountsService;
    }

    public WorkWithStatusService getWorkWithStatusService() {
        return workWithStatusService;
    }
}
