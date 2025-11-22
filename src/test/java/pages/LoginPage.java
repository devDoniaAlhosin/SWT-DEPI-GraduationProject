package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LogUtil;

public class LoginPage {

    // 1. Constructor
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 2. Locators
    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");

    private By loginButton = By.xpath(
            "//button[@type='submit' and text()='Login']"
    );

    private By warningMessage = By.cssSelector(".alert-danger");
    private By forgotPasswordLink = By.linkText("Forgotten Password");

    // 3. Actions
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    // 4. Assertions (getters)
    public String getWarningMessage() {
        LogUtil.info("Getting warning message");
        return driver.findElement(warningMessage).getText().trim();
    }

}
