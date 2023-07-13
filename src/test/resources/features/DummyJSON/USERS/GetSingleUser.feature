
  Feature: Case Users in dummyJSON

    @User
    Scenario Outline: Get single user with random registered id
      Given Get single user with valid id <id>
      When Send request get single user
      Then Status should return 200 OK
      And Response body should contain id <id> first name "<firstName>" last name "<lastname>" maiden name "<maidenName>"
      And Validate get single user with random registered JSON schema
      Examples:
      |id| firstName | lastname | maidenName |
      |20| Lenna    | Renner    | Schumm      |
      |30| Maurine  | Stracke   | Abshire    |
      |40| Jasmin   | Hermiston | Marvin     |

    @User
    Scenario Outline: Get single user with valid parameter id
      Given Get single user with invalid id <letter>
      When Send request get single user invalid id
      Then Status should return 400 Bad Request
      Examples:
      |letter|
      |id|
      |@@|

    @User
    Scenario Outline: Get single user with valid parameter number decimal
      Given Get single user with invalid parameter number decimal <id>
      When Send request get single user decimal
      Then Status should return 404 Not Found
      Examples:
        |id|
        |3,2|
        |0,5|