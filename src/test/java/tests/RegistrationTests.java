package tests;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.ArrayList;
import java.util.List;



public class RegistrationTests extends BaseTest {

    @Test(priority = 3)
    public void Register_successfully(){
        RegisterPage register_page=new RegisterPage(driver);
        register_page.Navigate_to_register();
        String randomEmail = "user2" + System.currentTimeMillis() + "@test.com";
        utils.GlobalData.LAST_REGISTERED_EMAIL = randomEmail;
        register_page.register("Heba", "Srour", randomEmail, "password123");


    }

    @Test(priority = 1)
    public void RegisterWithEmptyFields() {

        RegisterPage reg = new RegisterPage(driver);
        reg.Navigate_to_register();

        reg.clickContinue();

        List<String> missingFields = new ArrayList<>();

        if (reg.isFirstNameErrorDisplayed()) {
            missingFields.add("First Name");
        }
        if (reg.isLastNameErrorDisplayed()) {
            missingFields.add("Last Name");
        }
        if (reg.isEmailErrorDisplayed()) {
            missingFields.add("Email");
        }
        if (reg.isPasswordErrorDisplayed()) {
            missingFields.add("Password");
        }
        if (reg.isPrivacyPolicyErrorDisplayed()) {
            missingFields.add("Privacy Policy");
        }


        Assert.assertFalse(missingFields.isEmpty(),
                "Expected at least one validation error, but none were displayed.");

        reg.AssertionforInvalidregister();
        System.out.println("❌ Missing or invalid fields: " + missingFields);


    }


    @Test(priority = 2)
    public void testRegistrationWithoutPrivacyPolicy() {
        RegisterPage regPage=new RegisterPage(driver);
        regPage.Navigate_to_register();
        String email = "user" + System.currentTimeMillis() + "@test.com";
        regPage.registerWithPrivacyPolicyNotChecked("user"+ Math.random(),"Opencart",email,"6545321");

        regPage.clickContinue();

        Assert.assertTrue(regPage.isPrivacyPolicyErrorDisplayed(),
                "Expected privacy policy error message");
    }


}