package com.test.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

import java.util.List;

public class Header extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(Header.class);

    //Search elements
    @FindBy(xpath = "//ul[@class = 'cdx-menu__listbox']")
    private ExtendedWebElement searchResultList;

    @FindBy(xpath = "//li[contains(@class, 'cdx-menu-item')]")
    private List<ExtendedWebElement> searchResultListElements;

    @FindBy(xpath = "//input[@class = 'cdx-text-input__input']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[text()='Search']")
    private ExtendedWebElement searchButton;

    //Main Menu
    @FindBy(xpath = "//div[@id='vector-main-menu-dropdown']")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//div[@id='vector-main-menu-unpinned-container']")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//div[@class='vector-menu-heading'][normalize-space(text())='%s']")
    private ExtendedWebElement mainMenuSubtitle;

    @FindBy(xpath = "//div[@id='p-navigation']//li[@class='mw-list-item'][%d]//a")
    private ExtendedWebElement mainMenuNavigationItem;

    @FindBy(xpath = "//div[@id='p-interaction']//li[@class='mw-list-item'][%d]//a")
    private ExtendedWebElement mainMenuInteractionItem;

    @FindBy(xpath = "//div[@id='vector-main-menu-unpinned-container']//button[contains(@class, normalize-space('vector-pinnable-header-pin-button'))]")
    private ExtendedWebElement hamburgerMenuSidebarButton;

    @FindBy(xpath = "//div[@id='p-navigation']//li[@class='mw-list-item'][%d]//a/span")
    private ExtendedWebElement mainMenuNavigationItemName;

    @FindBy(xpath = "//div[@id='p-interaction']//li[@class='mw-list-item'][%d]//a/span")
    private ExtendedWebElement mainMenuInteractionItemName;

    //Sidebar Menu
    @FindBy(xpath = "//div[@id='vector-main-menu-pinned-container']")
    private ExtendedWebElement sidebarMainMenu;

    //Create and Log in
    @FindBy(xpath = "//li[@id='pt-createaccount-2']/a")
    private ExtendedWebElement createAccountLink;

    @FindBy(xpath = "//li[@id='pt-login-2']/a")
    private ExtendedWebElement logInLink;


    public Header(WebDriver driver) {
        super(driver);
    };

    //Methods
    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }

    public boolean checkResultListElements(int expectedNumberOfElements) {

        if (searchResultListElements.isEmpty()) {
            return false;
        }

        if (searchResultListElements.size() < expectedNumberOfElements) {
            return false;
        }

        return true;
    }

    public ExtendedWebElement getMainMenuSubtitle(String title) {
        return mainMenuSubtitle.format(title);
    }

    public boolean checkMainMenuNavigationItemsUrl(String[] urlArray) {
        String expectedUrl;
        String actualUrl;
        for (int i = 0; i < urlArray.length; i++) {
            expectedUrl = urlArray[i];
            actualUrl = mainMenuNavigationItem.format(i + 1).getAttribute("href");
            if (!expectedUrl.equals(actualUrl)) {
                throw new AssertionError("URL mismatch at index " + i + ": Expected - " + expectedUrl + ", Actual - " + actualUrl);
            }
        }
        return true;
    }

    public boolean checkMainMenuInteractionItemsUrl(String[] urlArray){
        String expectedUrl;
        String actualUrl;
        for (int i = 0; i < urlArray.length; i++) {
            expectedUrl = urlArray[i];
            actualUrl = mainMenuInteractionItem.format(i + 1).getAttribute("href");
            if (!expectedUrl.equals(actualUrl)) {
                throw new AssertionError("URL mismatch at index " + i + ": Expected - " + expectedUrl + ", Actual - " + actualUrl);
            }
        }
        return true;
    }

    public boolean checkMainMenuNavigationItemsName(String[] nameArray) {
        String expectedName;
        String actualName;
        for (int i = 0; i < nameArray.length; i++) {
            expectedName = nameArray[i];
            actualName = mainMenuNavigationItemName.format(i + 1).getText();
            if (!expectedName.equals(actualName)) {
                throw new AssertionError("Name mismatch at index " + i + ": Expected - " + expectedName + ", Actual - " + actualName);
            }
        }
        return true;
    }

    public boolean checkMainMenuInteractionItemsName(String[] nameArray) {
        String expectedName;
        String actualName;
        for (int i = 0; i < nameArray.length; i++) {
            expectedName = nameArray[i];
            actualName = mainMenuInteractionItemName.format(i + 1).getText();
            if (!expectedName.equals(actualName)) {
                throw new AssertionError("Name mismatch at index " + i + ": Expected - " + expectedName + ", Actual - " + actualName);
            }
        }
        return true;
    }



    //Getters and Setters
    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    };
    public ExtendedWebElement getSearchResultList() {
        return searchResultList;
    };

    public List<ExtendedWebElement> getSearchResultListElement() {
        return searchResultListElements;
    }
    public ExtendedWebElement getSearchInput() {
        return searchInput;
    };
    public ExtendedWebElement getSearchButton() {
        return searchButton;
    };

    public ExtendedWebElement getHamburgerMenuButton() {
        return hamburgerMenuButton;
    }
    public ExtendedWebElement getHamburgerMenu() {
        return hamburgerMenu;
    }

    public ExtendedWebElement getMainMenuNavigationItem(int index) {
        return mainMenuNavigationItem.format(index);
    }

    public ExtendedWebElement getMainMenuInteractionItem(int index) {
        return mainMenuInteractionItem.format(index);
    }

    public ExtendedWebElement getHamburgerMenuSidebarButton() {
        return hamburgerMenuSidebarButton;
    }

    public ExtendedWebElement getSidebarMainMenu() {
        return sidebarMainMenu;
    }

    public ExtendedWebElement getCreateAccountLink() {
        return createAccountLink;
    }

    public ExtendedWebElement getLogInLink() {
        return logInLink;
    }
}
