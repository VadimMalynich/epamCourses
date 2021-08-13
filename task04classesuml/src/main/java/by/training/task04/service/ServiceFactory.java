package by.training.task04.service;

import by.training.task04.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final CalcAccountsAmountService calcAccountsAmountService = new CalcAccountsAmountServiceImpl();
    private final FilterDataService filterDataService = new FilterDataServiceImpl();
    private final FindDataService findDataService = new FindDataServiceImpl();
    private final GenerateDataService generateDataService = new GenerateDataServiceImpl();
    private final ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
    private final SortAccountsService sortAccountsService = new SortAccountsServiceImpl();
    private final WorkWithStatusService workWithStatusService = new WorkWithStatusServiceImpl();

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
