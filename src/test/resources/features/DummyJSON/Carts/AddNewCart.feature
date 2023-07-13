Feature: Add New Cart

  @Tugas #Positif Case
  Scenario: Add new cart with valid json
    Given Post add new cart with valid json
    When Send request post add new cart with valid json
    Then Status code should be 200 OK
    And Validate add new cart JSON schema

  @Tugas #Negatif Case
  Scenario: Add new cart with empty json
    Given Post add new cart with empty json
    When Send request post add new cart with empty json
    Then Status code should be 400 Bad Request

    Scenario: add new cart with invalid json