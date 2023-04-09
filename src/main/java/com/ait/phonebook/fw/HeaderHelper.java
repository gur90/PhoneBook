package com.ait.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public void findHeaderCont() {
        ApplicationManager.driver.findElement(By.cssSelector(".navbar-component_nav__1X_4m"));
    }

    public void findContact() {
        ApplicationManager.driver.findElement(By.xpath("//a[contains(.,'CONTACTS')]"));
    }

    public void findAdd() {
        ApplicationManager.driver.findElement(By.cssSelector("[href='/add']"));
    }

    public void findSignOut() {
        ApplicationManager.driver.findElement(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void findTitle() {
        ApplicationManager.driver.findElement(By.xpath("//h1[contains(.,'PHONEBOOK')]"));
    }

    public void findHome() {
        ApplicationManager.driver.findElement(By.cssSelector("[href='/home']"));
    }

    public void findAbout() {
        ApplicationManager.driver.findElement(By.cssSelector("[href='/about']"));
    }

    public void findLogin() {
        ApplicationManager.driver.findElement(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("a:nth-child(5)"));
    }
}
