package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Driver {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected LogInPage logInPage;
    protected HomePageProduct homePageProduct;
    protected HomePageHeader homePageHeader;
    protected HomePageFooter homePageFooter;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected NavigationPage navigationPage;



    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        logInPage = new LogInPage(driver);
        homePageProduct = new HomePageProduct(driver);
        homePageHeader = new HomePageHeader(driver);
        homePageFooter = new HomePageFooter(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        navigationPage = new NavigationPage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }


}
