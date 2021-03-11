package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.time.Duration;

public class assessment_StepDefinition {

    WebDriver driver;

    @Given("^User logs in via \"([^\"]*)\" using valid credentials$")
    public void user_logs_in_via_using_valid_credentials(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class=\"login\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("ashwini.karnatak@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"passwd\"]")).sendKeys("prism@666");
        driver.findElement(By.xpath("//button[@id=\"SubmitLogin\"]")).click();
    }

    @When("^User orders a T-Shirt$")
    public void user_orders_a_shirt() {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//li[contains(@class,\"last-mobile-line\")]")).click();
        driver.findElement(By.xpath("//a[contains(@title,\"Add\")]")).click();
        driver.findElement(By.xpath("//a[contains(@title,\"Proceed\")]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        driver.findElement(By.xpath("//button[@name=\"processAddress\"]")).click();
        driver.findElement(By.xpath("//input[contains(@name,\"cgv\")]")).click();
        driver.findElement(By.xpath("//button[@name=\"processCarrier\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"bankwire\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"button btn btn-default button-medium\"]")).click();
    }

    @Then("^User verifies the order in Order History$")
    public void user_verify_in_order_history() {
        String wholeText = driver.findElement(By.xpath("//div[@class=\"box\"]")).getText();
        //System.out.println(wholeText);
        String[] orderReference = wholeText.split(" ");
        System.out.println(orderReference[36]);
        driver.findElement(By.xpath("//a[@title=\"Back to orders\"]")).click();
        String orderHistory = driver.findElement(By.xpath("//a[@class=\"color-myaccount\"]")).getText();
        System.out.println(orderHistory);
        Assert.assertEquals(orderReference[36], orderHistory);
    }

    @Then("^User updates First Name in My Account$")
    public void user_updates_first_name_in_my_account() {
        driver.findElement(By.xpath("//a[@title=\"View my customer account\"]")).click();
        driver.findElement(By.xpath("//a[@title=\"Information\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"firstname\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Abhishek");
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("prism@666");
        driver.findElement(By.xpath("//button[@name=\"submitIdentity\"]")).click();
        String successMessage = driver.findElement(By.xpath("//p[@class=\"alert alert-success\"]")).getText();
        Assert.assertEquals(successMessage, "Your personal information has been successfully updated.");
    }

    @Then("^Close the browser$")
    public void closeTheBrowser() {
        driver.quit();
    }
}