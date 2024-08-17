@atest
Feature: Update Intent with necessary details
  @positive @sanity
  Scenario: Fill out the form with valid data including entities
    When the user navigates to the Update Intent Page
#    And user clicks on Troubleshooting LLMs
    When the user fills in the following details:
      | Field                    | ID           | Value                          |
      | Intent Definition        | definition    | This is of printers001  |
      | Positive Keywords        | positiveKeywords  | keyword1            |
      | Negative Keywords        | negativeKeywords  | keyword1            |
      | Positive Examples        | positiveExamples  | example1            |
      | Positive Zendesk Ticket IDs | positiveZendeskTicketIds | ticket23 |
      | Prompt          | promptField       | this is for printer related work   |

    And the user submits the form of update
#    And the user closes the success message
    Then the user should be redirected to the landing page

#  Scenario: User will keep Article IDs field empty while keeping Troubleshooting LLMs true
#    When the user navigates to the Update Intent Page
#    And user clicks on Troubleshooting LLMs
#    When the user fills in the following details:
#      | Field                    | ID           | Value                          |
#      | Intent Definition        | definition    | This is it  |
#      | Positive Keywords        | positiveKeywords  | keyword1            |
#      | Negative Keywords        | negativeKeywords  | keyword1            |
#      | Positive Examples        | positiveExamples  | example1            |
#      | Positive Zendesk Ticket IDs | positiveZendeskTicketIds | ticket23 |
#      | Prompt          | promptField       | this receipe is for printer related work   |
#
#    And the user submits the form of update
#    And the user should see an error message for Article IDs
#    Then the user should see a success message in update

  Scenario: Fill out the form with Troubleshooting LLMs true
    When the user navigates to the Update Intent Page
    And user clicks on Troubleshooting LLMs
    When the user fills in the following details:
      | Field                    | ID           | Value                          |
      | Intent Definition        | definition    | This is of printers001  |
      | Positive Keywords        | positiveKeywords  | keyword1            |
      | Negative Keywords        | negativeKeywords  | keyword1            |
      | Positive Examples        | positiveExamples  | example1            |
      | Positive Zendesk Ticket IDs | positiveZendeskTicketIds | ticket23 |
      | Prompt            | promptField       | this receipe is for printer related work|
      | Enter Recipe Article IDs | urlRecipe  | 26181287161236                            |
#    And the user clicks on Add of the entity table of update
#    And the user adds entities:
#      | Entity Name | Description |
#      | EntityNew     | DescriptionNew |
#   And the user clicks on save of update
    And the user submits the form of update
#    And the user closes the success message
    Then the user should be redirected to the landing page


#  Scenario: User will update with Troubleshooting LLMs false
#    When the user navigates to the Update Intent Page
#    When the user fills in the following details:
#      | Field                    | ID           | Value                          |
#      | Intent Definition        | definition    | This is it  |
#      | Positive Keywords        | positiveKeywords  | keyword1            |
#      | Negative Keywords        | negativeKeywords  | keyword1            |
#      | Positive Examples        | positiveExamples  | example1            |
#      | Positive Zendesk Ticket IDs | positiveZendeskTicketIds | ticket23 |
#      | Recipe                   | urlRecipe       | https://d3v-cetusdigital.zendesk.com/21   |
#      | Prompt Fields            | promptField       | this receipe is for printer related work   |
#
#    And user clicks on Intent LLMs
#    And the user submits the form of update
#    Then the user should see a success message in update