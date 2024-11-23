package common;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage{
    public static void createBrowser() {
        WebDriver driver = setBrowser();
        DriverManager.setDriver(driver);
    }

    public static WebDriver setBrowser() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }

    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void closeBrowser() {
        DriverManager.quit();
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public void setText(By by, String text) {
        waitForElementVisible(by);
        highLightElement(by);
        DriverManager.getDriver().findElement(by).sendKeys(text);
    }

    public void clickElement(By by) {
        waitForElementClickable(by);
        highLightElement(by);
        getWebElement(by).click();
    }
    public Double splitNumber(By by, int n){
        String chuoi = getElementText(by);
        // Tách chuỗi bắt đầu từ vị trí 7 (kể từ 0)
        String chuoiCon = chuoi.substring(n);
        Double soThuc = Double.valueOf(chuoiCon);
        return soThuc;
    }

    public Double totalNumber(Double number,Double number1){
        Double total = number + number1;
        return total;
    }

    public boolean getCurrentUrl(String textUrl) {
        boolean text = DriverManager.getDriver().getCurrentUrl().contains(textUrl);
        return true;
    }

    public String getElementText(By by) {
        waitForElementVisible(by);
        String text = DriverManager.getDriver().findElement(by).getText();
        return text;
    }

    public WebElement highLightElement(By by) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='2px solid red'", getWebElement(by));
            sleep(0.5);
        }
        return getWebElement(by);
    }
}
