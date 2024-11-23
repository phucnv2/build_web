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
    public static By amountProduct = By.xpath("//div[@class='inventory_item_price']");
    public static By amountCartProduct = By.xpath("//div[@class='inventory_item_price']");
    public static By amountTax = By.xpath("//div[@class='summary_tax_label']");
    public static By amountTotal = By.xpath("//div[@class='summary_total_label']");

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
        Assert.assertEquals(getElementText(nameItemProduct1st), getElementText(nameItemShoppingCart), "Fail!");
    }

    @Step
    public void clickBtnCheckOut() {
        clickElement(buttonCheckOut);
        setText(inputFirstName, "FirstName");
        setText(inputLastName, "LastName");
        setText(inputZip, "10000");
        clickElement(buttonContinue);
        Assert.assertEquals(splitNumber(amountCartProduct,1), splitNumber(amountProduct,1), "Fail! Amount not match"); // check tiền ở đây
        Assert.assertEquals(totalNumber(splitNumber(amountTax,6), splitNumber(amountCartProduct,1)), splitNumber(amountTotal,8), "Fail! Amount not match"); // check tổng tiền ở đây
    }

    @Step
    public void verifyCheckOutSuccess() {
        clickElement(buttonFinish);
        Assert.assertEquals(getElementText(titleThanksOrder), "Thank you for your order!", "Fail!");
        clickElement(buttonBackHome);
    }
}
