package pages.product;

import common.BasePage;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductPage extends BasePage {
    public static By nameItemProduct1st = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public static By nameItemShoppingCartt = By.xpath("a[id='item_4_title_link'] div[class='inventory_item_name']");
    public static By nameItemShoppingCart = By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name']");
    public static By buttonAddToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static By buttonShoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    @Step
    public void clickBtnAddToCart() {
        clickElement(buttonAddToCart);
        sleep(1);
    }

    @Step
    public void clickBtnShoppingCart() {
        clickElement(buttonShoppingCart);
        sleep(1);
    }

    @Step
    public void verifyAddProductSuccess() {
        System.out.println("Gia tri ben ngoai la: " + getElementText(nameItemProduct1st) + " Gia tri trong gio hang la: " + getElementText(nameItemShoppingCart));
        Assert.assertEquals(getElementText(nameItemProduct1st), getElementText(nameItemShoppingCart), "Fail!");
    }
}
