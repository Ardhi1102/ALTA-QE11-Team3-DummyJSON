Feature:Login
  @tugas #Positive Case
  Scenario: Login with valid email and password
    Given Post login with valid email and password
    When Send request post login with valid email and password
    Then Status code should be 200 OK
    And Validate login success user JSON schema

  @tugas #Negative Case
  Scenario: Login with valid email and invalid password
    Given Post login with valid email and invalid password
    When Send request post login with valid email and invalid password
    Then Status code should be 400 Bad Request
    And Validate login unsuccess user JSON schema

  @tugas #Negative Case
  Scenario: Login with invalid email and valid password
    Given Post login with invalid email and valid password
    When Send request post login with invalid email and valid password
    Then Status code should be 400 Bad Request
    And Validate login unsuccess user JSON schema