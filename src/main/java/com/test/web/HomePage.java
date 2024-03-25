package com.test.web;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.test.web.components.Header;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header[@class = 'vector-header mw-header']")
    private Header header;

    @FindBy(xpath = "//div[@class='vector-pinnable-header-label'][normalize-space(text())='%s']")
    private ExtendedWebElement menuTitle;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public Header getHeader() {
        return header;
    }


    //Methods
    public ExtendedWebElement getMenuTitle(String title) {
        return menuTitle.format(title);
    }




}
