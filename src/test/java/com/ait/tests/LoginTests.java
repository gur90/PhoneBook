package com.ait.tests;

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
        loginPositiv();
    }

    @Test
    public void loginRegisteredUserWithInvalidNegativetiveTest() {
        loginNegative();
    }

}
