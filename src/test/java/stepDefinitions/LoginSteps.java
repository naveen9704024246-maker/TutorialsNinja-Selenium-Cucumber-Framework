package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginSteps extends BaseClass {

    LoginPage lp = new LoginPage(driver);

    @When("user enters login email {string}")
    public void user_enters_login_email(String email) {

        lp.enterEmail(email);

    }

    @When("user enters login password {string}")
    public void user_enters_login_password(String password) {

        lp.enterPassword(password);

    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {

        lp.clickLoginButton();

    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {

        Assert.assertTrue(lp.isMyAccountDisplayed());

    }

    @Then("user should see warning message {string}")
    public void user_should_see_warning_message(String expectedMessage) {

        Assert.assertTrue(lp.isWarningMessageDisplayed());
        Assert.assertTrue(lp.getWarningMessage().contains(expectedMessage));

    }

    @Then("login status should be {string}")
    public void login_status_should_be(String status) {

        if(status.equalsIgnoreCase("Pass")) {

            Assert.assertTrue(lp.isMyAccountDisplayed());
            lp.clickLogout();

        } else {

            Assert.assertTrue(lp.isWarningMessageDisplayed());

        }

    }

}