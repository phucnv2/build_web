package pages.logout;

import common.BasePage;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LogoutPage extends BasePage {
    public static By buttonMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    public static By buttonLogout = By.xpath("//a[@id='logout_sidebar_link']");
    public static final By titleLoginPage = By.xpath("//div[@class='login_logo']");

    @Step
    public void clickButtonMenu() {
        clickElement(buttonMenu);
        clickElement(buttonLogout);
    }
    @Step
    public void verifyLogoutSuccess(){
        Assert.assertEquals(getElementText(titleLoginPage), "Swag Labs","Fail!");
    }
}
