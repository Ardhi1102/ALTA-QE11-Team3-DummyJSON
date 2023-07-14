Feature: Delete comment
  @Tugas #Positive Case
  Scenario Outline: Delete comment with valid id
    Given Delete comment with valid id <id>
    When Send request delete comment with valid id
    Then Status code should be 200 OK
    And Validate delete comment json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas #Negative Case
  Scenario Outline: Delete comment with invalid id
    Given Delete comment with invalid id "<id>"
    When Send request delete comment with invalid id
    Then Status code should be 400 Bad Request
    Examples:
      | id          |
      | sibolang123 |
      | cicak&8     |