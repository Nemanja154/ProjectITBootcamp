package Tests;

import BaseClass.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class TestSocialButton extends Driver {

    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInPage.logIn();
    }

    /**Test Twitter button
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click on Twitter button
     * 5.Switch to open new tab
     * 6.Assert user is on a good page with url = "https://twitter.com/saucelabs"
     *
     */

    @Test(priority = 10)
    public void twitterButton() throws InterruptedException {
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageFooter.clickTwitterButton();

        ArrayList<String>  tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        String expectedUrl = "https://twitter.com/saucelabs";
        Assert.assertEquals(homePageFooter.getUrl(),expectedUrl,"User is not on a good page");
        driver.close();
        driver.switchTo().window(tabs2.get(0));

    }

    /**Test Twitter button
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click on Facebook button
     * 5.Switch to open new tab
     * 6.Assert user is on a good page with url = "https://www.facebook.com/saucelabs"
     *
     */

    @Test(priority = 20)
    public void facebookButton(){
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageFooter.clickFacebookButton();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));


        String expectedUrl = "https://www.facebook.com/saucelabs";
        Assert.assertEquals(homePageFooter.getUrl(),expectedUrl,"User is not on a good page");
        driver.close();
        driver.switchTo().window(tabs2.get(0));

    }

    /**Test Twitter button
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click on LinkedIn button
     * 5.Switch to open new tab
     * 6.Assert user is on a good page with url = "https://www.linkedin.com/company/sauce-labs/"
     *
     */


    @Test(priority = 30)
    public void linkedInButton(){
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageFooter.clickLinkedInButton();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));


        String expectedUrl = "https://www.linkedin.com/company/sauce-labs/";
        System.out.println(homePageFooter.getUrl());
        Assert.assertEquals(homePageFooter.getUrl(),expectedUrl,"User is not on a good page");
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }


}
