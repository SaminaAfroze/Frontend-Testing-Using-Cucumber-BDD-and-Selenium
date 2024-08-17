Feature: List Page Data Validation

  Scenario: Validate data in the list page
    Given the user navigates to the Intent List Page
    When user fetch the data from the list
    Then the data in the list should match the predefined dataset

#  Scenario: Validate remove in the list page
#    Given the user navigates to the Intent List Page
#    When the user clicks on remove
#    Then the item gets removed
