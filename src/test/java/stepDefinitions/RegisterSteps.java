package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterPage;
import testBase.BaseClass;
import utilities.RandomDataGenerator;

public class RegisterSteps extends BaseClass {

    RegisterPage rp = new RegisterPage(driver);

    @When("user enters first name {string}")
    public void user_enters_first_name(String firstname) {

        rp.setFirstName(firstname);

    }

    @When("user enters last name {string}")
    public void user_enters_last_name(String lastname) {

        rp.setLastName(lastname);

    }

    @When("user enters registration email with random email")
    public void user_enters_registration_email_with_random_email() {

        rp.setEmail(RandomDataGenerator.randomEmail());

    }

    @When("user enters registration email {string}")
    public void user_enters_registration_email(String email) {

        rp.setEmail(email);

    }

    @When("user enters telephone {string}")
    public void user_enters_telephone(String phone) {

        rp.setTelephone(phone);

    }

    @When("user enters registration password {string}")
    public void user_enters_registration_password(String password) {

        rp.setPassword(password);

    }

    @When("user confirms password {string}")
    public void user_confirms_password(String password) {

        rp.setConfirmPassword(password);

    }

    @When("user subscribes to Newsletter")
    public void user_subscribes_to_newsletter() {

        rp.clickNewsletter();

    }

    @When("user selects Privacy Policy")
    public void user_selects_privacy_policy() {

        rp.clickPrivacyPolicy();

    }

    @When("user clicks on Continue button")
    public void user_clicks_on_continue_button() {

        rp.clickContinue();

    }

    @Then("account should be created successfully")
    public void account_should_be_created_successfully() {

        Assert.assertTrue(rp.isAccountCreated());

    }

    @Then("warning messages should be displayed for all mandatory fields")
    public void warning_messages_should_be_displayed_for_all_mandatory_fields() {

        Assert.assertTrue(rp.isMandatoryWarningsDisplayed());

    }

    @Then("warning message {string} should be displayed")
    public void warning_message_should_be_displayed(String message) {

        Assert.assertTrue(rp.getWarningMessage().contains(message));

    }

    @Then("account creation status should be {string}")
    public void account_creation_status_should_be(String status) {

        if(status.equalsIgnoreCase("Pass")) {

            Assert.assertTrue(rp.isAccountCreated());

        }

    }

}