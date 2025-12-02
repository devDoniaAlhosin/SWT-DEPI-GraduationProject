package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.GlobalData;
import utils.LogUtil;
import utils.TestDataUtil;

import java.time.Duration;
import java.util.Set;

public class BaseTest {

    protected WebDriver driver;

    /**
     * Optional: stores cookies only if a test explicitly performs login.
     */
    protected Set<Cookie> loginCookies;

    /**
     * Manually performs login. Tests call this when needed.
     */
    public void doLogin() throws InterruptedException {

        // If already logged in, skip login
        if (driver.getTitle().contains("My Account")) {
            LogUtil.info("Already logged in. Skipping login.");
            return;
        }

        LogUtil.info("Opening Login Page...");
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LogUtil.info("Preparing login credentials...");
        LoginPage login = new LoginPage(driver);

        // Load email: first try from GlobalData
        String emailToUse = GlobalData.LAST_REGISTERED_EMAIL;

        // fallback if missing
        if (emailToUse == null || emailToUse.isEmpty()) {
            emailToUse = TestDataUtil.getValue("login.valid.email");
        }

        String passwordToUse = TestDataUtil.getValue("login.valid.password");

        // ---- TRY LOGIN ----
        login.enterEmail(emailToUse);
        login.enterPassword(passwordToUse);
        login.clickLogin();

        Thread.sleep(1000);

        // Check if login failed
        if (driver.getTitle().contains("My Account")) {
            LogUtil.info("Login successful: " + emailToUse);
            return;
        }

        LogUtil.warn("Login failed → Trying to register user automatically...");

        // ---- AUTO-REGISTER ----
        RegisterPage reg = new RegisterPage(driver);
        reg.Navigate_to_register();

        // generate new email if the current one is invalid
        if (!emailToUse.contains("@")) {
            emailToUse = "auto" + System.currentTimeMillis() + "@test.com";
        }

        GlobalData.LAST_REGISTERED_EMAIL = emailToUse;

        reg.register("Auto", "User", emailToUse, passwordToUse);

        Thread.sleep(1500);

        // ---- LOGIN AGAIN AFTER REGISTRATION ----
        home.clickLogoutDropdown();  // logout after auto-registration (OpenCart requirement)
        home.clickLogin();

        login.enterEmail(emailToUse);
        login.enterPassword(passwordToUse);
        login.clickLogin();

        Thread.sleep(1500);

        if (!driver.getTitle().contains("My Account")) {
            throw new AssertionError("Auto-Register + Login failed.");
        }

        LogUtil.info("Auto-Register + Login SUCCESS using: " + emailToUse);
    }



    /**
     * Initial setup for every test class.
     */
    @BeforeClass
    public void setUp() {
        LogUtil.info("Initializing ChromeDriver...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseUrl = TestDataUtil.getValue("app.base.url");
        LogUtil.info("Opening site: " + baseUrl);
        driver.get(baseUrl);
    }

    /**
     * If a test saved cookies manually, it can restore them by calling this method.
     */
    public void restoreLoginSession() {
        if (loginCookies != null) {
            LogUtil.info("Restoring saved login cookies...");
            driver.manage().deleteAllCookies();

            for (Cookie cookie : loginCookies) {
                driver.manage().addCookie(cookie);
            }

            driver.navigate().refresh();
        }
    }

    /**
     * Clears WebDriver after all tests are finished.
     */
    @AfterClass
    public void tearDown() {
        LogUtil.warn("Closing WebDriver...");
        driver.quit();
    }
}
