package TestRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:assessment.feature"
        ,glue="classpath:StepDefinition"

)

public class assessment_TestRunner {

}