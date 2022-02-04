package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {
    WebDriver driver;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBatton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    WebElement aboutButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOutButton;

    @FindBy(id = "reset_sidebar_link")
    WebElement restAppStateButton;

    public void clickMenuButton(){
        menuBatton.click();
    }

    public void clickAllItemsButton(){
        allItemsButton.click();
    }

    public void clickAboutButton(){
        aboutButton.click();
    }

    public void clickLogoutButton(){
        logOutButton.click();
    }

    public void clickRestAppStateButton(){
        restAppStateButton.click();
    }

}
