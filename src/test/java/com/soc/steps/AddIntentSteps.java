package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.AddIntentPage;
import com.soc.utils.Launcher;
import com.soc.utils.SmartWait;
import com.soc.utils.context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;


public class AddIntentSteps extends AutomationBase {

    Launcher launcher = new Launcher(openDriver());
    AddIntentPage addIntentPage = new AddIntentPage(openDriver());
    SmartWait smartWait = new SmartWait();

    public AddIntentSteps(TestContext context) {
        testContext = context;
    }



    @When("the user navigates to the Intent form page")
    public void the_user_navigates_to_the_intent_form_page() throws InterruptedException {
        System.out.println("Running internal login steps");
        launcher.navigateToAdminUI();
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);

    }
    @When("the user fills in the following details:")
    public void the_user_fills_in_the_following_details(List<Map<String, String>> fieldDetails) {
        addIntentPage.fillFormFields(fieldDetails);
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @When("the user clicks on Add of the entity table")
    public void the_user_clicks_on_add_of_the_entity_table() {
        addIntentPage.clickAddEntity();
    }

    @When("the user adds entities:")
    public void the_user_adds_entities(DataTable dataTable) {
        List<Map<String, String>> entities = dataTable.asMaps(String.class, String.class);
        addIntentPage.addEntities(entities);
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @When("the user clicks on save")
    public void the_user_clicks_on_save() {
        addIntentPage.clickSaveButton();
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        addIntentPage.clickSubmitButton();
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);

    }

    @Then("the user should see a success message")
    public void the_user_should_see_a_success_message() {

        assertTrue(addIntentPage.isSuccessMessageDisplayed());
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {

        assertTrue(addIntentPage.isErrorMessageDisplayed());
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @Then("the user should see a name not found message")
    public void the_user_should_see_a_name_not_found_message() {

        assertTrue(addIntentPage.isIntentNameErrorMessageDisplayed());
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @Then("the user closes the success message")
    public void the_user_closes_the_success_message() {

        addIntentPage.closePopUp();
    }

    @Then("the user should be redirected to the landing page")
    public void the_user_should_be_redirected_to_the_landing_page() {
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
        String expectedUrl = "https://socsidebarui.azurewebsites.net/list-intent-type";
        addIntentPage.verifyRedirectionToLandingPage(expectedUrl);

    }



}
