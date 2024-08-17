package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.LoginPage;
import com.soc.utils.Launcher;
import com.soc.utils.SmartWait;
import io.cucumber.java.en.Given;

public class LoginPageSteps extends AutomationBase {

    Launcher launcher = new Launcher(openDriver());
    LoginPage loginPage = new LoginPage(openDriver());
    SmartWait smartWait = new SmartWait();

    @Given("user logged in SocUI with {string} credentials")
    public void userLoggedInSocUIWithCredentials(String arg0) throws InterruptedException {
        String username = "info@hydrusdigitalbd.com"; // Correct username
        String password = "Hydrus2024!!"; // Correct password

        System.out.println("Running internal login steps");
        launcher.navigateToZendeskApplication();;
        loginPage.typeUsername(username);
        loginPage.clickLoginButton();
        loginPage.typePassword(password);
        loginPage.clickSignInButton();
        smartWait.actionDelay(5000);
        smartWait.waitUntilPageIsLoaded(3000);

        try {
            loginPage.closeWarning();
        } catch (Exception e) {
            System.out.println("No warning");
        }
    }

    // Other methods remain unchanged
}
