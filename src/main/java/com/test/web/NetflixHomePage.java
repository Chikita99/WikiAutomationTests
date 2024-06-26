package com.test.web;

import com.test.web.components.Header;
import com.test.web.components.HeaderNetflix;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NetflixHomePage extends AbstractPage {

    @FindBy(xpath = "//header")
    private HeaderNetflix header;
    public NetflixHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("home_url"));
    }

    public HeaderNetflix getHeader() {
        return header;
    }
}
