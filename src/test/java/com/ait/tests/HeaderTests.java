package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{
    @Test
    public void findHeaderContainer(){
        app.getHeader().findHeaderCont();
    }

    @Test
    public void findTitlePhoneBook(){
        app.getHeader().findTitle();
    }

    @Test
    public void findHomeElement(){
        app.getHeader().findHome();
    }

    @Test
    public void findAboutElement(){
        app.getHeader().findAbout();
    }

    @Test
    public void findLoginElement(){
        app.getHeader().findLogin();
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
