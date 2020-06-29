package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featureFiles",
        glue = {"steps"},
        monochrome = true,
        plugin = {"pretty",
                "html:test-Test Reports/api_cucumber_report.html",
                "json:test-Test Reports/api_cucumber_report.json"}
)
public class TestRunner {
}
