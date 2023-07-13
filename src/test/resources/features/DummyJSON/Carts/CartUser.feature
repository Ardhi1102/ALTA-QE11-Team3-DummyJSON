Feature: Cart User
  @Tugas #Positif Case
  Scenario Outline: Get cart user with valid parameter id
    Given Get cart user with valid parameter id <id>
    When Send request get cart user with valid parameter id
    Then Status code should be 200 OK
    And Validate get cart user JSON schema
    Examples:
      | id |
      | 30 |
      | 52  |

  @Tugas #Negatif Case
  Scenario Outline: Get cart user with invalid parameter id
    Given Get cart user with invalid parameter "<id>"
    When Send request get cart user with invalid parameter id
    Then Status code should be 400 Bad Request
    Examples:
      | id         |
      | syalala123 |
      | balonku5   |

  @Tugas #Negatif Case
  Scenario Outline: Get cart user with exceed parameter id
    Given Get cart user with exceed parameter id <id>
    When Send request get cart user with exceed parameter id
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 48 |
      | 10  |
