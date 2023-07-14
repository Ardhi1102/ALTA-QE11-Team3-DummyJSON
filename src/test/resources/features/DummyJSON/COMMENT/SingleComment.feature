Feature: Single comment
  @Tugas #Positive Case
  Scenario Outline: Get single comment with valid parameter id
    Given Get single comment with valid parameter id <id>
    When Send request get single comment with valid parameter id
    Then Status code should be 200 OK
    And Validate get single comment valid parameter json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas #Negative Case
  Scenario Outline: Get single comment with invalid parameter id
    Given Get single comment with invalid parameter id "<id>"
    When Send request get single comment with invalid parameter id
    Then Status code should be 400 Bad Request
    Examples:
      | id            |
      | sibolang34    |
      | 4naklayang123 |

  @Tugas #Negative Case
  Scenario Outline: Get single comment with exceed parameter id
    Given Get single comment with exceed parameter id <id>
    When Send request get single comment with exceed parameter id
    Then Status code should be 404 Not Found
    And Validate get single comment exceed parameter json schema
    Examples:
      | id  |
      | 400 |
      | 450 |