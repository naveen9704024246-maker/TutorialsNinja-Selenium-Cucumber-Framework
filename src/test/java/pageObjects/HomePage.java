package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath="//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(linkText="Login")
    WebElement login;

    @FindBy(linkText="Register")
    WebElement register;

    @FindBy(name="search")
    WebElement searchBox;

    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    public void clickMyAccount() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(myAccount));

        myAccount.click();

    }

    public void clickLogin() {
        login.click();
    }

    public void clickRegister() {
        register.click();
    }

    public void enterProduct(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
    }

    public void clickSearch() {
        searchButton.click();
    }

}