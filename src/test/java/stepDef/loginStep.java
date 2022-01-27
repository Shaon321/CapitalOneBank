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
        String exp = "Capital One Credit Cards, Bank, and Loans - Personal and Business";
        String act = driver.getTitle();
        System.out.println(act);
        Assert.assertEquals(act, exp);
        System.out.println("You are in the right page");
    }

    @And("I enter a valid email address")
    public void iEnterAValidEmailAddress() {
        login.enterEmailAddress(Hook.email);
    }

    @And("I enter a invalid password")
    public void iEnterAInvalidPassword() {
        login.enterPassword(Hook.password);
    }

    @When("I click on Login Button")
    public void iClickOnLoginButton() {
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
    }
}
