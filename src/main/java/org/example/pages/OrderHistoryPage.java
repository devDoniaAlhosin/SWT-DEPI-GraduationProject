package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    WebDriver driver;
    By orderTableRows = By.cssSelector("table.table tbody tr");

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getOrderCount() {
        return driver.findElements(orderTableRows).size();
    }
}
