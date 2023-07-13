Feature:Single Cart
  @tugas #Positive Case
  Scenario Outline: Get single cart with valid parameter id
    Given Get single cart with valid parameter id <id>
    When Send request get single cart with valid parameter id
    Then Status code should be 200 OK
    And Response body page should be display userId <userId> and total <total>
    And Validate get single user JSON schema
    Examples:
      | id | userId | total |
      | 1  | 97     | 2328  |
      | 2  | 30     | 3023  |

  @tugas #Negative Case
  Scenario Outline: Get single cart with exceed parameter id
    Given Get single cart with exceed parameter id <id>
    When Send request get single cart with valid parameter id
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 21 |
      | 25 |

  @tugas #Negative Case
  Scenario Outline: Get single cart with invalid parameter id
    Given Get single cart with invalid parameter id "<id>"
    When Send request get single cart with valid parameter id
    Then Status code should be 400 Bad Request
    Examples:
      | id         |
      | syalala123 |
      | balonku5   |