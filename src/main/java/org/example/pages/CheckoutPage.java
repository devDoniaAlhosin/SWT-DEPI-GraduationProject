package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    By firstName = By.id("input-payment-firstname");
    By lastName = By.id("input-payment-lastname");
    By email = By.id("input-payment-email");
    By telephone = By.id("input-payment-telephone");
    By address = By.id("input-payment-address-1");
    By city = By.id("input-payment-city");
    By postcode = By.id("input-payment-postcode");
    By country = By.id("input-payment-country");
    By region = By.id("input-payment-zone");

    By continueBtnBilling = By.id("button-payment-address");
    By continueBtnDelivery = By.id("button-shipping-address");
    By continueBtnMethod = By.id("button-shipping-method");
    By continueBtnPayment = By.id("button-payment-method");
    By termsCheckbox = By.name("agree");
    By confirmOrderBtn = By.id("button-confirm");

    public void fillBillingDetails() {
        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(email).sendKeys("test123@example.com");
        driver.findElement(telephone).sendKeys("0123456789");
        driver.findElement(address).sendKeys("123 Test Street");
        driver.findElement(city).sendKeys("Cairo");
        driver.findElement(postcode).sendKeys("12345");
        driver.findElement(country).sendKeys("Egypt");
        driver.findElement(region).sendKeys("Alexandria");
    }

    public void completeCheckout() {
        driver.findElement(continueBtnBilling).click();
        driver.findElement(continueBtnDelivery).click();
        driver.findElement(continueBtnMethod).click();
        driver.findElement(termsCheckbox).click();
        driver.findElement(continueBtnPayment).click();
        driver.findElement(confirmOrderBtn).click();
    }
}
