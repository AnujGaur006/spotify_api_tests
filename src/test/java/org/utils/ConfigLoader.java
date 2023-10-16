package org.utils;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    public Properties prop;

    private ConfigLoader(){
        prop = PropertyUtils.propertyLoader("src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null)
            configLoader = new ConfigLoader();
        return configLoader;
    }
}
