package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTestsIfUserLogin extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        loginRegisteredUserPositiveTest();
    }

    public void loginRegisteredUserPositiveTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("annettgur+1@rambler.ru")
                .setPassword("722063gurina!A_"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test(enabled = true)
    public void findContactsElement() {
        app.getHeader().findContact();
    }

    @Test(enabled = true)
    public void findAddElement() {
        app.getHeader().findAdd();
    }

    @Test(enabled = true)
    public void findButtonSignOut() {
        app.getHeader().findSignOut();
    }

    public void loginNegative() {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("annettgur+1@rambler.ru")
                .setPassword("722063gurina!A"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    public void loginPositiv() {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("annettgur+1@rambler.ru")
                .setPassword("722063gurina!A_"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
        logger.info("User logged in. Actual result: "+ app.getHeader().isSignOutButtonPresent());
    }
}
