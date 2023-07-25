package stepDefinitions;

import java.time.Duration;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.Map;

public class DataTableDefinitionsWithHeaderAndSingleRow {

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

	@Given("User launched an HRMLogin page")
	public void userLaunchedAnHRMLoginPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("User enters invalid credentials and Login will be unsuccessful with error message")
	public void user_enters_invalid_credentials_and_login_will_be_unsuccessful_with_error_message(DataTable userTable) throws InterruptedException {
		System.out.println("Enter Credentials");
		List<Map<String, String>> user = userTable.asMaps(String.class, String.class);
		for (Map<String, String> form : user) {

			String userName = form.get("Username");
			System.out.println("Username :" + userName);
			driver.findElement(By.name("username")).sendKeys(userName);

			String passWord = form.get("Password");
			System.out.println("Password :" + passWord);
			driver.findElement(By.name("password")).sendKeys(passWord);

			driver.findElement(By.xpath("//button[@type='submit']")).submit();

			String errorMessage = form.get("ErrorMessage");
			String actualErrorMessage = driver
					.findElement(By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
			System.out.println("Actual Error Message :" + actualErrorMessage);

			Assert.assertTrue(actualErrorMessage.equalsIgnoreCase(errorMessage));
		}
	}

	@After
    public void teardown(){
        driver.close();
    }
}
