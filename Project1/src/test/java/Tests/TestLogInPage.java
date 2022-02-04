package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import BaseClass.Driver;


public class TestLogInPage extends Driver {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    /**Test login HappyPath
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.Insert username(standard_user)
     * 3.Insert password(secret_sauce)
     * 4.Click LogIn button
     * Assert user see products
     */
    @Test
    public void logInHappyPath() throws InterruptedException {
        logInPage.getUsernameInput("standard_user");
        logInPage.getPasswordInput("secret_sauce");
        logInPage.clickLoginButton();

        wait.until(ExpectedConditions.visibilityOf(homePageHeader.getTitle()));
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not LoginHappyPath");
    }

    /**Test login UnHappyPath,wrong username
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.Insert username(wrong_user)
     * 3.Insert password(secret_sauce)
     * 4.Click LogIn button
     * Assert user see message "Username and password do not match"
     */

    @Test
    public void logInUnhappyPathWrongUsername() {

        logInPage.getUsernameInput("wrong_username");
        logInPage.getPasswordInput("secret_sauce");
        logInPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(logInPage.getErrorMessage()));
        Assert.assertTrue(logInPage.getErrorMessage().getText().contains("Username and password do not match"), "Log in is successful");

    }

    /**Test login UnHappyPath,wrong password
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.Insert username(wrong_user)
     * 3.Insert password(secret_sauce)
     * 4.Click LogIn button
     * Assert user see message "Username and password do not match"
     */

    @Test
    public void logInUnhappyPathWrongPassword() {
        logInPage.getUsernameInput("standard_user");
        logInPage.getPasswordInput("wrong_password");
        logInPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(logInPage.getErrorMessage()));
        Assert.assertTrue(logInPage.getErrorMessage().getText().contains("Username and password do not match"), "Log in is successful");
    }

    /**Test LogIn button color
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.Assert is button color equal #e2231a
     */

    @Test
    public void logInButtonColor() {
        Assert.assertEquals(logInPage.buttonColor(), "#e2231a", "Color is not corect");
    }


}
