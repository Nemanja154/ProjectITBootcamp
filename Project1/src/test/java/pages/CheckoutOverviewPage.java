package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage {
    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //URL https://www.saucedemo.com/checkout-step-two.html

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "cart_item_label")
    List<WebElement> listItemLabel;


    public void clickFinish(){
        finishButton.click();
    }

    public int listSize(){
        return listItemLabel.size();
    }


}
