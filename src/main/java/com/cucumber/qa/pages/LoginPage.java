package com.cucumber.qa.pages;

import static Utils.SeleniumUtils.*;

import constants.StringConstrants;
import org.openqa.selenium.By;

public class LoginPage {
    private final By TXTBOX_USERNAME = By.name("username");
    private final By TXTBOX_PASSWORD = By.xpath("//input[@type = 'password']");
    private final By BTN_LOGIN = By.xpath("//button[@type = 'submit']");
    private final By LOGIN_TEXT = By.xpath("//h5[text()='Login']");
    private final By INVALID_CREDENTIAL = By.xpath("//p[text() = 'Invalid credentials']");
    private final By FORGOT_PASSWORD = By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']");
    private final By HOMEPAGE_TITLE = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    private LoginPage setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username);
        return this;
    }
    private LoginPage setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password);
        return this;
    }
    public String getHomePageTitle(){
        return getTitle(HOMEPAGE_TITLE);
    }
    private void setLogin() {
        click(BTN_LOGIN, StringConstrants.PRESENT);
    }
    public void clickLogin() {
        click(BTN_LOGIN, StringConstrants.CLICKABLE);
    }
    public void clickForgotPassword() {
        click(FORGOT_PASSWORD, StringConstrants.CLICKABLE);
    }
    public String getInvalidCredentialMessage(){
        return getTitle(INVALID_CREDENTIAL);
    }
    public void logintoApplication(String username, String password) {
            setUsername(username)
                .setPassword(password);
    }
    public void validateResetPassword(){
         clickForgotPassword();
    }
    public String getResetPasswordUrl(){
        return getCurrentUrl();
    }
}
