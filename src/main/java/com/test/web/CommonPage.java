package com.test.web;

import com.test.web.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonPage extends AbstractPage {

    @FindBy(xpath = "//header[@class = 'vector-header mw-header']")
    private Header header;



    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    //Methods

}
