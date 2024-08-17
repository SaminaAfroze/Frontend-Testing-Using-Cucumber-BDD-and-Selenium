package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.AddIntentPage;
import com.soc.pages.UpdateIntentPage;
import com.soc.utils.Launcher;
import com.soc.utils.SmartWait;
import com.soc.utils.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class UpdateIntentSteps extends AutomationBase {


            Launcher launcher = new Launcher(openDriver());

            UpdateIntentPage updateIntentPage = new UpdateIntentPage(openDriver());
            SmartWait smartWait = new SmartWait();


            public UpdateIntentSteps(TestContext context) {
                testContext = context;
            }



            @When("the user navigates to the Update Intent Page")
            public void the_user_navigates_to_the_Update_Intent_page() throws InterruptedException {
                System.out.println("Running internal login steps");
                launcher.navigateToUpdateAdminUI();
                smartWait.actionDelay(8000);
                smartWait.waitUntilPageIsLoaded(5000);

            }

    @When("the user clicks on Add of the entity table of update")
    public void the_user_clicks_on_add_of_the_entity_table_of_update() {
                updateIntentPage.clickAddEntityofUpdate();
                smartWait.actionDelay(8000);
                smartWait.waitUntilPageIsLoaded(5000);
    }


    @When("user clicks on Troubleshooting LLMs")
    public void user_clicks_on_Troubleshooting_LLMs() {
        updateIntentPage.clickTroubleshootingLLMs();
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }

    @When("user clicks on Intent LLMs")
    public void user_clicks_on_Intent_LLMs() {
        updateIntentPage.clickIntentLLMs();
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }
    @When("the user removes one entity")
    public void the_user_removes_one_entity() {
        updateIntentPage.clickRemove();
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }

    @When("the user clicks on save of update")
    public void the_user_clicks_on_save_of_update() {
        updateIntentPage.clickSaveButtonupdate();
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }

    @When("the user submits the form of update")
    public void the_user_submits_the_form_of_update() {
        updateIntentPage.clickSubmitButtonupdate();

        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);

    }

    @Then("the user should see a success message in update")
    public void the_user_should_see_a_success_message_in_update() {

        assertTrue(updateIntentPage.isUpdateSuccessMessageDisplayed());
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }

    @Then("the user should see a relevant error message for entering zendesk url")
    public void the_user_should_see_a_relevant_error_message_for_entering_zendesk_url() {

        assertTrue(updateIntentPage.isRelevantErrorMessageDisplayed());
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }

    @Then("the user should see an error message for recipe")
    public void the_user_should_see_an_error_message_for_recipe () {

        assertTrue(updateIntentPage.isArticleIdsError());
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }
    @Then("the user should see an error message for Article IDs")
    public void the_user_should_see_an_error_message_for_Article_IDs() {

        assertTrue(updateIntentPage.isUpdateSuccessMessageDisplayed());
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(5000);
    }
}


