package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "search")
    WebElement txtSearch;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement btnSearch;

    @FindBy(xpath = "//p[contains(text(),'There is no product')]")
    WebElement txtNoProduct;

    public void enterProduct(String product) {

        txtSearch.clear();
        txtSearch.sendKeys(product);

    }

    public void clickSearchButton() {

        btnSearch.click();

    }

    public boolean verifyProduct(String product) {

        try {

            return driver.findElement(By.linkText(product)).isDisplayed();

        } catch (Exception e) {

            return false;

        }

    }

    public boolean verifyNoProductMessage() {

        return txtNoProduct.isDisplayed();

    }

}