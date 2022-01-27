package stepDef;

import base.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends Setup {
    public static String email;
    public static String password;
    public static String url;
    public static String envData = System.getProperty("env"); //env catch from CommandPrompt (-Denv)
    public static String driverType = System.getProperty("browser"); //browser catch from CommandPrompt (-Dbrowser)

    @Before
    public void startTest() {

        //default envData  // Don't change any order
        if (Strings.isNullOrEmpty(driverType)) {
            envData = "qa";
        }
        //default driver
        if (Strings.isNullOrEmpty(driverType)) {
            driverType = "ch";
        }
        driver = setupBrowser(driverType); // calling method from base class Setup
        switch (envData) {
            case "qa":
                url = "https://www.capitalone.com/";
                email = "Abc1@gmail.com";
                password = "Abc1234";
                break;
            case "stg":
                url = "https://www.capitalone.com/";
                email = "Abc2@gmail.com";
                password = "Abc123";
                break;
            case "prd":
                url = "https://www.capitalone.com/";
                email = "Abc3@gmail.com";
                password = "Abc12";
                break;
        }

        driver.get(url);
    }


    @After
    public void endTest(Scenario scenario) {
        // happen after each test
        // what happen if test fails? what you will do for the  failing test case? screenshot? logs? ??
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // embed it in the report.
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            //driver.quit();
        }
    }
}