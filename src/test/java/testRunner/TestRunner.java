package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./Features/GoogleSearch.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "html:Reports"})
public class TestRunner {
}
