package hooks;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.BaseClass;
import utilities.ScreenshotUtility;

public class Hooks {

    @Before
    public void setUp() {

        BaseClass.setup();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {

            ScreenshotUtility.captureScreenshot(
                    BaseClass.driver,
                    scenario.getName().replace(" ", "_"));

        }

        BaseClass.tearDown();

    }

}