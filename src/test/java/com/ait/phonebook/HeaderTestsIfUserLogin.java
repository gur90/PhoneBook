package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTestsIfUserLogin extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        //если пользователь залогинен
    }
    @Test
    public void findContactsElement(){
        driver.findElement(By.xpath("//a[contains(.,'CONTACTS')]"));
    }
    @Test
    public void findAddElement(){
        driver.findElement(By.cssSelector("[href='/add']"));
    }
    @Test
    public void findButtonSignOut(){
        driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
    }

}
