package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig() {

        properties = new Properties();

        try {

            FileInputStream file = new FileInputStream("src/test/resources/config.properties/config.properties");
      //      FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public String getBrowser() {

        return properties.getProperty("browser");

    }

    public String getApplicationURL() {

        return properties.getProperty("url");

    }

    public int getImplicitWait() {

        return Integer.parseInt(properties.getProperty("implicitWait"));

    }

}