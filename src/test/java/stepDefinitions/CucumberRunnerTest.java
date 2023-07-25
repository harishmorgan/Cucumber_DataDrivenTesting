package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = "pretty", features = "src/test/resources/Features/DataTablewithHeaderandSingleRow.feature",
        glue = "stepDefinitions",tags="@InValidCredential")
 
public class CucumberRunnerTest {
}
