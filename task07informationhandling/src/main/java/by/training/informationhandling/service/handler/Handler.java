package by.training.informationhandling.service.handler;

import by.training.informationhandling.bean.Composite;
import by.training.informationhandling.service.ServiceException;

public interface Handler {
    void parse(String text, Composite root) throws ServiceException;
}
