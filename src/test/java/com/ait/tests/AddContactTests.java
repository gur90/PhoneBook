package com.ait.tests;

import com.ait.phonebook.fw.DataProviderContact;
import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {



    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User()
                    .setEmail("annettgur+1@rambler.ru")
                    .setPassword("722063gurina!A_"));
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void addContactPositiveTests() {
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

    @Test(enabled = false,dataProvider = "addNewContact",dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromDataProviderTests(String name, String sureName, String phone, String email, String address, String desc) {
        app.getHeader().pause(100);
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(new Contact()
                .setName(name)
                .setLastName(sureName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }
    @Test(enabled = true,dataProvider = "addNewContactFromCsv",dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromCSVTests(Contact contact) {
        app.getHeader().pause(100);
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(contact);

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }

    @Test
    public void addContactWithInvalidEmailNegativeTests() {
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
    public void addContactWithInvalidPhoneNegativeTests() {
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
