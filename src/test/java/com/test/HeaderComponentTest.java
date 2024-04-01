package com.test;

import com.test.web.HomePage;
import com.test.web.CommonPage;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HeaderComponentTest extends AbstractTest {

    @Test
    public void verifySearchLineTest() {
        String searchName = "Car";

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        Assert.assertTrue(page.getHeader().isElementPresent(1), "Header not present");

        sa.assertTrue(page.getHeader().getSearchInput().isElementPresent(1),"Search input is not present");
        sa.assertEquals(page.getHeader().getSearchInputPlaceholder(), "Search Wikipedia", "Search input have incorrect placeholder name");

        page.getHeader().typeSearchInputValue(searchName + Keys.ENTER);

        Assert.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/" + searchName, "Url is not as expected on Search Page");

        CommonPage pageSearch = new CommonPage(driver);

        Assert.assertTrue(pageSearch.getHeader().getSearchInput().isElementPresent(1), "Search input is not present on Search Result page");

        sa.assertAll();
    }

    @Test
    public void verifySearchResultListTest() {
        String searchName = "Car";

        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        Assert.assertTrue(page.getHeader().isElementPresent(1), "Header not present");
        page.getHeader().typeSearchInputValue(searchName);
        Assert.assertTrue(page.getHeader().getSearchResultList().isElementPresent(2), "Unable to found SearchResultList");
        sa.assertTrue(page.getHeader().checkResultListElements(11), "Incorrect elements number in Result List");
        page.getHeader().getSearchResultListElement().get(1).click();
        sa.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Caribbean", "Url for opened page are not correct");

        sa.assertAll();

    }


    @Test
    public void verifyHamburgerMenuTest() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        SoftAssert sa = new SoftAssert();
        String[] urlNavigationArray = new String[7];
        urlNavigationArray[0] = "https://en.wikipedia.org/wiki/Main_Page";
        urlNavigationArray[1] = "https://en.wikipedia.org/wiki/Wikipedia:Contents";
        urlNavigationArray[2] = "https://en.wikipedia.org/wiki/Portal:Current_events";
        urlNavigationArray[3] = "https://en.wikipedia.org/wiki/Special:Random";
        urlNavigationArray[4] = "https://en.wikipedia.org/wiki/Wikipedia:About";
        urlNavigationArray[5] = "https://en.wikipedia.org/wiki/Wikipedia:Contact_us";
        urlNavigationArray[6] = "https://donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en";

        String[] urlInteractionArray = new String[5];
        urlInteractionArray[0] = "https://en.wikipedia.org/wiki/Help:Contents";
        urlInteractionArray[1] = "https://en.wikipedia.org/wiki/Help:Introduction";
        urlInteractionArray[2] = "https://en.wikipedia.org/wiki/Wikipedia:Community_portal";
        urlInteractionArray[3] = "https://en.wikipedia.org/wiki/Special:RecentChanges";
        urlInteractionArray[4] = "https://en.wikipedia.org/wiki/Wikipedia:File_upload_wizard";

        page.open();

        page.getHeader().getHamburgerMenuButton().click();
        Assert.assertTrue(page.getHeader().getHamburgerMenu().isElementPresent(2), "Main menu are not present");
        Assert.assertTrue(page.getMenuTitle("Main menu").isElementPresent(2), "Main menu title are not present or incorrect");

        sa.assertTrue(page.getHeader().getMainMenuSubtitle("Contribute").isElementPresent(2), "'Contribute' sub-title are not present or incorrect");
        //sa.assertEquals(page.getHeader().getMainMenuNavigationItem(1).getAttribute("href"), "https://en.wikipedia.org/wiki/Main_Page");
        sa.assertTrue(page.getHeader().checkMainMenuNavigationItemsUrl(urlNavigationArray), "Main menu navigation items are not present");
        sa.assertTrue(page.getHeader().checkMainMenuInteractionItemsUrl(urlInteractionArray), "Main menu interaction items are not present");

        page.getHeader().getMainMenuInteractionItem(5).click();

        sa.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Wikipedia:File_upload_wizard", "Url for opened page are not correct");


        sa.assertAll();
    }

    @Test
    public void verifySideBarMenuTest() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        SoftAssert sa = new SoftAssert();

        String[] nameNavigationArray = new String[7];
        nameNavigationArray[0] = "Main page";
        nameNavigationArray[1] = "Contents";
        nameNavigationArray[2] = "Current events";
        nameNavigationArray[3] = "Random article";
        nameNavigationArray[4] = "About Wikipedia";
        nameNavigationArray[5] = "Contact us";
        nameNavigationArray[6] = "Donate";

        String[] nameInteractionArray = new String[5];
        nameInteractionArray[0] = "Help";
        nameInteractionArray[1] = "Learn to edit";
        nameInteractionArray[2] = "Community portal";
        nameInteractionArray[3] = "Recent changes";
        nameInteractionArray[4] = "Upload file";

        page.open();

        page.getHeader().getHamburgerMenuButton().click();
        page.getHeader().getHamburgerMenuSidebarButton().click();

        Assert.assertTrue(page.getHeader().getSidebarMainMenu().isElementPresent(), "Sidebar Main Menu are not present");
        Assert.assertTrue(page.getMenuTitle("Main menu").isElementPresent(2), "Main menu title are not present or incorrect");

        sa.assertTrue(page.getHeader().getMainMenuSubtitle("Contribute").isElementPresent(2), "'Contribute' sub-title are not present or incorrect");
        sa.assertTrue(page.getHeader().checkMainMenuNavigationItemsName(nameNavigationArray), "Main menu navigation items are not present");
        sa.assertTrue(page.getHeader().checkMainMenuInteractionItemsName(nameInteractionArray), "Main menu interaction items are not present");

        page.getHeader().getMainMenuInteractionItem(5).click();
        sa.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Wikipedia:File_upload_wizard", "Url for opened page are not correct");


        sa.assertAll();
    }



    @Test
    public void accountLinksTest() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        SoftAssert sa = new SoftAssert();

        page.open();

        Assert.assertTrue(page.getHeader().getCreateAccountLink().isClickable(), "Unable to found Create Account link");
        Assert.assertTrue(page.getHeader().getLogInLink().isClickable(), "Unable to found Log in link");
        sa.assertEquals(page.getHeader().getCreateAccountLink().getAttribute("href"), "https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Main+Page", "Url link for Create Account are incorrect");
        sa.assertEquals(page.getHeader().getLogInLink().getAttribute("href"), "https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page", "Url link for Log in are incorrect");
        page.getHeader().getThreeDotsMenu().click();
        sa.assertEquals(page.getHeader().getThreeDotsMenuTitle(), "Pages for logged out editors learn more", "Title for ThreeDotsMenuTitle are incorrect");
        sa.assertEquals(page.getHeader().getThreeDotsMenuTitleUrl(), "https://en.wikipedia.org/wiki/Help:Introduction", "Title url are incorrect for ThreeDotsMenu component");
        sa.assertEquals(page.getHeader().getThreeDotsMenuTitleListItem(1).getAttribute("href"), "https://en.wikipedia.org/wiki/Special:MyContributions", "ThreeDotsMenu list item #1 have incorrect url");
        sa.assertEquals(page.getHeader().getThreeDotsMenuTitleListItem(2).getAttribute("href"), "https://en.wikipedia.org/wiki/Special:MyTalk", "ThreeDotsMenu list item #2 have incorrect url");

        sa.assertAll();
    }
}
