Feature: Get all posts by user id on Dummyjson.com

  @Tugas
  Scenario Outline: Get all posts with valid user id
    Given Get all posts with valid user id <id>
    When Send request get all posts
    Then Status code should be 200 OK
    And Response body should contain user id <id>
    And Get all posts by user id json Schema Validator
    Examples:
      |id|
      |1 |
      |10|
      |50|

    @Tugas
  Scenario Outline: Get all posts with invalid user id
    Given Get all posts with invalid user id "<id>"
    When Send request get all posts
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |tes|
      |ZYG|
      |!@#%|
      |%@#$|

      @Tugas
  Scenario Outline: Get all posts with unregistered user id
    Given Get all posts with unregistered user id <id>
    When Send request get all posts
    Then Status code should be 404 Not Found
    Examples:
      |id |
      |200|
      |151|
      |6154|
      |1356|


