package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected CartPage cartPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://localhost/opencartproject/index.php?route=product/product&language=en-gb&product_id=40");
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
