package StepDefinition;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
    }

//    @After
//    public void tearDown(Scenario scenario) {
//
//        try {
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            if (scenario.isFailed()) {
//                scenario.log("PFB the Screenshot for the failed scenario");
//                TakesScreenshot ts = (TakesScreenshot) driver;
//                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", screenshotName);
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//        driver.close();
//    }
}