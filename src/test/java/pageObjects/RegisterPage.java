package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="input-firstname")
    WebElement txtFirstName;

    @FindBy(id="input-lastname")
    WebElement txtLastName;

    @FindBy(id="input-email")
    WebElement txtEmail;

    @FindBy(id="input-telephone")
    WebElement txtTelephone;

    @FindBy(id="input-password")
    WebElement txtPassword;

    @FindBy(id="input-confirm")
    WebElement txtConfirmPassword;

    @FindBy(name="newsletter")
    WebElement radioNewsletter;

    @FindBy(name="agree")
    WebElement chkPrivacyPolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
    WebElement successMessage;

    @FindBy(xpath="//div[contains(@class,'alert-danger')]")
    WebElement warningMessage;

    @FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
    WebElement firstNameWarning;

    @FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
    WebElement lastNameWarning;

    @FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
    WebElement emailWarning;

    @FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
    WebElement telephoneWarning;

    @FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
    WebElement passwordWarning;

    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String phone) {
        txtTelephone.sendKeys(phone);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String cpwd) {
        txtConfirmPassword.sendKeys(cpwd);
    }

    public void clickNewsletter() {
        radioNewsletter.click();
    }

    public void clickPrivacyPolicy() {
        chkPrivacyPolicy.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }

    public boolean isAccountCreated() {
        return successMessage.isDisplayed();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public boolean isMandatoryWarningsDisplayed() {

        return firstNameWarning.isDisplayed()
                && lastNameWarning.isDisplayed()
                && emailWarning.isDisplayed()
                && telephoneWarning.isDisplayed()
                && passwordWarning.isDisplayed();

    }

}