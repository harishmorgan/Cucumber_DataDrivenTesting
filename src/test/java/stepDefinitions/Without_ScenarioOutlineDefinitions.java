package stepDefinitions;

import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Without_ScenarioOutlineDefinitions {
 
    WebDriver driver;
 
    @Given("User is on Home page")
    public void userOnHome_Page() {
 
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @When("User enters username as {string} and password as {string}")
    public void entersCredentials(String userName, String passWord) throws InterruptedException {
 
        System.out.println("Username Entered");
        driver.findElement(By.name("username")).sendKeys(userName);
 
        System.out.println("Password Entered");
        driver.findElement(By.name("password")).sendKeys(passWord);
 
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
 
    }
    
    @Then("User should be able to see an {string}")
    public void verifyErrorMessages(String expectedErrorMessage) throws InterruptedException {
 
        String actualErrorMessage = driver.findElement(By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
        System.out.println("Error Message :" + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }
 
    @Then("User should be able to see as {string}")
    public void verifyErrorMessage(String expectedErrorMessage) throws InterruptedException {
 
        String actualErrorMessage = driver.findElement(By.cssSelector("span.oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")).getText();
        System.out.println("Error Message :" + actualErrorMessage);
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
 
        //close the browser
        driver.quit();
 
    }
}