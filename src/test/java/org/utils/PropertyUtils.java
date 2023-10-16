package org.utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath){
        Properties properties = new Properties();
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader(filePath));
            try{
                properties.load(reader);
                reader.close();
            } catch (IOException e){
                throw new RuntimeException("Failed to load properties file - " + filePath);
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at specified file path - " + filePath);
        }
        return properties;
    }
}
