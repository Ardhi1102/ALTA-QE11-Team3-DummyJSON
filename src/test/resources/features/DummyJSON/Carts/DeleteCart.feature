Feature: Delete Cart
  @Tugas #Positif Case
  Scenario Outline: Delete cart with valid parameter id
    Given Delete cart with valid parameter id <id>
    When Send request delete cart with valid parameter id
    Then Status code should be 200 OK
    And Validate delete cart user JSON schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas #Negatif Case
  Scenario Outline: Delete cart with invalid parameter id
    Given Delete cart with invalid parameter id "<id>"
    When Send request delete cart with invalid parameter id
    Then Status code should be 400 Bad Request
    Examples:
      | id         |
      | syalala123 |
      | ninuninu09 |

  @Tugas #Negatif Case
  Scenario: Delete cart with blank parameter id
    Given Delete cart with blank parameter id
    When Send request delete cart with blank parameter id
    Then Status code should be 400 Bad Request