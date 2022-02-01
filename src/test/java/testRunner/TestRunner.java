package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/ashishmadhav/Documents/MyGitProjects/Basic_Selenium/Basic_Selenium-Framework/Features/GoogleSearch.feature", glue = "stepDefinition")
public class TestRunner {
}
