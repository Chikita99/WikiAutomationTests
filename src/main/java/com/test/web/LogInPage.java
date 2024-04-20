package com.test.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage  {
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for = 'wpName1']/span[@class='cdx-label__label__text']")
    private ExtendedWebElement usernameTitle;

    @FindBy(xpath = "//label[@for = 'wpPassword1']/span[@class='cdx-label__label__text']")
    private ExtendedWebElement passwordTitle;

    @FindBy(xpath = "//div[@class = 'cdx-text-input']/input[@id = 'wpName1']")
    private ExtendedWebElement usernameForm;

    @FindBy(xpath = "//div[@class = 'cdx-text-input']/input[@id = 'wpPassword1']")
    private ExtendedWebElement passwordForm;

    @FindBy(xpath = "//label[@class = 'cdx-checkbox__label']")
    private ExtendedWebElement loginCheckBoxText;

    @FindBy(xpath = "//span[@class = 'cdx-checkbox__icon']")
    private ExtendedWebElement loginCheckBoxValue;

    //Getters and Setters

    public String getUsernameTitle() {
        return usernameTitle.getText();
    }

    public String getPasswordTitle() {
        return passwordTitle.getText();
    }

    public ExtendedWebElement getUsernameForm() {
        return usernameForm;
    }

    public ExtendedWebElement getPasswordForm() {
        return passwordForm;
    }

    //Methods

    public void typeUsername(String value) {
        usernameForm.type(value);
    }

    public void typePassword(String value) {
        passwordForm.type(value);
    }


    public String getLoginCheckBoxText() {
        return loginCheckBoxText.getText();
    }

    public ExtendedWebElement getLoginCheckBox() {
        return loginCheckBoxText;
    }

    public ExtendedWebElement getLoginCheckBoxValue() {
        return loginCheckBoxValue;
    }
}
