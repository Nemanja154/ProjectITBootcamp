package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "back-to-products")
    WebElement backToProductsButton;

    @FindBy(className = "title")
    WebElement title;

    public void clickBackToProduct(){
        backToProductsButton.click();
    }

    public String getTextTitle(){
        return title.getText();
    }

}
