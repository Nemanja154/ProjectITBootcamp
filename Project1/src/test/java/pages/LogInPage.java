package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login_logo")
    WebElement logoLogin;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]")
    WebElement pictureOnLoginPage;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "login_credentials_wrap-inner")
    WebElement loginCredentials;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    WebElement errorMessage;


    public WebElement getLogoLogin() {
        return logoLogin;
    }

    public WebElement getPictureOnLoginPage() {
        return pictureOnLoginPage;
    }

    public void getUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    public void getPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public WebElement getLoginCredentials() {
        return loginCredentials;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }


    //---------------------------------------------------------------

    public String buttonColor(){
        String button = this.loginButton.getCssValue("background-color");
        String hex = Color.fromString(button).asHex();
        return hex;
    }

    public void logIn(){
        this.getUsernameInput("standard_user");
        this.getPasswordInput("secret_sauce");
        this.clickLoginButton();
    }
}
