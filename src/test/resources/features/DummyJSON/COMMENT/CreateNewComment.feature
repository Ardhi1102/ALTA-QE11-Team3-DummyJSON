Feature: Create New Comment
  @Tugas #Positive Case
  Scenario: Post create new comment with valid json
    Given Post create new comment with valid json
    When Send request post create new comment with valid json
    Then Status code should be 200 OK
    And Validate post create comment success json schema

  @Tugas #Negative Case
  Scenario: Post create new comment with invalid json
    Given Post create new comment with invalid json
    When Send request post create new comment with invalid json
    Then Status code should be 400 Bad Request
    And Validate post create comment unsuccess json schema
