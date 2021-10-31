package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enter valid admin username and password")
    public void user_enter_valid_admin_username_and_password() {
        LoginPage login = new LoginPage();
        sendText(login.usernamebox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordbox, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage login = new LoginPage();
        click(login.loginBtn);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashboardPage dash = new DashboardPage();
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
    }

    @When("user enter valid ess username and password")
    public void user_enter_valid_ess_username_and_password() {
        LoginPage login = new LoginPage();
        sendText(login.usernamebox, ("johnny1234560000"));
        sendText(login.passwordbox, ("Syntax1253!!!!"));
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashboardPage dash = new DashboardPage();
        Assert.assertTrue(dash.welcomeMessage.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage login = new LoginPage();
        sendText(login.usernamebox, ("Admin"));
        sendText(login.passwordbox, ("Syntax1253!!!!"));
    }

    @Then("user see invalid credentials message on login page")
    public void user_see_invalid_credentials_message_on_login_page() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.errorMessage.isDisplayed());
    }
    @When("user enters invalid credentials and clicks on login and verify the error")
    public void user_enters_invalid_credentials_and_clicks_on_login_and_verify_the_error(DataTable errorValidation) {
        List<Map<String,String>> errorData = errorValidation.asMaps();

        for(Map<String,String> validation:errorData){
            String usernameValue = validation.get("username");
            String passwordValue = validation.get("password");
            String errorMessageValue = validation.get("errorMessage");

            LoginPage login = new LoginPage();
            sendText(login.usernamebox, usernameValue);
            sendText(login.passwordbox, passwordValue);
            click(login.loginBtn);

            String errorMessageActual = login.errorMessage.getText();
            Assert.assertEquals("Values do not match",errorMessageActual,errorMessageValue);
        }
    }
    @When("user enters invalid {string} and {string} and clicks on login and verify the {string}")
    public void user_enters_invalid_and_and_clicks_on_login_and_verify_the(String username, String password, String errorMessage) {
        LoginPage login = new LoginPage();
        sendText(login.usernamebox, username);
        sendText(login.passwordbox, password);
        click(login.loginBtn);

        String errorMessageActual = login.errorMessage.getText();
        Assert.assertEquals("Values do not match",errorMessageActual,errorMessage);
    }

}
