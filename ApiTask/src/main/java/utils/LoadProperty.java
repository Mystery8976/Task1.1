package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {
    public static String getProperty(String property) {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("data.properties")) {
            properties.load(inputStream);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
