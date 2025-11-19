package web.stepdef;

import core.DriverFactory;
import support.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class WebHooks {

    @Before("@web")
    public void beforeWeb() {

        DriverFactory.initDriver(System.getProperty("browser", "chrome"));
    }

    @After("@web")
    public void afterWeb(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.attachScreenshot("Failure Screenshot");
        }
        DriverFactory.quitDriver();
    }
}
