package def.logout;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import pages.logout.LogoutPage;
import steps.product.ProductSteps;

public class Logoutdefs {
    @Steps
    LogoutPage logoutPage;

    @And("I click the Logout button")
    public void iClickTheLogoutButton() {
        logoutPage.clickButtonMenu();
    }

    @Then("Verify logout success")
    public void verifyLogoutSuccess() {
        logoutPage.verifyLogoutSuccess();
    }
}
