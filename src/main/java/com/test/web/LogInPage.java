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

    //Getters and Setters

    public String getUsernameTitle() {
        return usernameTitle.getText();
    }

}
