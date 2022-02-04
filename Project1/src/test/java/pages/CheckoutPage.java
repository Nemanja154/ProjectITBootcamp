package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "first-name")
    WebElement fistNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "cancel")
    WebElement cencelButton;

    public void setFistNameInput(String fistName){
        fistNameInput.sendKeys(fistName);
    }

    public void setLastNameInput(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void setPostalCodeInput(String postalCode){
        postalCodeInput.sendKeys(postalCode);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public void clickCancelButton(){
        cencelButton.click();
    }

    //------------------------------------------------

    public void checkOutYoutInformation(String firstName,String lastName,String postalCode){
        setFistNameInput(firstName);
        setLastNameInput(lastName);
        setPostalCodeInput(postalCode);
    }
}
