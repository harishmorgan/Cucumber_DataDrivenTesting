package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
 
public class DataTableDefinitions {
 
    WebDriver driver;
 
    @Before
    public void setup() {
 
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
 
    @Given("User is on HRMLogin page")
    public void userOnHomePage() {
 
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @When("User enters valid credentials")
    public void entersValidCredential(DataTable dataTable) throws InterruptedException{
 
        System.out.println("Credentials Entered");
        List<String> signUpForm = dataTable.asList();
        String userName = signUpForm.get(0);
        String passWord = signUpForm.get(1);
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }
 
    @Then("User should be able to login successfully and new page open")
    public void successfulLogin() throws InterruptedException {
 
        String newPageText = driver.findElement(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module")).getText();
        System.out.println("newPageText :" + newPageText);
        assertThat(newPageText, containsString("Dashboard"));
    }
 
    @After
    public void teardown(){
        driver.close();
    }
}