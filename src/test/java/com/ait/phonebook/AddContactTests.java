package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }else{
            clickOnLoginLink();

            fillLoginRegForm("annettgur+1@rambler.ru", "722063gurina!A_");
            clickOnLoginButton();
        }
    }
    @Test
    public void addContactPositiveTests(){
        clickOnAddLink();
        addContact("Karl", "Adam", "1234567890", "adam@gm.com", "Koblenz", "torwart");

        clickOnSaveButton();
        Assert.assertTrue(isContactCreated("Karl"));
    }
    @Test
    public void addContactWithInvalidEmailNegativeTests(){
        clickOnAddLink();
        addContact("Anna","Rogozina","999999","invalidemail","Moscow","Code");
        clickOnSaveButton();
        Assert.assertTrue(isAlertPresent());
    }
    @Test
    public void addContactWithInvalidPhoneNegativeTests(){
        clickOnAddLink();
        addContact("Anna","Rogozina","aaaaaaaa","email@gmail.com","Moscow","Code");
        clickOnSaveButton();
        Assert.assertTrue(isAlertPresent());
    }
}
