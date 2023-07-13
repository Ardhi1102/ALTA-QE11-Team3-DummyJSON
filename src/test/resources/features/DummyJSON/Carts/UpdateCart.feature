Feature: Update Cart

  @Tugas #Positif Case
  Scenario Outline: Update cart with valid json and valid parameter
    Given Put update cart with valid json and valid parameter id <id>
    When Send request put update cart with valid json and valid parameter
    Then Status code should be 200 OK
    And Validate update cart JSON schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas #Negative Case
  Scenario: Update cart with valid json and blank parameter
    Given Put update cart with valid json and blank parameter id
    When Send request put update cart with valid json and blank parameter
    Then Status code should be 400 Bad Request

  @Tugas #Negative Case
  Scenario Outline: Update cart with blank json and valid parameter
    Given Put update cart with blank json and valid parameter id <id>
    When Send request put update cart with blank json and valid parameter
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas #Negative Case
  Scenario Outline: Update cart with additional request body made
    Given Put update cart with additional request body made use id <id>
    When Send request put update cart with additional request body made
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |
      | 2  |