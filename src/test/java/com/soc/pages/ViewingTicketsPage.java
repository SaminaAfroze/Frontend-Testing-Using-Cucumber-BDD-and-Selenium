package com.soc.pages;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.soc.utils.CommonPageMethods;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewingTicketsPage extends CommonPageMethods {

    @FindBy(how = How.XPATH, using = "//div[@id='main_panes']/section/div[@class='ember-view pane right section']/div[@class='ember-view']/div[2]/div[@class='ember-view']//div[@role='grid']/div/table//a[@href='tickets/20']/span")
    public WebElement ticketClicked;

    @FindBy(how = How.CSS, using = "g > rect:nth-of-type(8)")
    public WebElement appsclicked;

    @FindBy(how = How.XPATH, using = "/html//button[@id='btnConfirm']")
    public WebElement confirmClicked;

    // Add appropriate ID for the sidebar
    private final String popupId = "/html//app-root//app-chat-soc/app-modal-pop-up[@class='ng-star-inserted']/div//div[@class='sm:flex sm:items-start']/div[2]";

    // Add iframe ID
    private final String iframeId = "app_SOC-chat_ticket_sidebar_9621068d-5f43-4e5f-b39c-15c80daf9211";

    WebDriver webDriver;

    public ViewingTicketsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void clickTicketClicked() {
        ticketClicked.click();
    }

    public void appsclicked() {
        appsclicked.click();
    }

    public void confrimbuttonclick() {
        // Switch to the iframe
        WebElement iframe = webDriver.findElement(By.xpath("//iframe[contains(@name, 'app_SOC-chef_ticket_sidebar')]"));

        // Switch to the iframe
        webDriver.switchTo().frame(iframe);

        // Click the confirm button
        confirmClicked.click();

        // Switch back to the main content
        webDriver.switchTo().defaultContent();
    }

    public boolean ispopupDisplayed() {
        try {
            WebElement popup = webDriver.findElement(By.xpath(popupId));
            return popup.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyPopUpPayload() {
        try {
            // Find the pop-up element
            WebElement popUp = webDriver.findElement(By.xpath("//app-modal-pop-up//p"));

            // Get the text content of the pop-up
            String popUpText = popUp.getText();

            // Define the expected JSON payload
            String expectedPayload = "{ \"name\": \"My bot_2.22.11.16.15.37.33.admin\", \"fileId\": 21533, \"status\": \"ACTIVE\", \"description\": \"Schedule automation to run email bot.\", \"rdpEnabled\": true, \"scheduleType\": \"NONE\", \"botInput\": { \"iStrKitchenType\": { \"type\": \"STRING\", \"string\": \"Close\" }, \"iLstKitchenLocation\": { \"type\": \"LIST\", \"list\": [ { \"type\": \"STRING\", \"string\": \"slp\" } ] } }, \"timeZone\": \"PST\", \"startDate\": \"2024-02-29\", \"startTime\": \"18:00:00\", \"runAsUserIds\": [ 339 ], \"workspaceName\": \"public\", \"overrideDefaultDevice\": false, \"numOfRunAsUsersToUse\": 1, \"runElevated\": true, \"automationPriority\": \"PRIORITY_MEDIUM\" }";

            // Compare the actual text with the expected payload
            boolean isPayloadMatched = popUpText.equals(expectedPayload);

            // Return true if the payload matches the expected JSON, false otherwise
            return isPayloadMatched;
        } catch (NoSuchElementException e) {
            // If the pop-up element is not found, fail the test
            Assert.fail("Pop-up element is not found");
            return false;
        }
    }



}