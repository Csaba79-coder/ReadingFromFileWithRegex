package config;

public class ConfigReader {

    private static final String DEVICES_PATH = "src/main/resources/regexExample.txt"; // src/main/resources/regexExample.txt

    public static String getPath() { //this must be static because in the test :: is used!!!
        return DEVICES_PATH;
    }
}
