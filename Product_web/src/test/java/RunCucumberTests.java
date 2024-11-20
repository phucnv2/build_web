import common.BasePage;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "def",
    plugin = {"json:target/cucumber.json"},
    tags = "@Logout"
)
@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {
  @BeforeMethod
  public void open() {
    BasePage.createBrowser();
  }

  @AfterMethod
  public void close() {
    BasePage.closeBrowser();
  }
}