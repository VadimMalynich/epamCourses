package by.training.task08xml.service.builder;

import by.training.task08xml.service.exceptions.ServiceException;

public class PostcardBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public PostcardBuilderFactory() {
    }

    /**
     * Creating parser class that will be parsed xml file
     *
     * @param typeParser {@code String} with parser type that will be converted into {@link TypeParser}
     * @return new class object that extends from {@link AbstractPostcardsBuilder}
     * @throws ServiceException custom exceptions
     */
    public static AbstractPostcardsBuilder createPostcardBuilder(String typeParser) throws ServiceException {
        if (typeParser == null) {
            throw new ServiceException("It is impossible to determine the type of parser");
        }
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM: {
                return new PostcardDOMBuilder();
            }
            case STAX: {
                return new PostcardStAXBuilder();
            }
            case SAX: {
                return new PostcardSAXBuilder();
            }
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

}
