package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void openHomePageTest() {
        //isHomeComponentPresent();
        //isHomeComponentPresent2();
        Assert.assertTrue(isElementPresent2(By.cssSelector("div:nth-child(2)>div>div")));
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div")).size() > 0;
    }

    public boolean isHomeComponentPresent2() {
        try {
            driver.findElement(By.cssSelector("div:nth-child(2)>div>div"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
