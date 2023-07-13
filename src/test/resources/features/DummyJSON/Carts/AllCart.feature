Feature: All Carts

  @Tugas #Positif Case
  Scenario: Get all charts with valid path
    Given Get all charts with valid path
    When Send request get all carts with valid path
    Then Status code should be 200 OK

  @Tugas #Negative Case
  Scenario: Get all charts with invalid path
    Given Get all carts with invalid path
    When Send request get all carts with invalid path
    Then Status code should be 400 Bad Request