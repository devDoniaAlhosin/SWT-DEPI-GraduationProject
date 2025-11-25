package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {

    private WebDriver driver;

    private By header = By.cssSelector("#content h1");
    private By noOrdersMsg = By.cssSelector("#content p");

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getNoOrdersMessage() {
        return driver.findElement(noOrdersMsg).getText();
    }
}
