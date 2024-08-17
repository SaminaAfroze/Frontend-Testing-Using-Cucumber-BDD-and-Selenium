package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.ViewingTicketsPage;
import com.soc.utils.Launcher;
import com.soc.utils.SmartWait;
import com.soc.utils.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.assertTrue;

public class ViewingTicketSteps extends AutomationBase {

    Launcher launcher = new Launcher(openDriver());
    ViewingTicketsPage viewingTicketsPage = new ViewingTicketsPage(openDriver());
    SmartWait smartWait = new SmartWait();

    public ViewingTicketSteps(TestContext context) {
        testContext = context;
    }



    @When("the user clicks on a ticket")
    public void the_user_clicks_on_a_ticket() {
        viewingTicketsPage.clickTicketClicked();
        smartWait.waitUntilPageIsLoaded(600);
    }

    @When("the user clicks on app")
    public void the_user_clicks_on_app() {
        viewingTicketsPage.appsclicked();
        smartWait.actionDelay(60000);
        smartWait.waitUntilPageIsLoaded(60000);
    }
    @When("user clicks on the confirm button")
    public void user_clicks_on_the_confirm_button() {
        viewingTicketsPage.confrimbuttonclick();
        smartWait.actionDelay(60000);
        smartWait.waitUntilPageIsLoaded(6000);
    }
    @Then("a pop up will be shown with successful RPA call")
    public void a_pop_up_will_be_shown_with_successful_RPA_call() {
        viewingTicketsPage.ispopupDisplayed();
        smartWait.actionDelay(5000);
        smartWait.waitUntilPageIsLoaded(600);
    }

    @Then("the pop up will have the payload")
    public void the_pop_up_will_have_the_payload() {
        viewingTicketsPage.verifyPopUpPayload();
        smartWait.actionDelay(5000);
        smartWait.waitUntilPageIsLoaded(600);
    }
}
