package by.training.decomposition.view;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle("langs.interface", new Locale("en", "US"))),
    RU(ResourceBundle.getBundle("langs.interface", new Locale("ru", "RU")));
    private ResourceBundle bundle;

    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public String getManagerLanguage(){
       return bundle.getLocale().getLanguage();
    }

    public String getManagerCountry(){
        return bundle.getLocale().getCountry();
    }
}
