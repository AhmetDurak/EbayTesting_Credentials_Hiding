package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetCredentials {
    private static Properties properties;

    static {

        String path = "Credentials.properties";
        try {
            properties = new Properties();
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }
}
