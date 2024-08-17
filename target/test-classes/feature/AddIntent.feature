@atest
Feature: Add Intent with Entities
  @positive @sanity
  Scenario: Fill out the form with valid data including entities
    When the user navigates to the Intent form page
    When the user fills in the following details:
      | Field                    | ID           | Value                          |
      | Intent Name              | name   | test Intent          |
      | Intent Definition        | definition    | sThis is of test001  |
      | Positive Keywords        | positiveKeywords  | keyword1            |
      | Negative Keywords        | negativeKeywords  | keyword1            |
      | Positive Examples        | positiveExamples  | example1            |
      | Positive Zendesk Ticket IDs | positiveZendeskTicketIds | ticket23 |
      | Prompt Fields            | promptField       | this receipe is for printer related work   |

#    And the user clicks on Add of the entity table
#    And the user adds entities:
#      | Entity Name | Description |
#      | Entity1     | Description1 |
#    And the user clicks on save
    And the user submits the form
#    And the user closes the success message
    Then the user should be redirected to the landing page

   Scenario: Fill out the form with mandatory fields only
    When the user navigates to the Intent form page
    When the user fills in the following details:
      | Field                    | ID           | Value                          |
      | Intent Name              | name   | test10999             |
      | Intent Definition        | definition    | This is of snetworks11  |
     And the user submits the form
#     And the user closes the success message
     Then the user should be redirected to the landing page

  Scenario: Fill out the form without filling mandatory fields
    When the user navigates to the Intent form page
    When the user fills in the following details:
      | Field                    | ID           | Value                          |
      | Intent Definition        | definition    | This is of snetworks11  |
    And the user submits the form
    Then the user should see an error message

#  Scenario: Fill out the form with existing intent name
#    When the user navigates to the Intent form page
#    When the user fills in the following details:
#      | Field                    | ID           | Value                          |
#      | Intent Name              | name   |      pause_online_ordering     |
#      | Intent Definition        | definition    | This is an example of ExampleIntent1  |
#      | Positive Keywords        | positiveKeywords  | keyword1            |
#      | Positive Examples        | positiveExamples  | example1            |
#      | Positive Zendesk Ticket IDs | positiveZendeskTicketIds | ticket123  |
#      | Recipe                   | recipe       | ExampleRecipe1   |
##    And the user clicks on Add of the entity table
##    And the user adds entities:
##      | Entity Name | Description |
##      | Entity1     | Description1 |
##    And the user clicks on save
#    And the user submits the form
#    Then the user should see an error message