package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterPage {

    /// //locators////  //
    ///           ///
    WebDriver driver;
    By LoginPage_link=By.cssSelector("a[href=\"http://localhost/opencartproject/index.php?route=account/login&language=en-gb\"]");
    By FirstName= By.id("input-firstname");
    By LastName=By.id("input-lastname");
    By Email=By.id("input-email");
    By Password=By.id("input-password");
    //By Continue_button = By.cssSelector("button[type='submit']");
    By Continue_button = By.xpath("//button[@type='submit' and contains(@class,'btn-primary')]");

    By Privacy_check=By.name("agree");

    By firstname_error_msg = By.id("error-firstname");
    By lastname_error_msg  = By.id("error-lastname");
    By email_error_msg     = By.id("error-email");
    By password_error_msg  = By.id("error-password");
    By privacy_error_msg   = By.cssSelector("div.alert-danger");



    /// // constructor ///////
    //                  ////
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    /// /// Actions/// ////
    ///           ///
    public void register(String firstname, String lastname, String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName));

        driver.findElement(FirstName).sendKeys(firstname);
        driver.findElement(LastName).sendKeys(lastname);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(password);

        // Fix privacy checkbox click
        WebElement privacy = driver.findElement(Privacy_check);

// Scroll to the checkbox
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                privacy
        );

// Wait until it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(Privacy_check));

// Force click with JS
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                privacy
        );

// Scroll to Continue button
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                driver.findElement(Continue_button)
        );


        driver.findElement(Continue_button).click();
    }


    public void Navigate_to_register(){
        driver.navigate().to("http://localhost/opencartproject/index.php?route=account/register&language=en-gb");
    }

    public void registerWithPrivacyPolicyNotChecked(String firstname, String lastname, String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName));

        driver.findElement(FirstName).sendKeys(firstname);
        driver.findElement(LastName).sendKeys(lastname);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(password);

        // Fix privacy checkbox click
        WebElement privacy = driver.findElement(Privacy_check);

       // Scroll to Continue button
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                driver.findElement(Continue_button)
        );
       // Wait until it's clickable
       wait.until(ExpectedConditions.elementToBeClickable(Privacy_check));

        driver.findElement(Continue_button).click();
    }




    public void clickContinue() {
        WebElement btn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(Continue_button));

        try { btn.click(); }
        catch (Exception e) { ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'}); arguments[0].click();", btn); }
    }




    public boolean isFirstNameErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.presenceOfElementLocated(firstname_error_msg));
            return driver.findElement(firstname_error_msg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLastNameErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.presenceOfElementLocated(lastname_error_msg));
            return driver.findElement(lastname_error_msg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.presenceOfElementLocated(email_error_msg));
            return driver.findElement(email_error_msg).isDisplayed();
        } catch (Exception e) {

            return false;
        }
    }

    public boolean isPasswordErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.presenceOfElementLocated(password_error_msg));
            return driver.findElement(password_error_msg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPrivacyPolicyErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            wait.until(ExpectedConditions.presenceOfElementLocated(privacy_error_msg));
            return driver.findElement(privacy_error_msg).isDisplayed();
        } catch (Exception e) {

            return false;
        }
    }

    @Test
    public void alreadyHaveAnAccountBackToLoginPage() {
        driver.findElement(LoginPage_link).click();
    }

    /// /// Assertions //// ///
    ///                     ///
    public void AssertionforInvalidregister()
    {

        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencartproject/index.php?route=account/register&language=en-gb");
    }

}

