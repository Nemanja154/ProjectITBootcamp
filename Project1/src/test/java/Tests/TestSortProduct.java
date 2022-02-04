package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.Driver;

public class TestSortProduct extends Driver {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInPage.logIn();
    }

    /**Test sort products from A to Z
     * Log in parameters: username = standard_user , password = secret_sauce
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Click button LogIn
     * 4.Sort products from A to Z
     * Assert is sort
     */

    @Test
    public void sortByNameAZ(){
        homePageHeader.sortProduct("az");
        Assert.assertTrue(homePageProduct.inventoryListName() <= 0, "Not sort");
    }

    /**Test sort products from Z to A
     * Log in parameters: username = standard_user , password = secret_sauce
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Click button LogIn
     * 4.Sort products from Z to A
     * Assert is sort
     */

    @Test
    public void sortByNameZA(){
        homePageHeader.sortProduct("za");
        Assert.assertTrue(homePageProduct.inventoryListName() >= 0, "Not sort");
    }

    /**Test sort products by price from low to high
     * Log in parameters: username = standard_user , password = secret_sauce
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Click button LogIn
     * 4.Sort products from low to high
     * Assert is sort
     */

    @Test
    public void sortByPriceLoHi() {
        homePageHeader.sortProduct("lohi");
        Assert.assertTrue(homePageProduct.inventoryListPrice() <= 0, "Not sort");
    }

    /**Test sort products by price from high to low
     * Log in parameters: username = standard_user , password = secret_sauce
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Click button LogIn
     * 4.Sort products from high to low
     * Assert is sort
     */

    @Test
    public void sortByPriceHiLo() {
        homePageHeader.sortProduct("hilo");
        Assert.assertTrue(homePageProduct.inventoryListPrice() >= 0, "Not sort");
    }


}
