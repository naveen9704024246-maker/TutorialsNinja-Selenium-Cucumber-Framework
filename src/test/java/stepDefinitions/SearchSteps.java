package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class SearchSteps extends BaseClass {

    SearchPage sp = new SearchPage(driver);

    String searchedProduct;

    @When("user searches product {string}")
    public void user_searches_product(String product) {

        searchedProduct = product;
        sp.enterProduct(product);

    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {

        sp.clickSearchButton();

    }

    @Then("searched product {string} should be displayed")
    public void searched_product_should_be_displayed(String product) {

        Assert.assertTrue(sp.verifyProduct(product));

    }

    @Then("no product should be found")
    public void no_product_should_be_found() {

        Assert.assertTrue(sp.verifyNoProductMessage());

    }

    @Then("search status should be {string} for {string}")
    public void search_status_should_be(String status, String product) {

        if(status.equalsIgnoreCase("Pass")) {

            Assert.assertTrue(sp.verifyProduct(product));

        }
        else {

            Assert.assertTrue(sp.verifyNoProductMessage());

        }

    }

}