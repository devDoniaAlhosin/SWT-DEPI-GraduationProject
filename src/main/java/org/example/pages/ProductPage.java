package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By addToCartBtn = By.id("button-cart");
    By successAlert = By.cssSelector(".alert-success a[href*='route=checkout/cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void clickSuccessCartLink() {
        driver.findElement(successAlert).click();
    }
}
