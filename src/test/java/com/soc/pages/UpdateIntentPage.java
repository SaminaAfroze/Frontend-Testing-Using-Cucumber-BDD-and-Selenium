package com.soc.pages;
import com.soc.utils.CommonPageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UpdateIntentPage extends CommonPageMethods {

    WebDriver webDriver;
    @FindBy(how = How.XPATH, using = "//app-root//app-update-intent-type[@class='ng-star-inserted']//form/nz-form-item[8]/nz-form-label[2]//span[@class='ng-star-inserted']")
    public WebElement addUpdate;

    @FindBy(how = How.ID, using = "/html//app-root//app-update-intent-type[@class='ng-star-inserted']//form/nz-form-item[8]/nz-form-control//table/tbody/tr[1]/td[3]/button[1]/span[@class='ng-star-inserted']")
    public WebElement saveupdate;
    @FindBy(how = How.XPATH, using = "/html//app-root//app-update-intent-type[@class='ng-star-inserted']/div/form/nz-form-item[8]/nz-form-control//table/tbody/tr[1]/td[3]/div[@class='flex items-center']/button")
    public WebElement removeUpdate;

    @FindBy(how = How.XPATH, using = "//nz-radio-group[@id='rdoLLMType']//span[.='Troubleshooting LLMs']")
    public WebElement radioTroubleshooting;

    @FindBy(how = How.XPATH, using = "//nz-radio-group[@id='rdoLLMType']/label[1]//input[@type='radio']")
    public WebElement radioIntentleshooting;
    @FindBy(how = How.ID, using = "updateSubmit")
    public WebElement submitButtonUpdate;


    @FindBy(how = How.XPATH, using = "/html//div[@id='cdk-overlay-0']/nz-notification-container//nz-notification//div[@class='ant-notification-notice-message ng-tns-c1740797134-10']")
    public WebElement successUpdate;

    @FindBy(how = How.XPATH, using = "/html//app-root//app-update-intent-type[@class='ng-star-inserted']//form/nz-form-item[@class='ant-form-item ant-row ng-star-inserted']/nz-form-control//label[.=' Please enter a Zendesk URL ']")
    public WebElement errorT;

    @FindBy(how = How.XPATH, using = "/html//app-root//app-update-intent-type[@class='ng-star-inserted']//form/nz-form-item[6]/nz-form-control//label[.=' Recipe only allow link such as http:// or https:// ']")
    public WebElement errorRecipe;

    @FindBy(how = How.XPATH, using = "/html//app-root//app-update-intent-type[@class='ng-star-inserted']//form/nz-form-item[6]/nz-form-control//label[.=' Please enter recipe articles Ids ']")
    public WebElement articleIDsError;

    public UpdateIntentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddEntityofUpdate() {
        addUpdate.click();
    }
    public void clickSaveButtonupdate() {

        saveupdate.click();
    }
    public void clickSubmitButtonupdate() {

        submitButtonUpdate.click();
    }

    public void clickTroubleshootingLLMs() {

        radioTroubleshooting.click();
    }

    public void clickIntentLLMs() {

        radioIntentleshooting.click();
    }



    public void clickRemove() {

        removeUpdate.click();
    }
    public boolean isUpdateSuccessMessageDisplayed() {
        return successUpdate.isDisplayed();
    }

    public boolean isRelevantErrorMessageDisplayed() {
        return errorT.isDisplayed();
    }


    public boolean isArticleIdsError() {
        return articleIDsError.isDisplayed();
    }


//    public boolean isErrorMessageDisplayed() {
//        return errorMessage.isDisplayed();
//    }
//}

}
