package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void openHomePageTest() {
        //isHomeComponentPresent();
        //isHomeComponentPresent2();
        Assert.assertTrue(isHomeComponentPresent());
    }

}
