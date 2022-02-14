package pageObject;

import base.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends LoginCredental2 implements LoginCredential{

    WebDriver driver;

    //Constructor
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        //Setup.driver = driver; //for extends
        this.driver=driver;
    }

    //Locators
    @FindBy(how = How.XPATH, using = "//*[@id=\"ods-input-0\"]")
    public WebElement emailLocator;

    @FindBy(how= How.XPATH, using = "//*[@id=\"ods-input-1\"]")
    public WebElement passwordLocator;

    @FindBy(how= How.XPATH, using = "//*[@id=\"noAcctSubmit\"]")
    public WebElement loginButton;

    @FindBy(how= How.XPATH, using = "/html/body/app-root/div/div/app-system-error/ci-message-page/div/h1")
    public WebElement errorMsg;

    @FindBy(how= How.XPATH, using = "//a[@class=\"ods-button ods-button--progressive\"]")
    public WebElement OKButton;

    // Functions

    @Override //From Abstract class
    public void homePageAssert(){

    }
    public void enterEmailAddress(String email){
        emailLocator.sendKeys(email);
    }
    public void enterPassword(String pass){
        passwordLocator.sendKeys(pass);
    }
//    public void loginButton(){
//        loginButton.click();
//    }
    @Override //From Interface class
    public void loginButton() {
    loginButton.click();
    }

//    public void getErrorMsg(){
//    System.out.println(errorMsg.getText());
//    }

    @Override //From Interface class
    public void getErrorMsg() {
        System.out.println(errorMsg.getText());
    }

    @Override //From Abstract class
    public void ClickOKBtn(){
        OKButton.click();
        System.out.println("OK Button clicked");
    }

    public void getSignInTitle(){
        //signInTitle.getText();
        System.out.println(driver.getTitle());
    }


}
