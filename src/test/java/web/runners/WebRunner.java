package web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web/features",
        glue = {"web.stepdef", "hooks"},
        tags = "@web",
        plugin = {
                "pretty",
                "html:reports/web-test.html",
                "json:reports/web-test.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        }
)

public class WebRunner {
}
