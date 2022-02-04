package Tests;

import BaseClass.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOrderProduct extends Driver {

    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        logInPage.logIn();
    }

    /**Test order one product
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click add to cart Sauce Labs Backpack
     * 5.Click cart button
     * 6.Assert user see one element
     * 7.Click Checkout button
     * 8.Insert user information(First name: Pera, Last name: Peric, Postal code: 123456
     * 9.Click Continue button
     * 10.Asser user see one element
     * 11.Click finish
     * Assert message order is COMPLETE!
     */
    @Test(priority = 10)
    public void orderOneProduct(){

        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        wait.until(ExpectedConditions.visibilityOf(homePageProduct.getAddToCartSauceLabsBackpack()));
        homePageProduct.clickAddToCartSauceLabsBackpack();
        homePageHeader.clickCartButton();
        Assert.assertTrue(cartPage.cartSize() == 1,"There is not a single element in the list");
        cartPage.clickCheckoutButton();
        checkoutPage.checkOutYoutInformation("Pera","Peric","123456");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.listSize() == 1,"There is not a single element in the list");
        checkoutOverviewPage.clickFinish();
        Assert.assertTrue(checkoutCompletePage.getTextTitle().contains("COMPLETE!"));

    }

    /**Test order one product
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click add to cart Sauce Labs Backpack
     * 5.Click add to cart Sauce Labs Bike Light
     * 6.Click cart button
     * 7.Assert user see two element
     * 8.Click Checkout button
     * 9.Insert user information(First name: Pera, Last name: Peric, Postal code: 123456
     * 10.Click Continue button
     * 11.Assert user see two element
     * 12.Click finish
     * Assert message order is COMPLETE!
     */

    @Test(priority = 20)
    public void orderTwoProduct(){
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageProduct.clickAddToCartSauceLabsBackpack();
        homePageProduct.clickAddToCartSauceLabsBikeLight();
        homePageHeader.clickCartButton();
        Assert.assertTrue(cartPage.cartSize() == 2,"There are no two elements in the list");
        cartPage.clickCheckoutButton();
        checkoutPage.checkOutYoutInformation("Pera","Peric","123456");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.listSize() == 2,"There are no two elements in the list");
        checkoutOverviewPage.clickFinish();
        Assert.assertTrue(checkoutCompletePage.getTextTitle().contains("COMPLETE!"));
    }

    /**Test order one product
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click add to cart Sauce Labs Backpack
     * 5.Click cart button
     * 6.Assert user see one element
     * 7.Click Continue Shopping Button
     * Assert user see products
     */

    @Test(priority = 40)
    public void continueShopping() {
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageProduct.clickAddToCartSauceLabsBackpack();
        homePageHeader.clickCartButton();
        Assert.assertTrue(cartPage.cartSize() == 1,"There is not a single element in the list");
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "Did not return to products");

    }

    /**
     * 1.Go on website url = https://www.saucedemo.com/
     * 2.LogIn with valid username and password
     * 3.Assert user is login
     * 4.Click add to cart Sauce Labs Backpack
     * 5.Click add to cart Sauce Labs Bike Light
     * 6.Click add to cart Sauce Labs Fleece Jacket
     * 7.Click add to cart Sauce Labs Onesie
     * 8.Click Cart Button
     * 9.Assert cart is not empty
     * 10.Remove products from cart
     * 11.Assert cart is empty
     */

    @Test(priority = 30)
    public void removeAllProductsFromCart() throws InterruptedException {
        Assert.assertTrue(homePageHeader.getTitle().getText().contains("PRODUCTS"), "User not Login");
        homePageProduct.clickAddToCartSauceLabsBackpack();
        homePageProduct.clickAddToCartSauceLabsBikeLight();
        homePageProduct.clickAddToCartSauceLabsFleeceJacket();
        homePageProduct.clickAddToCartSauceLabsOnesie();
        homePageHeader.clickCartButton();
        Assert.assertFalse(cartPage.getListItem().isEmpty(),"Products have not been deleted");
        cartPage.removeProductsFromCart();
        Assert.assertTrue(cartPage.getListItem().isEmpty(),"Products have not been deleted");

    }
}
