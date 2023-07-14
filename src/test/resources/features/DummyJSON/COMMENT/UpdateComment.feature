Feature: Update comment
  @Tugas #Positive Case
  Scenario Outline: Update comment with valid json
    Given Post update comment with valid json and valid id <id>
    When Send request post update comment with valid json
    Then Status code should be 200 OK
    And Validate update comment valid json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  Scenario Outline: Update comment with invalid id
    Given Post update comment with valid json and invalid id "<id>"
    When Send request post update comment with invalid json
    Then Status code should be 400 Bad Request
    Examples:
      | id          |
      | sibolang123 |
      | cicak$10    |