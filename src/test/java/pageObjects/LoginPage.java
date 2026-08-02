package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="input-email")
    WebElement txtEmail;

    @FindBy(id="input-password")
    WebElement txtPassword;

    @FindBy(xpath="//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath="//div[contains(@class,'alert-danger')]")
    WebElement warningMessage;

    @FindBy(xpath="//h2[text()='My Account']")
    WebElement myAccountHeading;

    @FindBy(linkText="Logout")
    WebElement logout;

    public void enterEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public boolean isMyAccountDisplayed() {
        return myAccountHeading.isDisplayed();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public boolean isWarningMessageDisplayed() {
        return warningMessage.isDisplayed();
    }

    public void clickLogout() {
        logout.click();
    }

}