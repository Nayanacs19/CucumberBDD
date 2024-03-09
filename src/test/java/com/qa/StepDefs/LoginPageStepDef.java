package com.qa.StepDefs;

import com.cucumber.qa.pages.LoginPage;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageStepDef {
    private LoginPage loginPage = new LoginPage();

    @Before
    public void setUp(){
        DriverManager.setUp();
        DriverManager.getDriver();
    }
    @After
    public void teardown(){
        DriverManager.teardown();
    }

    @Given("I am on the HRM login page")
    public void i_am_on_the_hrm_login_page(){
        DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password(){
        loginPage.logintoApplication("Admin", "admin123");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button(){
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully(){
        Assert.assertEquals(loginPage.getHomePageTitle(),"Dashboard");
    }

    @Given("I have entered invalid (.*) and (.*)$")
    public void i_have_entered_invalid_and(String username, String password){
        loginPage.logintoApplication(username, password);
    }

    @Then("I should see an error message (.*)$")
    public void i_should_see_an_error_message(String error_message){
        Assert.assertEquals(loginPage.getInvalidCredentialMessage(), error_message);
    }

    @When("I click on \"Forgot your password?\" link")
    public void i_click_on_Forgot_your_password_link(){
        loginPage.clickForgotPassword();
    }

    @Then("I shoudld be redirected to password reset page")
    public void i_shoudld_be_redirected_to_password_reset_page(){
        Assert.assertTrue(loginPage.getResetPasswordUrl().contains("requestPasswordResetCode"));
    }

}
