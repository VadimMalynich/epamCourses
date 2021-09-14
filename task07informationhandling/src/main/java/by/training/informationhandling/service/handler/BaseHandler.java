package by.training.informationhandling.service.handler;

import java.util.regex.Pattern;

public abstract class BaseHandler implements Handler {
    protected Handler next = null;
    protected Pattern pattern = null;
}
