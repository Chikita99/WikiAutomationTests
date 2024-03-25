package com.test;


import com.test.web.NetflixLoginPage;
import com.test.web.NetflixHomePage;
import com.test.web.components.HeaderNetflix;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NetflixLogInTest extends AbstractTest {
    final private static String ERROR_MESSAGE = "Sorry, the password for this account needs to be reset. Please reset your password to access your account.";

    @Test
    public void verifyLogIn() {

        WebDriver driver = getDriver();

        NetflixHomePage pageNetflix = new NetflixHomePage(driver);

        pageNetflix.open();

        HeaderNetflix headerNetflix = pageNetflix.getHeader();
        headerNetflix.selectLanguage(1,"Español");

        NetflixLoginPage netflixLoginPage = headerNetflix.clickSignInButton();

        netflixLoginPage.inputEmail("abc@gmail.com").inputPassword("Password*_1");

        netflixLoginPage.clickCheckbox().clickSignInButton();

        Assert.assertEquals(netflixLoginPage.getErrorWebMessage(),ERROR_MESSAGE, "Error message not equal.");

    }

}
