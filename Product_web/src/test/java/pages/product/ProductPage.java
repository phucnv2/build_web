package pages.product;

import common.BasePage;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductPage extends BasePage {
    public static By nameItemProduct1st = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public static By nameItemShoppingCart = By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name']");
    public static By buttonAddToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static By buttonShoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    public static By buttonCheckOut = By.xpath("//button[@id='checkout']");
    public static By inputFirstName = By.xpath("//input[@id='first-name']");
    public static By inputLastName = By.xpath("//input[@id='last-name']");
    public static By inputZip = By.xpath("//input[@id='postal-code']");
    public static By buttonContinue = By.xpath("//input[@id='continue']");
    public static By titleThanksOrder = By.xpath("//h2[normalize-space()='Thank you for your order!']");
    public static By buttonBackHome = By.xpath("//button[@id='back-to-products']");
    public static By buttonFinish = By.xpath("//button[@id='finish']");

    @Step
    public void clickBtnAddToCart() {
        clickElement(buttonAddToCart);
    }

    @Step
    public void clickBtnShoppingCart() {
        clickElement(buttonShoppingCart);
    }

    @Step
    public void verifyAddProductSuccess() {
        System.out.println("Gia tri ben ngoai la: " + getElementText(nameItemProduct1st) + " Gia tri trong gio hang la: " + getElementText(nameItemShoppingCart));
        Assert.assertEquals(getElementText(nameItemProduct1st), getElementText(nameItemShoppingCart), "Fail!");
    }

    @Step
    public void clickBtnCheckOut() {
        clickElement(buttonCheckOut);
        setText(inputFirstName, "FirstName");
        setText(inputLastName, "LastName");
        setText(inputZip, "10000");
        clickElement(buttonContinue);
    }

    @Step
    public void verifyCheckOutSuccess() {
        clickElement(buttonFinish);
        System.out.println("Tieu de check out thanh cong "+ getElementText(titleThanksOrder));
        Assert.assertEquals(getElementText(titleThanksOrder), "Thank you for your order!", "Fail!");
        clickElement(buttonBackHome);
    }
}
