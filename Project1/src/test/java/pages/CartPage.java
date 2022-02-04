package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //URL https://www.saucedemo.com/cart.html

    @FindBy(className = "title")
    WebElement cartTitle;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removebutton;

    @FindBy(className = "cart_button")
    List<WebElement> listRemoveButtons;

    @FindBy(className = "cart_item")
    List<WebElement> listItem;

    public String getCartTitle(){
        return cartTitle.getText();
    }

    public void clickContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public List<WebElement> getListItem() {
        return listItem;
    }

    public int cartSize(){
        return listItem.size();
    }

    //----------------------------------------------------------

    public void removeProductsFromCart() throws InterruptedException {
        for(int i = listRemoveButtons.size() - 1 ; i >= 0; i--){
                listRemoveButtons.get(i).click();
        }
    }

}
