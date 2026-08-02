package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import testBase.BaseClass;

public class CartSteps extends BaseClass {

    CartPage cp = new CartPage(driver);

    String productName;

    @When("user searches cart product {string}")
    public void user_searches_cart_product(String product) {

        productName = product;
        cp.searchProduct(product);

    }

    @When("user clicks on Cart Search button")
    public void user_clicks_on_cart_search_button() {

        cp.clickSearchButton();

    }

    @When("user adds product to cart")
    public void user_adds_product_to_cart() {

        cp.clickAddToCart();

    }

    @Then("product should be added successfully")
    public void product_should_be_added_successfully() {

        Assert.assertTrue(cp.verifySuccessMessage());

    }

    @Then("cart status should be {string}")
    public void cart_status_should_be(String status) {

        if(status.equalsIgnoreCase("Pass")) {

            Assert.assertTrue(cp.verifySuccessMessage());

        } else {

            Assert.fail("Product was not added successfully.");

        }

    }

    @Then("shopping cart should contain product")
    public void shopping_cart_should_contain_product() {

        Assert.assertTrue(cp.verifySuccessMessage());

    }

}