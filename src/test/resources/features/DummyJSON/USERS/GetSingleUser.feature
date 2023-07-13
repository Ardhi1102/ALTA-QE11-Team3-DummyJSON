
  Feature: Case Users in dummyJSON

    @User
    Scenario Outline: Get single user with random registered id
      Given Get single user with valid id <id>
      When Send request get single user
      Then Status should return 200 OK
      And Response body should contain id <id> first name "<firstName>" last name "<lastname>" maiden name "<maidenName>"
      Examples:
      |id| firstName | lastname | maidenName |
      |20| Lenna    | Renner    |Schumm       |
      |30| Maurine  | Stracke   | Abshire    |
      |40| Jasmin   | Hermiston | Marvin     |
