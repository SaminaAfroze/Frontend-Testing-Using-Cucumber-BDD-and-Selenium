package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.IntentListPage;
import com.soc.utils.Launcher;
import com.soc.utils.SmartWait;
import com.soc.utils.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class IntentListSteps extends AutomationBase {

    Launcher launcher = new Launcher(openDriver());
    IntentListPage intentListPage = new IntentListPage(openDriver());
    SmartWait smartWait = new SmartWait();

    List<Object[]> listData;

    public IntentListSteps(TestContext context) {
        testContext = context;
    }

    @When("the user navigates to the Intent List Page")
    public void the_user_navigates_to_the_Intent_List_Page() throws InterruptedException {
        System.out.println("Running internal login steps");
        launcher.navigateToIntentList();
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(9000);
    }

    @When("user fetch the data from the list")
    public void user_fetch_the_data_from_the_list() {
        listData = intentListPage.fetchData(); // Assign the fetched data to the listData variable
        smartWait.actionDelay(10000);
        smartWait.waitUntilPageIsLoaded(8000);
    }

    @Then("the data in the list should match the predefined dataset")
    public void the_data_in_the_list_should_match_the_predefined_dataset() {
        // Validate the fetched data against the predefined dataset
        intentListPage.validateData(listData);
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(6000);
    }

    @When("the user clicks on remove")
    public void the_user_clicks_on_remove() {

        intentListPage.clickOnRemove();
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(6000);
    }

    @Then("the item gets removed")
    public void the_item_gets_removed() {
        String[] itemData = {"356", "test00130", "this intent deals with messages related to test00130", "Troubleshooting LLMs"};
        boolean isRemoved = intentListPage.isItemRemoved(itemData);
        Assert.assertTrue("Item is not removed", isRemoved);
        smartWait.actionDelay(8000);
        smartWait.waitUntilPageIsLoaded(6000);
    }
}
