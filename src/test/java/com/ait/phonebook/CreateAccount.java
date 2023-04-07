package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccount extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveRest() {
        clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isLoginFormPresent());
        fillLoginRegForm("annettgur+1@rambler.ru", "722063gurina!A_");
        clickLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

}
