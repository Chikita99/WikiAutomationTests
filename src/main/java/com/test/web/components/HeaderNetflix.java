package com.test.web.components;

import com.test.web.NetflixLoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderNetflix extends AbstractUIObject {

    @FindBy(xpath = "//select[@name = 'LanguageSelect'][%d]")
    private ExtendedWebElement languageButton;

    @FindBy(xpath = "//a[@id = 'signIn']")
    private ExtendedWebElement signInButton;

    public void selectLanguage(int index, String language) {
        languageButton.format(index).select(language);
    }

    public NetflixLoginPage clickSignInButton() {
        signInButton.click();
        return new NetflixLoginPage(driver);
    }

    public HeaderNetflix(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


}
