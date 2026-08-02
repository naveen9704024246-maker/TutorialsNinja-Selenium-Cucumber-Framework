package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import testBase.BaseClass;

public class CommonSteps extends BaseClass {

    HomePage hp;

    @Given("user launches the browser")
    public void user_launches_the_browser() {

        hp = new HomePage(driver);

    }

    @When("user clicks on My Account")
    public void user_clicks_on_my_account() {

        hp.clickMyAccount();

    }

    @When("user clicks on Login")
    public void user_clicks_on_login() {

        hp.clickLogin();

    }

    @When("user clicks on Register")
    public void user_clicks_on_register() {

        hp.clickRegister();

    }

}