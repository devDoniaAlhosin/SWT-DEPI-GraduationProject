package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    By firstProduct=By.cssSelector(".product-thumb h4 a");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void openFirstProduct() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        driver.findElement(firstProduct).click();

    }

}
