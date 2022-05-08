package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ApiUtils {
    public static String getJson() {
        Path fileName = Path.of("five.json");
        String actual = null;
        try {
            actual = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return actual;
    }
}
