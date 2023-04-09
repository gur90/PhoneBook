package com.ait.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void openHomePageTest() {
        //isHomeComponentPresent();
        //isHomeComponentPresent2();
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }

}
