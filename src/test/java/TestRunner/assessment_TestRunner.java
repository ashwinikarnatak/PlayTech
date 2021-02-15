package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:assessment.feature"
        ,glue= "classpath:StepDefinition"
        ,plugin= { "pretty","html:test-output", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,strict = true
)

public class assessment_TestRunner {

}