package com.test;

import com.test.web.HomePage;
import com.test.web.helpers.DataProviderClass;
import com.test.web.helpers.UserCredentials;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LogInTest extends AbstractTest {

    @DataProvider(name = "userDataProvider")
    public Object[][] createUserData() {
        List<UserCredentials.User> users = DataProviderClass.getUsers();
        Object[][] data = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i).login;
            data[i][1] = users.get(i).password;
        }
        return data;
    }

    @Test(dataProvider = "userDataProvider")
    public void LogInTest(String login, String password) {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        Assert.assertTrue(page.getHeader().getLogInLink().clickIfPresent(), "Unable to found Log in link");


    }

}
