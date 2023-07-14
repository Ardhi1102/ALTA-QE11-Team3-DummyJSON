Feature: Patch User at Dummyjson.com

@Tugas
  Scenario: Update User First Name and Last Name Registered Id
    Given Update user first name and last name body data
    When Send request update user patch
    Then Status code should be 200 OK
    And Update user patch registered id json schema validator

@Tugas
    Scenario: Update User Height and Weight Registered Id
      Given Update user height and weight body data
      When Send request update user patch
      Then Status code should be 200 OK
      And Update user patch registered id json schema validator

@Tugas
      Scenario: Update User First Name and Last Name Unregistered Id
        Given Update user first name and last name body data
        When Send request update user patch unregistered id
        Then Status code should be 404 Not Found
        And Update user patch unregistered id json schema validator
