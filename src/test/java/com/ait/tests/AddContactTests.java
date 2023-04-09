package com.ait.tests;

import com.ait.phonebook.fw.BaseHelper;
import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }else{
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User()
                    .setEmail("annettgur+1@rambler.ru")
                    .setPassword("722063gurina!A_"));
            app.getUser().clickOnLoginButton();
        }
    }
    @Test
    public void addContactPositiveTests(){
        app.getHeader().pause(100);
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(new Contact()
                .setName("Karl")
                .setLastName("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.com")
                .setAddress("Koblenz")
                .setDescription("torwart"));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }
    @Test
    public void addContactWithInvalidEmailNegativeTests(){
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(new Contact().setName("Anna")
                .setLastName("Rogozina")
                .setPhone("999999")
                .setEmail("invalidemail").setAddress("Moscow")
                .setDescription("Code"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isAlertPresent());
    }
    @Test
    public void addContactWithInvalidPhoneNegativeTests(){
        app.getHeader().pause(100);
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(new Contact().setName("Anna")
                .setLastName("Rogozina")
                .setPhone("aaaaaaaa")
                .setEmail("email@gmail.com")
                .setAddress("Moscow")
                .setDescription("Code"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isAlertPresent());
    }
}
