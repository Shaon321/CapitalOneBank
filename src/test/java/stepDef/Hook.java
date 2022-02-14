package stepDef;

import base.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hook extends Setup {
    public static String email;
    public static String password;
    public static String url;
    public static String envData = System.getProperty("env"); //env catch from CommandPrompt (-Denv)
    public static String driverType = System.getProperty("browser"); //browser catch from CommandPrompt (-Dbrowser)

    public static Properties prop = new Properties();

    @Before
    public void startTest() throws IOException {
        InputStream inputFile = new FileInputStream("src/main/java/config.properties");
        prop.load(inputFile);

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
                //url = "https://www.capitalone.com/";
               // email = "Abc1@gmail.com";
                //password = "Abc1234";
                url = prop.getProperty("urlQa");
                email = prop.getProperty("emailQa");
                password = prop.getProperty("passwordQa");
                break;
            case "stg":
                //url = "https://www.capitalone.com/";
                //email = "Abc2@gmail.com";
                //password = "Abc123";
                url = prop.getProperty("urlStg");
                email = prop.getProperty("emailStg");
                password = prop.getProperty("passwordStg");
                break;
            case "prd":
               // url = "https://www.capitalone.com/";
                //email = "Abc3@gmail.com";
                //password = "Abc12";
                url = prop.getProperty("urlProd");
                email = prop.getProperty("emailProd");
                password = prop.getProperty("passwordProd");
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