package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }
    @Test
    public void loginRegisteredUserPositiveTest() {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("annettgur+1@rambler.ru")
                .setPassword("722063gurina!A_"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserWithInvalidNegativetiveTest() {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("annettgur+1@rambler.ru")
                .setPassword("722063gurina!A"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
