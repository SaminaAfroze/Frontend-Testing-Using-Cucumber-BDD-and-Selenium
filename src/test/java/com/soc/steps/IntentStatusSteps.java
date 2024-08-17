package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.AddIntentPage;
import com.soc.pages.IntentStatusPage;
import com.soc.utils.SmartWait;
import com.soc.utils.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class IntentStatusSteps extends AutomationBase {

    WebDriver driver;


    IntentStatusPage intentStatusPage = new IntentStatusPage(openDriver());
    SmartWait smartWait = new SmartWait();

    public IntentStatusSteps(TestContext context) {
        testContext = context;
    }


    @When("user clicks on the toggle button of the last intent")
    public void user_clicks_on_the_toggle_button_of_the_last_intent() {
        intentStatusPage.clickToggleButtonOfLastIntent();
        smartWait.actionDelay(7000);
        smartWait.waitUntilPageIsLoaded(5000);
    }

    @Then("the activation status of the last intent should be toggled")
    public void the_activation_status_of_the_last_intent_should_be_toggled() {
        // Get initial state
        boolean initialState = intentStatusPage.isLastIntentActive();

        // Toggle the state
        intentStatusPage.clickToggleButtonOfLastIntent();

        // Wait for the state to change
        boolean toggledState = intentStatusPage.isLastIntentActive();

        // Assert the state has changed
        Assert.assertNotEquals("The activation status should be toggled", initialState, toggledState);
    }
}
