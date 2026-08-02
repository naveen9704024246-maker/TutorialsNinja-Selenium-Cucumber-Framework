package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "search")
    WebElement txtSearch;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement btnSearch;

    @FindBy(xpath = "//button[contains(@onclick,'cart.add')]")
    WebElement btnAddToCart;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMessage;

    public void searchProduct(String product) {

        txtSearch.clear();
        txtSearch.sendKeys(product);

    }

    public void clickSearchButton() {

        btnSearch.click();

    }

    public void clickAddToCart() {

        btnAddToCart.click();

    }

    public boolean verifySuccessMessage() {

        return successMessage.isDisplayed();

    }

    public boolean verifyProductDisplayed(String product) {

        try {

            return driver.findElement(By.linkText(product)).isDisplayed();

        } catch (Exception e) {

            return false;

        }

    }

}