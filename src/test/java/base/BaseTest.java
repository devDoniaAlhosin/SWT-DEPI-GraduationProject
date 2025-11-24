package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.RegisterPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    //LoginPage loginPage;
   // RegisterPage registerpage;

    @BeforeMethod
    public void precondetions(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--incognito");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // registerpage=new RegisterPage(driver);
        //loginPage = new LoginPage(driver);
      //  loginPage.Navigate();
    }
    @AfterMethod
    public void Tier_Down(){
        driver.quit();
    }
}
