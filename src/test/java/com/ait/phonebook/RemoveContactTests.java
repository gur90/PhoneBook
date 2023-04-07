package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }else{
            clickOnLoginLink();

            fillLoginRegForm("annettgur+1@rambler.ru", "722063gurina!A_");
            clickOnLoginButton();

            clickOnAddLink();
            addContact("Karl", "Adam", "1234567890", "adam@gm.com", "Koblenz", "torwart");

            clickOnSaveButton();
        }
    }
    @Test
    public void removeContactTest(){
int sizeBefore=sizeOfContacts();

        removeContact();
        pause(1000);
        int sizeAfter=sizeOfContacts();
        Assert.assertEquals(sizeBefore-sizeAfter,1);
    }

}
