package steps.login;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import pages.login.LoginPage;

public class LoginSteps {
    //các step phải làm xong đưa qua cái defs
    @Steps
    LoginPage loginPage;

    @Step("I am on the login page")
    public void verifyLoginStep() {
        loginPage.verifyLoginPage();
    }

    @Step("I enter my username and password")
    public void insertUserNameAndPassword(String username, String password) {
        loginPage.insertUserNameAndPassword(username,password);
    }

    @Step("I click the Login button")
    public void clickButtonLogin() {
        loginPage.clickBtnLogin();
    }
}
