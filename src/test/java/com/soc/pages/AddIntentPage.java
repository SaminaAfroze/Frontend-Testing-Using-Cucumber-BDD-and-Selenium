package com.soc.pages;

import com.soc.utils.CommonPageMethods;
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
import java.util.Map;

public class AddIntentPage extends CommonPageMethods {

    // Add appropriate ID for the submit button
    private final String submitButtonId = "submit-button";
    WebDriver webDriver;
    @FindBy(how = How.XPATH, using = "//app-root//app-create-intent-type[@class='ng-star-inserted']//form/nz-form-item[7]/nz-form-label[2]//button[@class='ant-btn']") // ID for the final submit button after password input
    public WebElement addButton;
    @FindBy(how = How.ID, using = "eName") // ID for the final submit button after password input
    public WebElement entityNameField;

    @FindBy(how = How.ID, using = "des") // ID for the final submit button after password input
    public WebElement descriptionField;

    @FindBy(how = How.XPATH, using = "/html//app-root//app-create-intent-type[@class='ng-star-inserted']/div/form/nz-form-item[7]/nz-form-control//table/tbody/tr[@class='ng-star-inserted']/td[3]/button[1]") // ID for the final submit button after password input
    public WebElement saveButton;

    @FindBy(how = How.ID, using = "createSubmit") // ID for the final submit button after password input
    public WebElement submitButton;

    @FindBy(how = How.XPATH,using = "/html//div[@id='cdk-overlay-7']/nz-notification-container//nz-notification//div[@class='ant-notification-notice-message ng-tns-c1740797134-220']")
    public WebElement successMessage;

    @FindBy(how = How.XPATH,using = "/html//app-root//app-create-intent-type[@class='ng-star-inserted']//form/nz-form-item[1]/nz-form-control//label[.=' Please enter the intent name']")
    public WebElement intentNameErrorMessage;

    @FindBy(how = How.XPATH, using = "/html//app-root//app-create-intent-type[@class='ng-star-inserted']//form/nz-form-item[1]/nz-form-control//label[.=' Please enter the intent name']")
    public WebElement errorMessage;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-notification-notice') and contains(@class, 'ant-notification-notice-closable')]//span[contains(@class, 'ant-notification-notice-close-x')]")
    public WebElement popupClose;

    public AddIntentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void fillFormFields(List<Map<String, String>> fieldDetails) {
        for (Map<String, String> fieldDetail : fieldDetails) {
            String fieldName = fieldDetail.get("Field");
            String fieldId = fieldDetail.get("ID");
            String value = fieldDetail.get("Value");
            WebElement field = webDriver.findElement(By.id(fieldId));
            field.clear();  // Clear any existing value in the field
            field.sendKeys(value);  // Fill the field with the provided value
        }
    }


    public void clickAddEntity() {
        addButton.click();
    }

    public void addEntities(List<Map<String, String>> entities) {
        for (Map<String, String> entity : entities) {
            String entityName = entity.get("Entity Name");
            String description = entity.get("Description");
            entityNameField.clear();
            entityNameField.sendKeys(entityName);
            descriptionField.clear();
            descriptionField.sendKeys(description);
            // Add code to click on the "Add" button or perform any other action to add the entity
        }
    }

    public void clickSaveButton() {

        saveButton.click();
    }

    public void closePopUp() {
        // Explicit wait to ensure the popup is present and the close button is clickable
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(popupClose));
        closeButton.click();
    }
    public void clickSubmitButton() {

        submitButton.click();
    }


    public void verifyRedirectionToLandingPage(String expectedUrl) {

        // Verify the current URL
        String actualUrl = webDriver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("The user was not redirected to the landing page. Expected: "
                    + expectedUrl + ", but got: " + actualUrl);
        }

        // Close the browser after verification
        webDriver.quit();
    }
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isIntentNameErrorMessageDisplayed() {
        return intentNameErrorMessage.isDisplayed();
    }
}
