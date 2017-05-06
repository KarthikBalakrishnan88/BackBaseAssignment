package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = { "pretty", "html:target/cucumber" }, tags = {
		"@Regression1" })
public class RunCuke {

}
