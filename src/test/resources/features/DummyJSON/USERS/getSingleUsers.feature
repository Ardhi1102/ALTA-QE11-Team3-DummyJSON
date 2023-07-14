Feature: Get Single User at Dummyjson.com

  @Tugas
  Scenario Outline: Get Single User with Valid Registered Id (1-3) and (10-30)
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body should contain id <id> first name "<firstName>"  last name "<lastName>" maiden name "<maidenName>"
    And Get single user json schema validator
    Examples:
    |id|   firstName   | lastName  | maidenName  |
    |1 |    Terry      | Medhurst  |  Smitham    |
    |2 |    Sheldon    | Quigley   |  Cole       |
    |3 |    Terrill    | Hills     |  Hoeger     |
    |10|    Eleanora   | Price     |  Cummings   |
    |20|    Lenna      | Renner    |  Schumm     |
    |30|    Maurine    | Stracke   |  Abshire    |

  @Tugas
  Scenario Outline: Get Single User with Valid Random Registered Id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body should contain id <id> first name "<firstName>"  last name "<lastName>" maiden name "<maidenName>"
    And  Get single user json schema validator
    Examples:
        |id|   firstName   | lastName   |  maidenName   |
        |27|   Piper       | Schowalter |  Wuckert      |
        |66|   Terrence    | Koelpin    |  Nienow       |
        |73|   Clotilde    | Larson     |  Zboncak      |

  @Tugas
    Scenario Outline: Get Single User with Unregistered Id
      Given Get single user with unregistered id <id>
      When Send request get single user
      Then Status code should be 404 Not Found
      Examples:
      |id|
      |130|
      |101|

  @Tugas
    Scenario Outline: Get Single User with Invalid Id Number Using Decimal
      Given Get Single user with invalid decimal id <id>
      When Send request get single user
      Then Status code should be 404 Not Found
      Examples:
        |id|
        |0.5|
        |7.10|

  @Tugas
    Scenario Outline: Get Single User with invalid id using a letter
      Given Get single user with invalid id using a letter <letter>
      When Send request get single user character
      Then Status code should be 400 Bad Request
      Examples:
        |letter|
        |a|
        |x|









