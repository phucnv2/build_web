package steps.product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import pages.product.ProductPage;

public class ProductSteps {
    @Steps
    ProductPage productPage;

    @Step("I add product success")
    public void clickBtnAddToCart() {
        productPage.clickBtnAddToCart();
    }

    @Step("I view shop card")
    public void clickBtnShoppingCart() {
        productPage.clickBtnShoppingCart();
        productPage.verifyAddProductSuccess();
    }
}
