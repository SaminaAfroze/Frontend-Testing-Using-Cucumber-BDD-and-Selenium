package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.pages.GenerateCsvPage;
import com.soc.utils.SmartWait;
import com.soc.utils.context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenerateCsvSteps extends AutomationBase {
    WebDriver driver;

    GenerateCsvPage generateCsvPage = new GenerateCsvPage(openDriver());
    SmartWait smartWait = new SmartWait();

    public GenerateCsvSteps(TestContext context) {
        testContext = context;
    }

    @When("user clicks on the csv generating button")
    public void user_clicks_on_the_csv_generating_button() {
        generateCsvPage.clickGenerateCsvButton();
    }

    @Then("the csv file gets generated")
    public void the_csv_file_gets_generated() {
        String downloadDir = System.getProperty("user.home") + "/Downloads";
        String expectedFileName = "intent-training.csv";

        Path filePath = Paths.get(downloadDir, expectedFileName);
        boolean fileExists = waitForFile(filePath, 30);

        Assert.assertTrue("The CSV file should be generated", fileExists);
    }

    private boolean waitForFile(Path filePath, int timeoutInSeconds) {
        int waited = 0;
        while (waited < timeoutInSeconds) {
            if (Files.exists(filePath)) {
                return true;
            }
            try {
                Thread.sleep(1000);
                waited++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
