package com.test.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NetflixLoginPage extends AbstractPage {


    @FindBy(id = "id_userLoginId")
    private ExtendedWebElement emailForm;

    @FindBy(id = "id_password")
    private ExtendedWebElement passwordForm;


    @FindBy(xpath = "//span[@class = 'login-remember-me-label-text']")
    private ExtendedWebElement checkBox;


    @FindBy(xpath = "//button[@class = 'btn login-button btn-submit btn-small']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//div[@class = 'ui-message-contents']")
    private ExtendedWebElement errorWebMessage;



    public NetflixLoginPage inputEmail (String email) {
        emailForm.type(email);
        return this;
    }

    public NetflixLoginPage inputPassword (String password) {
        passwordForm.type(password);
        return this;
    }

    public NetflixLoginPage clickCheckbox () {
        checkBox.click();
        return this;
    }

    public NetflixLoginPage clickSignInButton () {
        signInButton.click();
        return this;
    }

    public String getErrorWebMessage() {
        return errorWebMessage.getText();
    }

    public NetflixLoginPage(WebDriver driver) {
        super(driver);
    }
}
