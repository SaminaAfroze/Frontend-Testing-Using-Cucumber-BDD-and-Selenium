package com.soc.pages;

import com.soc.utils.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonPageMethods {

    @FindBy(how = How.ID, using = "user_email")
    public WebElement txtUsername;

    @FindBy(how = How.ID, using = "user_password")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "sign-in-submit-button")
    public WebElement btnLogin;

    @FindBy(how = How.ID, using = "pendo-close-guide-3e3a5ca8") // ID for the close warning button
    public WebElement btnCloseWarning;

    @FindBy(how = How.ID, using = "sign-in-submit-button") // ID for the final submit button after password input
    public WebElement btnSubmitFinal;

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void typeUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void typePassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void clickSignInButton() {
        btnSubmitFinal.click(); // Assuming btnSubmitFinal is the sign-in button after typing password
    }

    public void closeWarning() {
        btnCloseWarning.click();
    }
}
