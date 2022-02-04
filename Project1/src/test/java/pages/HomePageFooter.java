package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFooter {
    private WebDriver driver;

    public HomePageFooter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //URL https://www.saucedemo.com/inventory.html

    @FindBy(className = "social_twitter")
    WebElement twitterButton;

    @FindBy(className = "social_facebook")
    WebElement facebookButton;

    @FindBy(className = "social_linkedin")
    WebElement linkedInButton;

    public void clickTwitterButton(){
        twitterButton.click();
    }

    public void clickFacebookButton(){
        facebookButton.click();
    }

    public void clickLinkedInButton(){
        linkedInButton.click();
    }

    //------------------------------------------

    public String getUrl(){
        return driver.getCurrentUrl();
    }

}
