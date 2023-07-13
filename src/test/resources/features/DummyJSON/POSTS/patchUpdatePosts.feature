Feature: Patch Update Posts on Dummyjson.com

  Scenario Outline: Patch Update post with valid Posts id
    Given  Patch update post with valid id <id>
    When Send request patch update post
    Then Should return 200 OK
    And Response posts body should contain posts title "<title>"
    And Patch Update posts json schema validator
    Examples:
      |id|title|
      |1 |3 Bulan Pasti jadi QA|
      |92|3 Bulan Pasti jadi QA|
      |100|3 Bulan Pasti jadi QA|
      |150|3 Bulan Pasti jadi QA|

  Scenario Outline: Patch Update post with invalid Posts id
    Given  Patch update post with invalid id "<id>"
    When Send request patch update post
    Then Should return 400 Bad Request
    Examples:
      |id|
      |tes|
      |ZYG|
      |!@#%|
      |%@#$|

  Scenario Outline: Patch Update post with unregistered Posts id
    Given  Patch update post with unregistered id <id>
    When Send request patch update post
    Then Should return 404 Not Found
    Examples:
      |id |
      |200|
      |151|
      |6154|
      |1356|

