package com.bridgelabz.quantity_measurement_app.config;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input = ApplicationConfig.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            if (input == null) {
                throw new RuntimeException("application.properties file not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load application configuration", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}