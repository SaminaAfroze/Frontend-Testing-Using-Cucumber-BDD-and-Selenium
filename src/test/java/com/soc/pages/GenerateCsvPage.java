package com.soc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenerateCsvPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GenerateCsvPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locate the CSV generating button
    @FindBy(how = How.XPATH, using = "/html//app-root//app-list-intent-type//button[2]")
    public WebElement generateCsvButton;

    public void clickGenerateCsvButton() {

        generateCsvButton.click();
    }
}
