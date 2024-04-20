package com.test;

import com.test.web.HomePage;
import com.test.web.LogInPage;
import com.test.web.helpers.DataProviderClass;
import com.test.web.helpers.UserCredentials;
import com.zebrunner.carina.core.AbstractTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        LogInPage loginPage = new LogInPage(driver);

        sa.assertEquals(loginPage.getUsernameTitle(), "Username", "Username title is not located or different");
        sa.assertEquals(loginPage.getPasswordTitle(), "Password", "Password title is not located or different");
        sa.assertEquals(loginPage.getUsernameForm().getAttribute("placeholder"), "Enter your username", "Username Form placeholder is incorrect.");
        sa.assertEquals(loginPage.getPasswordForm().getAttribute("placeholder"), "Enter your password", "Password Form placeholder is incorrect.");

        loginPage.typeUsername(login);
        loginPage.typePassword(password);
        sa.assertEquals(loginPage.getLoginCheckBoxText(), "Keep me logged in (for up to one year)", "Checkbox text incorrect or missing");
        sa.assertTrue(loginPage.getLoginCheckBox().clickIfPresent(), "Checkbox is not present");

        //checking svg image in CSS for checkbox
        WebElement checkBoxIcon = loginPage.getLoginCheckBoxValue().getElement();

        String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('background-image');";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String backgroundImage = (String) jsExecutor.executeScript(script, checkBoxIcon);

        Assert.assertTrue(backgroundImage.contains("data:image/svg+xml"), "The checkbox does not have the expected SVG image when checked.");


        sa.assertAll();
    }

}
