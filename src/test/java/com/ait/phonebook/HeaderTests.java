package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{
    @Test
    public void findHeaderContainer(){
        driver.findElement(By.cssSelector(".navbar-component_nav__1X_4m"));

    }
    @Test
    public void findTitlePhoneBook(){
        driver.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }
    @Test
    public void findHomeElement(){
        driver.findElement(By.cssSelector("[href='/home']"));
    }
    @Test
    public void findAboutElement(){
        driver.findElement(By.cssSelector("[href='/about']"));
    }
   @Test
    public void findLoginElement(){
        driver.findElement(By.cssSelector("[href='/login']"));
    }
}
