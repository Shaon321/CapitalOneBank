package pageObject;

import base.Setup;
import org.testng.Assert;

abstract class LoginCredental2 extends Setup {

    public void homePageAssert(){
        String exp = "Capital One Credit Cards, Bank, and Loans - Personal and Business";
        String act = driver.getTitle();
        System.out.println(act);
        Assert.assertEquals(act, exp);
        System.out.println("You are in the right page");
    }

    public abstract void ClickOKBtn();
}
