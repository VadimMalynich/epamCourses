package by.training.task08xml.service.builder;

import by.training.task08xml.bean.AdPostcard;
import by.training.task08xml.bean.GreetingPostcard;
import by.training.task08xml.bean.Postcard;
import by.training.task08xml.service.exceptions.ServiceException;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that contains sets with data that can be parsed from xml file
 * It is abstract and is the parent class for parser classes
 */
public abstract class AbstractPostcardsBuilder {
    protected Set<Postcard> postcards;
    protected Set<AdPostcard> adPostcards;
    protected Set<GreetingPostcard> greetingPostcards;

    public AbstractPostcardsBuilder() {
        postcards = new HashSet<>();
        adPostcards = new HashSet<>();
        greetingPostcards = new HashSet<>();
    }

    public AbstractPostcardsBuilder(Set<Postcard> postcards, Set<AdPostcard> adPostcards, Set<GreetingPostcard> greetingPostcards) {
        this.postcards = postcards;
        this.adPostcards = adPostcards;
        this.greetingPostcards = greetingPostcards;
    }

    public Set<Postcard> getPostcards() {
        return postcards;
    }

    public Set<AdPostcard> getAdPostcards() {
        return adPostcards;
    }

    public Set<GreetingPostcard> getGreetingPostcards() {
        return greetingPostcards;
    }

    /**
     * Building data sets using xml file parsing using different DOM, SAX or StAX methods
     *
     * @param filename {@code String} with file path
     * @throws ServiceException custom exceptions
     */
    public abstract void buildSetPostcards(String filename) throws ServiceException;
}
