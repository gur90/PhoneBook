package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isLoginFormPresent());
        fillLoginRegForm("annettgur+1@rambler.ru", "722063gurina!A_");
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserWithInvalidNegativetiveTest() {
        clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(isLoginFormPresent());
        fillLoginRegForm("annettgur+1@rambler.ru", "722063gurina!A");
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());

    }

}
