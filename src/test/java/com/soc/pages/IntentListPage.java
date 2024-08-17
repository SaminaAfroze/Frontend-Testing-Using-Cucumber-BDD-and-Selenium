package com.soc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.*;
import java.util.stream.Collectors;

public class IntentListPage {

    private WebDriver driver;

    public IntentListPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(how = How.XPATH, using = "/html//app-root//app-list-intent-type/div[2]/table/tbody/tr[1]/td[5]")
    public WebElement deleteParentTd;

    @FindBy(how = How.CSS, using = "tr:nth-of-type(1) > td:nth-of-type(5) > button:nth-of-type(2)")
    public WebElement delete;

    @FindBy(how = How.XPATH, using = "/html//div[@id='cdk-overlay-1']/div[2]//div[@class='ng-tns-c3246172650-19']/div/div[2]/button[2]/span[@class='ng-star-inserted']")
    public WebElement ok;


    public List<Object[]> fetchData() {
        List<Object[]> listData = new ArrayList<>();
        List<WebElement> rows = driver.findElements(By.cssSelector("tr.bg-white.border-b.ng-star-inserted"));

        // Log the number of rows found
        System.out.println("Number of rows found: " + rows.size());

        // Extract data from list elements
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td")); // Assuming data is in <td> elements

            try {
                // Extract data only if we have enough columns
                if (columns.size() >= 4) {
                    // Add the row data to listData
                    Object[] rowData = new Object[] {
                            columns.get(0).getText(),
                            columns.get(1).getText(),
                            columns.get(2).getText(),
                            columns.get(3).getText()
                    };
                    listData.add(rowData);
                } else {
                    System.err.println("Skipping row with insufficient columns: " + columns.size());
                }
            } catch (Exception e) {
                System.err.println("Error extracting data from row: " + e.getMessage());
            }
        }

        return listData;
    }

    public void validateData(List<Object[]> listData) {
        // Compare the fetched data with the predefined dataset
        boolean dataMatches = true;

        // Check if the number of rows fetched matches the predefined data length
        if (listData.size() != predefinedData.length) {
            dataMatches = false;
            throw new AssertionError("Number of rows fetched does not match predefined data.");
        } else {
            // If the number of rows matches, compare each row data
            for (int i = 0; i < listData.size(); i++) {
                Object[] rowData = listData.get(i);
                Object[] predefinedRowData = predefinedData[i];

                // Check if each element of the row matches
                for (int j = 0; j < rowData.length; j++) {
                    if (!Objects.equals(rowData[j], predefinedRowData[j])) {
                        dataMatches = false;
                        throw new AssertionError("Row data does not match predefined data at index: " + i);
                    }
                }
            }
        }

        // If data does not match, fail the test case
        if (!dataMatches) {
            throw new AssertionError("Data does not match predefined dataset.");
        }
    }




    // Predefined data array
    public static Object[][] predefinedData = {

            {"502", "toast_printer_down", "This intent is about any type of printer related issues in restaurants", "Troubleshooting LLMs", "true"},
            {"507", "network_alert", "This intent is about any wifi network related issues for restaurants", "Troubleshooting LLMs", "true"},
            {"787", "86", "This intent is used to identify only those request that are about deleting an item from the menu either temporarily or permanently", "Entity LLMs", "true"},
            {"817", "pause_online_ordering", "This intent is used to identify only those requests that are about closing a kitchen for some time.", "Entity LLMs", "true"},
            {"828", "twestuh11", "This is of printers001", "Entity LLMs", "false"}



    };

    public void clickOnRemove() {
        // Click on the parent <td> element to reveal the delete button
//        deleteParentTd.click();

        // Click on the delete button
        delete.click();

        // Optionally, you can add a wait here to ensure the delete action completes
        // before clicking on the "OK" button.

        // Click on the "OK" button
        ok.click();
    }

    public boolean isItemRemoved(String[] itemData) {
        // Fetch the updated list of items after clicking on remove
        List<Object[]> updatedListData = fetchData();

        // Check if the item is present in the updated list data
        for (Object[] rowData : updatedListData) {
            // Check if each element of the row matches the item data
            boolean matches = true;
            for (int i = 0; i < rowData.length; i++) {
                if (!Objects.equals(rowData[i], itemData[i])) {
                    matches = false;
                    break;
                }
            }
            // If all elements match, the item is still present, so return false
            if (matches) {
                return false;
            }
        }
        // If the item is not found in the updated list data, it has been removed
        return true;
    }


}
