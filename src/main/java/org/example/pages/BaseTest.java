package org.example.pages;

import org.example.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
@BeforeMethod
    public void setup(){
driver= DriverFactory.getDriver();
driver.get("https://demo.opencart.com/");
}
@AfterMethod
public void tearDown(){
DriverFactory.quitDriver();
}
}