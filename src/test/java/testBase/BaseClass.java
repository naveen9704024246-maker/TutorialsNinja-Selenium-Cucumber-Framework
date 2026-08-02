package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

    public static WebDriver driver;

    public static Logger logger = LogManager.getLogger(BaseClass.class);

    public static ReadConfig config = new ReadConfig();

    public static void setup() {

        logger.info("========== Test Execution Started ==========");

        String browser = config.getBrowser();

        logger.info("Browser selected : " + browser);

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            logger.info("ChromeDriver setup completed");

            driver = new ChromeDriver();

            logger.info("Chrome Browser Launched Successfully");

        } else {

            logger.error("Invalid Browser Name : " + browser);

            throw new RuntimeException("Browser not supported : " + browser);

        }

        driver.manage().window().maximize();
        logger.info("Browser Maximized");

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));

        logger.info("Implicit Wait Applied : " + config.getImplicitWait() + " Seconds");

        driver.get(config.getApplicationURL());

        logger.info("Application URL Opened : " + config.getApplicationURL());

    }

    public static void tearDown() {

        if (driver != null) {

            logger.info("Closing Browser");

            driver.quit();

            logger.info("Browser Closed Successfully");
        }

        logger.info("========== Test Execution Finished ==========");

    }

}