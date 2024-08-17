@atest
Feature:Viewing ticket details in Zendesk

  Background:
    Given user logged in SocUI with "IM" credentials

  @positive @sanity
  Scenario: Viewing ticket details
#    When the user clicks on a ticket
    And the user clicks on app
    And user clicks on the confirm button
    Then a pop up will be shown
#   And the pop up will have the payload