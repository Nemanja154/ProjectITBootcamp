package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageHeader {
        private WebDriver driver;

        public HomePageHeader(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        //URL https://www.saucedemo.com/inventory.html

        @FindBy(className = "primary_header")
        WebElement primatyHeader;

        @FindBy(className = "header_secondary_container")
        WebElement secondaryHeader;

        @FindBy(id = "react-burger-menu-btn")
        WebElement menuButton;

        @FindBy(className = "shopping_cart_link")
        WebElement cartButton;

        @FindBy(className = "title")
        WebElement title;

        @FindBy(className = "peek")
        WebElement picturePeek;

        @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
        WebElement sortProduct;

        public WebElement getPrimatyHeader() {
            return primatyHeader;
        }

        public WebElement getSecondaryHeader() {
            return secondaryHeader;
        }

        public WebElement getMenuButton() {
            return menuButton;
        }

        public void clickCartButton() {
            cartButton.click();
        }

        public WebElement getTitle() {
            return title;
        }

        public WebElement getPicturePeek() {
            return picturePeek;
        }

        public void sortProduct(String value) {
            sortProduct.click();
            Select select = new Select(sortProduct);
            select.selectByValue(value);
        }
}
