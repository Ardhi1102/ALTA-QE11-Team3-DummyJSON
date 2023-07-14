Feature: Delete Posts on Dummyjson.com
  @Tugas
  Scenario Outline: Delete a post with valid posts id
    Given  Delete post with valid id <id>
    When Send request delete post
    Then Status code should be 200 OK
    And Response body should contain true on isDeleted
    And Response body should contain posts id <id>
    And Delete post json Schema Validator
    Examples:
    |id|
    |1 |
    |92|
    |100|
    |150|
  @Tugas
  Scenario Outline: Delete a post with invalid posts id
    Given  Delete post with invalid id "<id>"
    When Send request delete post
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |tes|
      |xyz|
      |!#$|
      |%#@|
  @Tugas
  Scenario Outline: Delete a post with unregistered posts id
    Given  Delete post with unregistered id <id>
    When Send request delete post
    Then Status code should be 404 Not Found
    Examples:
      |id |
      |200|
      |151|
      |6154|
      |1356|