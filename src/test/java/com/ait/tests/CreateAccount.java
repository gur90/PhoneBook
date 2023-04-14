package com.ait.tests;

import com.ait.phonebook.fw.DataProviderContact;
import com.ait.phonebook.fw.DataProviderUser;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccount extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = true)
    public void newUserRegistrationPositiveRest() {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("annettgur+1@rambler.ru")
                .setPassword("722063gurina!A_"));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }
    @Test(enabled = true, dataProvider = "registrationWithInvalidPasswordfromcSV",dataProviderClass = DataProviderUser.class)
    public void newUserRegistrationNegativeRest(User user) {
        app.getHeader().clickOnLoginLink();
        //driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        app.getUser().fillLoginRegForm(user);
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
