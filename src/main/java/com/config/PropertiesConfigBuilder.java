package com.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

public class PropertiesConfigBuilder {
    private static Logger logger = LoggerFactory.getLogger(PropertiesConfigBuilder.class);
    public static Properties fromFilePath(String filePath) throws IOException {
        logger.debug("initializing properties from config file");
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        Properties kafkaProperties = new Properties();
        kafkaProperties.load(fileSystemResource.getInputStream());
        return kafkaProperties;
    }
}
