package def.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import steps.product.ProductSteps;

public class Productdefs {
    @Steps
    ProductSteps productSteps;

    @And("I add product success")
    public void iAddProductSuccess() {
        productSteps.clickBtnAddToCart();
    }

    @And("I view shop card")
    public void iViewShopCard() {
        productSteps.clickBtnShoppingCart();
    }

    @And("I checkout product success")
    public void iCheckoutProductSuccess() {
        productSteps.clickBtnCheckOut();
    }

    @Then("Verify checkout success")
    public void verifyCheckoutSuccess() {
        productSteps.verifyCheckOutSuccess();
    }
}
