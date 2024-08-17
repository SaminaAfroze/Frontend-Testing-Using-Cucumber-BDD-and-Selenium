@atest
Feature: Edit Kitchen closure conversation

  Background:
    Given user logged in SocUI with "IM" credentials
     And the user clicks on app

  @positive @sanity
  Scenario: Edit Kitchen Name
    When the user clicks on the edit button
    And the user edits the kitchen closure conversation name
    And the user clicks on the submit button
    Then the user should view the corrected kitchen closure conversation name

  @positive @sanity
  Scenario: Edit Kitchen Location
    When the user clicks on the edit button
    And the user edits the kitchen Location
    And the user clicks on the submit button
    Then the user should view the corrected kitchen Location