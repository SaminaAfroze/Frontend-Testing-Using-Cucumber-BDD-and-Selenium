package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.EditKitchenConversationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.soc.pages.EditKitchenConversationPage.WAIT_TIMEOUT_SECONDS;

public class EditKitchenConversationSteps extends AutomationBase {

    EditKitchenConversationPage kitchenClosurePage = new EditKitchenConversationPage(openDriver());
    String text;

    @Given("the user wants to extract kitchen name")
    public void the_user_wants_to_extract_kitchen_name() {
        text = kitchenClosurePage.extractKitchenName();
        System.out.println("Extracted Kitchen Name: " + text);
    }

    @When("the user clicks on the edit button")
    public void the_user_clicks_on_the_edit_button() {
        kitchenClosurePage.clickEditButton();
    }

    @And("the user edits the kitchen closure conversation name")
    public void the_user_edits_the_kitchen_closure_conversation_name() {
        String newKitchenName = "GO";
        kitchenClosurePage.editKitchenClosureName(newKitchenName);
    }

    @And("the user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() {
        kitchenClosurePage.clickSubmitButton();
    }

    @Then("the user should view the corrected kitchen closure conversation name")
    public void the_user_should_view_the_corrected_kitchen_closure_conversation_name() {
        String expectedKitchenName = "Roti";

        kitchenClosurePage.verifyKitchenClosureConversationName(expectedKitchenName);
    }

    @When("the user edits the kitchen Location")
    public void the_user_edits_the_kitchen_location() {
        String newKitchenLocation = "un";
        kitchenClosurePage.editKitchenClosureLocation(newKitchenLocation);
    }
    @Then("the user should view the corrected kitchen Location")
    public void the_user_should_view_the_corrected_kitchen_location() {
        String expectedKitchenLocation = "UNKNOWN LOCATION";

        kitchenClosurePage.verifyKitchenClosureConversationLocation(expectedKitchenLocation);
    }
}
