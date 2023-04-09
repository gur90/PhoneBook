package com.ait.tests;

import org.testng.annotations.Test;

public class HeaderTests extends TestBase{
    @Test
    public void findHeaderContainer(){
        app.getHeader().findHeaderCont();
    }

    @Test
    public void findTitlePhoneBook(){
        app.getHeader().findTitle();
    }

    @Test
    public void findHomeElement(){
        app.getHeader().findHome();
    }

    @Test
    public void findAboutElement(){
        app.getHeader().findAbout();
    }

    @Test
    public void findLoginElement(){
        app.getHeader().findLogin();
    }

}
