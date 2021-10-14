package com.example.config;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
    private static final Logger LOG = Logger.getLogger(ConfigurationProperties.class);

    public static Properties createProperties(String fileName) {
        Properties properties = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/" + fileName);
            properties.load(fis);
        } catch (IOException e) {
            LOG.error("Test data file is missing");
        }
        return properties;
    }
}
