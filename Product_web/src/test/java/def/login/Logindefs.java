package def.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.login.LoginSteps;

import static pages.login.LoginPage.*;

public class Logindefs {

    @Steps
    LoginSteps loginSteps;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){
        openBrowser("https://www.saucedemo.com/");
        loginSteps.verifyLoginStep();
    }

    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword() {
        loginSteps.insertUserNameAndPassword("standard_user", "secret_sauce");
    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        loginSteps.clickButtonLogin();
    }

    @Then("I should be taken to the Dashboard page")
    public void iShouldBeTakenToTheDashboardPage() {
    }
}
