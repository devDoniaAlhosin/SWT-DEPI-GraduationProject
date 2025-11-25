package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SearchPage;

public class BaseTest {

    public  WebDriver driver;
    public HomePage home;
    public SearchPage search;

    @BeforeMethod
    public void precondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/");
        search = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }
}
