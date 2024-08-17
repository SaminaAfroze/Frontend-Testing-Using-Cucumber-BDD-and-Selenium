package com.soc.pages;

import com.soc.utils.CommonPageMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class EditKitchenConversationPage extends CommonPageMethods {
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    WebDriver webDriver;

    @FindBy(how = How.ID, using = "btnEdit")
    public WebElement btnEdit;

    @FindBy(how = How.ID, using = "txtEditMessage")
    public WebElement txtKitchenName;

    @FindBy(how = How.ID, using = "btnConfirm")
    public WebElement btnConfirm;

    private final String iframeId = "app_SOC-chef_ticket_sidebar_7b56b30c-61cb-4314-aa18-694d19127755";

    public EditKitchenConversationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void switchToIframe() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@name, 'app_SOC-chef_ticket_sidebar')]")));
    }

    public void clickEditButton() {
        switchToIframe();
        btnEdit.click();
    }

    public void editKitchenClosureName(String newKitchenName) {
        //switchToIframe();

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        WebElement txtKitchenName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditMessage")));

        // Edit the kitchen closure name
        String currentText = txtKitchenName.getAttribute("value");
        String[] lines = currentText.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("NAME:")) {
                lines[i] = "NAME: " + newKitchenName;
                break;
            }
        }

        String updatedText = String.join("\n", lines);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value = arguments[1];", txtKitchenName, updatedText);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String extractKitchenName() {
        WebElement nameElement = webDriver.findElement(By.id("kitchenName"));
        return nameElement.getText();
    }

    public void clickSubmitButton() {
        btnConfirm.click();
    }

    public String getKitchenClosureName() {
        WebElement divElement = webDriver.findElement(By.cssSelector(".ng-star-inserted"));
        List<WebElement> liElements = divElement.findElements(By.tagName("li"));

        for (WebElement li : liElements) {
            String liText = li.getText();
            if (liText.startsWith("NAME:")) {
                // Extract the kitchen name from the "NAME" field
                return liText.substring(liText.indexOf(":") + 2).trim();
            }
        }

        return null; // Or handle the case when the name is not found
    }


    public void verifyKitchenClosureConversationName(String expectedKitchenName) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ng-star-inserted")));

        // Find the element containing the kitchen information
        WebElement kitchenInfoElement = webDriver.findElement(By.id("msgAndConfirmSection"));

        // Get all <li> elements under the <ul> element
        List<WebElement> liElements = kitchenInfoElement.findElements(By.cssSelector("ul > li"));

        // Search for the <li> element containing "NAME:"
        WebElement nameElement = null;
        for (WebElement liElement : liElements) {
            if (liElement.getText().startsWith("NAME:")) {
                nameElement = liElement;
                break;
            }
        }

        if (nameElement != null) {
            // Extract the text after "NAME:"
            String actualKitchenName = nameElement.getText().substring("NAME:".length()).trim();
            System.out.println("Expected Kitchen Name: " + expectedKitchenName); // Debug information
            System.out.println("Actual Kitchen Name: " + actualKitchenName); // Debug information

            // Verify if the actual name matches the expected name
            Assert.assertEquals("Kitchen closure conversation name does not match the expected name", expectedKitchenName, actualKitchenName);
        } else {
            // Handle case where "NAME:" element is not found
            Assert.fail("NAME: element not found in kitchen information.");
        }
    }



    public void editKitchenClosureLocation(String newKitchenLocation) {
        //switchToIframe();

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        WebElement txtKitchenLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtEditMessage")));

        // Edit the kitchen closure location
        String currentText = txtKitchenLocation.getAttribute("value");
        String[] lines = currentText.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("LOCATION:")) {
                lines[i] = "LOCATION: " + newKitchenLocation;
                break;
            }
        }

        String updatedText = String.join("\n", lines);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].value = arguments[1];", txtKitchenLocation, updatedText);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyKitchenClosureConversationLocation(String expectedKitchenLocation) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ng-star-inserted")));

        // Find the element containing the kitchen information
        WebElement kitchenInfoElement = webDriver.findElement(By.id("msgAndConfirmSection"));

        // Get all <li> elements under the <ul> element
        List<WebElement> liElements = kitchenInfoElement.findElements(By.cssSelector("ul > li"));

        // Search for the <li> element containing "LOCATION:"
        WebElement locationElement = null;
        for (WebElement liElement : liElements) {
            if (liElement.getText().startsWith("LOCATION:")) {
                locationElement = liElement;
                break;
            }
        }

        if (locationElement != null) {
            // Extract the text after "LOCATION:"
            String actualKitchenLocation = locationElement.getText().substring("LOCATION:".length()).trim();
            System.out.println("Expected Kitchen Location: " + expectedKitchenLocation); // Debug information
            System.out.println("Actual Kitchen Location: " + actualKitchenLocation); // Debug information

            // Verify if the actual location matches the expected location
            Assert.assertEquals("Kitchen closure conversation location does not match the expected location", expectedKitchenLocation, actualKitchenLocation);
        } else {
            // Handle case where "LOCATION:" element is not found
            Assert.fail("LOCATION: element not found in kitchen information.");
        }
    }


}

