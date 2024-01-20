package util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reader {

    private static final Logger logger = Logger.getLogger(Reader.class);

    private static final String FILE_PATH = "src/test/resources/app.properties";
    private static final Properties props = new Properties();

    public static String readProperty(String key){

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/app.properties");
            props.load(fis);
        } catch (IOException e) {
            logger.error("file not found");
        }

        return props.getProperty(key);
    }
}
