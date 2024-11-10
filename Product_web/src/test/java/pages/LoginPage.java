package pages;

import common.BasePage;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

  public static final By inputUserName = By.xpath("//input[@id='user-name']");
  public static final By inputPassword = By.xpath("//input[@id='password']");
  public static final By buttonLogin = By.xpath("//input[@id='login-button']");
  public static final By titleLoginSuccess = By.xpath("//div[@class='app_logo']");
  public static final By titleLoginPage = By.xpath("//div[@class='login_logo']");
  public static final By headerUserPassWrong = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");
  public static final By headerUsernameNull = By.xpath("//h3[normalize-space()='Epic sadface: Username is required']"); // cả 2 cungf null là xài cái này
  public static final By headerPasswordNull = By.xpath("//h3[normalize-space()='Epic sadface: Password is required']");

  // click các thứ với lấy xpath xong cái này đưa qua step
  public static void openBrowser(String url) {
    openURL(url);
  }
  @Step
  public void verifyLoginPage() {
    Assert.assertEquals(getElementText(titleLoginPage), "Swag Labs","Fail!");
  }
  @Step
  public void insertUserNameAndPassword(String username, String password) {
    setText(inputUserName, username);
    setText(inputPassword, password);
  }
  @Step
  public void clickBtnLogin() {
    clickElement(buttonLogin);
  }

  public void verifyLoginSuccess() {

  }
}
