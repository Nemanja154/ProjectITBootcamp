package Tests;

import BaseClass.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNavigation extends Driver {

    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInPage.logIn();
    }

    /**Test log out button
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click Menu Button
     * 5.Click log out button
     * 6.Assert log in button is displayed
     */

    @Test
    public void logOut(){
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        navigationPage.clickMenuButton();
        navigationPage.clickLogoutButton();
        Assert.assertTrue(logInPage.getLoginButton().isDisplayed(),"User is not Log out");
    }

    /**
     /**Test log out button
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click Sauce Labs Beckpack
     * 5.Click Menu button
     * 6.Click All items button
     * 7.Assert user see products
     */


    @Test
    public void allItems(){
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageProduct.clickPictureSauceLabsBackpack();
        navigationPage.clickMenuButton();
        navigationPage.clickAllItemsButton();
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
    }

    /**
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click Menu Button
     * 5.Click About button
     * 6.Assert user is on page with url = "https://saucelabs.com/"
     */

    @Test
    public void about(){
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        navigationPage.clickMenuButton();
        navigationPage.clickAboutButton();
        String actualyUrl = driver.getCurrentUrl();
        String expectedUrl = "https://saucelabs.com/";
        Assert.assertEquals(actualyUrl,expectedUrl,"User is not on a good page");
    }


}
