import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //feature, glue, plugin is a default method from @CucumberOptions
        features = "src/test/java/features/login.feature",
        //features = "src/test/java/features",
        glue = "stepDef",
        plugin = {
                "json:target/cucumber.json"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
