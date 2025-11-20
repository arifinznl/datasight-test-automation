package api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api/features",
        glue = {"api.stepdef"},
        tags = "@api",
        plugin = {
                "pretty",
                "html:reports/api-test.html",
                "json:reports/api-test.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)

public class ApiRunner {
}
