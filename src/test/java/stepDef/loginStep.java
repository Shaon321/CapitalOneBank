package stepDef;

import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.LoginPage;

public class loginStep extends Setup {
    LoginPage login = new LoginPage(driver);

    @Given("I am at Capital One Bank Homepage")
    public void iAmAtCapitalOneBankHomepage() {
       login.homePageAssert();
    }

    @And("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        Hook hk = new Hook(); //By creatin object of HOOK class // non static variable -- email
        login.enterEmailAddress(hk.email);
    }

    @And("I enter a invalid password")
    public void iEnterAInvalidPassword() {
        login.enterPassword(Hook.password); //static variable -- password
    }

    @When("I click on Login Button")
    public void iClickOnLoginButton() throws InterruptedException {
        login.loginButton();
    }

    @Then("I should not be able to successfully log in")
    public void iShouldNotBeAbleToSuccessfullyLogIn() {
        System.out.println("I should not be able to successfully log in"); //sout
    }

    @Then("I able to get an error message")
    public void iAbleToGetAnErrorMessage() {
        login.getErrorMsg();
    }

    @Then("i clicked on OK button to return to SignIn page")
    public void iClickedOnOKButtonToReturnToSignInPage() {
        login.ClickOKBtn();
    }

    @Then("I am at SignIn page")
    public void iAmAtSignInPage() {
        login.getSignInTitle();
        login.getAcctInfo();
    }
}
