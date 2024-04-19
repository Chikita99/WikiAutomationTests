package com.test;

import com.test.web.HomePage;
import com.test.web.LogInPage;
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
        // Убедись, что список пользователей не пуст, чтобы избежать ошибок
        if (users.isEmpty()) {
            throw new IllegalStateException("No users found in the data source");
        }
        // Создаем массив данных только для первого пользователя
        Object[][] data = new Object[1][2]; // Изменено с users.size() на 1
        data[0][0] = users.get(0).login; // Взять логин первого пользователя
        data[0][1] = users.get(0).password; // Взять пароль первого пользователя
        return data;
    }


    @Test(dataProvider = "userDataProvider")
    public void UserLogInTest(String login, String password) {
        SoftAssert sa = new SoftAssert();
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        String usernameTitle = "Username";

        page.open();

        Assert.assertTrue(page.getHeader().getLogInLink().clickIfPresent(), "Unable to found Log in link");

        LogInPage loginpage = new LogInPage(driver);

        sa.assertEquals(loginpage.getUsernameTitle(), "Username", "Username title is not located or different");
        sa.assertEquals(loginpage.getPasswordTitle(), "Password", "Password title is not located or different");


        sa.assertAll();
    }

}
