package com.soc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IntentStatusPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public IntentStatusPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locating the rows of the table using XPath
    @FindBy(how = How.XPATH, using = "//app-root//app-list-intent-type//table[contains(@class, 'w-full text-sm text-left text-gray-500')]//tbody/tr")
    private List<WebElement> rows;

    // Method to click the toggle button of the last intent
    public void clickToggleButtonOfLastIntent() {
        // Get the last row
        WebElement lastRow = rows.get(rows.size() - 1);

        // Find the toggle button (either Active or Inactive) in the last row
        WebElement toggleButton = lastRow.findElement(By.xpath(".//button[contains(text(), 'Active') or contains(text(), 'Inactive')]"));

        // Click the toggle button
        toggleButton.click();

        // Wait for the toggle button text to change
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(toggleButton, toggleButton.getText())));
    }

    // Method to check if the last intent is active
    public boolean isLastIntentActive() {
        // Get the last row
        WebElement lastRow = rows.get(rows.size() - 1);

        // Find the toggle button (either Active or Inactive) in the last row
        WebElement toggleButton = lastRow.findElement(By.xpath(".//button[contains(text(), 'Active') or contains(text(), 'Inactive')]"));

        // Log the button text for debugging
        System.out.println("Toggle Button Text: " + toggleButton.getText());

        // Return true if the button text is "Active", otherwise false
        return toggleButton.getText().equals("Active");
    }
}
