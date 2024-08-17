Feature: Automate intent activation and deactivation

  Scenario: Toggle the last intent activation status
    Given the user navigates to the Intent List Page
    When user clicks on the toggle button of the last intent
    Then the activation status of the last intent should be toggled
