package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assessment_StepDefinition {

    WebDriver driver;
    JavascriptExecutor executor;

    @Given("^User is on the Playtech page$")
    public void user_is_on_the_Playtech_page() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://playtech.com");
    }

    @When("^User enters the invalid age$")
    public void user_enters_the_invalid_age() throws Throwable {
        Select day = new Select(driver.findElement(By.xpath("//select[@name='day']")));
        day.selectByVisibleText("01");
        Select month = new Select(driver.findElement(By.xpath("//select[@name='month']")));
        month.selectByVisibleText("01");
        Select year = new Select(driver.findElement(By.xpath("//select[@name='year']")));
        year.selectByVisibleText("2021");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }

    @Then("^User is displayed with an error message$")
    public void user_is_displayed_with_an_error_message(){
        String error = driver.findElement(By.xpath("//span[@class='age-error']")).getText();
        Assert.assertEquals(error, "Sorry you must be over 18 to enter.");
    }

    @When("^User enters the valid age$")
    public void user_enters_the_valid_age() throws Throwable {
        Select day = new Select(driver.findElement(By.xpath("//select[@name='day']")));
        day.selectByVisibleText("02");
        Select month = new Select(driver.findElement(By.xpath("//select[@name='month']")));
        month.selectByVisibleText("11");
        Select year = new Select(driver.findElement(By.xpath("//select[@name='year']")));
        year.selectByVisibleText("1990");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }

    @Then("^User is navigated to About Us page$")
    public void user_is_navigated_to_the_Homepage() throws Throwable {
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("^User verifies that Number of Employees is \"([^\"]*)\"$")
    public void user_verifies_that_Number_of_Employees_is(String employees) throws InterruptedException {
        Thread.sleep(3000);
        executor.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(5000);
        String employeeUI = driver.findElement(By.xpath("(//div[contains(@class,'stat-count')])[1]")).getAttribute("data-odometer-count");
        System.out.println("Number of Employees: "+employeeUI);
        Assert.assertEquals(employees,employeeUI);
    }

    @Then("^User verifies that Number of countries Playtech has offices in is \"([^\"]*)\"$")
    public void user_verifies_that_Number_of_countries_Playtech_has_offices_in_is(String offices){
        String officesUI = driver.findElement(By.xpath("(//div[contains(@class,'stat-count')])[2]")).getAttribute("data-odometer-count");
        System.out.println("Number of countries Playtech has offices: "+officesUI);
        Assert.assertEquals(offices,officesUI);
    }

    @Then("^User verifies that count of Global licensees is \"([^\"]*)\"$")
    public void user_verifies_that_count_of_Global_licensees_is(String licenses) {
        String licensesUI = driver.findElement(By.xpath("(//div[contains(@class,'stat-count')])[3]")).getAttribute("data-odometer-count");
        System.out.println("Global licensees: "+licensesUI);
        Assert.assertEquals(licenses,licensesUI);
    }

    @Then("^User verifies that Regulated Jurisdictions are \"([^\"]*)\"$")
    public void user_verifies_that_Regulated_Jurisdictions_are(String jurisdictions) {
        String jurisdictionsUI = driver.findElement(By.xpath("(//div[contains(@class,'stat-count')])[4]")).getAttribute("data-odometer-count");
        System.out.println("Regulated Jurisdictions: "+jurisdictionsUI);
        Assert.assertEquals(jurisdictions,jurisdictionsUI);
    }

    @Then("^Close the browser$")
    public void closeTheBrowser() {
        driver.quit();
    }
}
