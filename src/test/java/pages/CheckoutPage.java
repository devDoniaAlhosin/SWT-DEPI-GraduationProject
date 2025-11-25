package pages;

import utils.TestDataUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // -------------------------------------------
    // Locators
    // -------------------------------------------
    private By guestRadio = By.id("input-guest");

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");

    private By telephone = By.id("input-telephone");
    private By address1 = By.id("input-shipping-address-1");
    private By address2 = By.id("input-shipping-address-2");
    private By city = By.id("input-shipping-city");
    private By postcode = By.id("input-shipping-postcode");

    private By country = By.id("input-shipping-country");
    private By region = By.id("input-shipping-zone");

    private By continueBtn = By.id("button-register");

    private By orderSuccessMessage = By.cssSelector("#content h1");


    // -------------------------------------------
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // -------------------------------------------
    // Fill Billing for Guest Checkout
    // -------------------------------------------
    public void fillBillingDetails() {

        // Load Test Data
        String fn = TestDataUtil.getValue("checkout.guest.firstname");
        String ln = TestDataUtil.getValue("checkout.guest.lastname");
        String mail = TestDataUtil.getValue("checkout.guest.email");
        String phone = TestDataUtil.getValue("checkout.guest.telephone");
        String addr1Txt = TestDataUtil.getValue("checkout.guest.address1");
        String addr2Txt = TestDataUtil.getValue("checkout.guest.address2");
        String cityTxt = TestDataUtil.getValue("checkout.guest.city");
        String postTxt = TestDataUtil.getValue("checkout.guest.postcode");
        String countryTxt = TestDataUtil.getValue("checkout.guest.country");   // Egypt
        String regionTxt = TestDataUtil.getValue("checkout.guest.region");     // Aswan

        // Select Guest Checkout
        wait.until(ExpectedConditions.elementToBeClickable(guestRadio)).click();

        // Fill personal info
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(mail);

        try {
            driver.findElement(telephone).sendKeys(phone);
        } catch (Exception ignored) {}

        // Fill Address
        driver.findElement(address1).sendKeys(addr1Txt);
        driver.findElement(address2).sendKeys(addr2Txt);
        driver.findElement(city).sendKeys(cityTxt);
        driver.findElement(postcode).sendKeys(postTxt);

        // ---------------------------------------
        // Select Country (Egypt)
        // ---------------------------------------
        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText(countryTxt);

        // Wait for Region dropdown to load & enable (AJAX)
        wait.until(ExpectedConditions.elementToBeClickable(region));
        wait.until(driver -> driver.findElement(region).isEnabled());

        // ---------------------------------------
        // Select Region (Aswan)
        // ---------------------------------------
        Select regionSelect = new Select(driver.findElement(region));
        regionSelect.selectByVisibleText(regionTxt);

        // Continue
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    // -------------------------------------------
    public void completeCheckout() {

        // Wait until the "Continue" button appears after account creation
        By accountContinueBtn = By.cssSelector("#content .btn.btn-primary");

        wait.until(ExpectedConditions.elementToBeClickable(accountContinueBtn)).click();
    }


 // -------------------------------------------

    private By pageHeader = By.cssSelector("#content h1");
    public WebElement getPageHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
    }

}
