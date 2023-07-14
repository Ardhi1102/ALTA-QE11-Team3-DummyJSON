Feature: Put Update Posts on Dummyjson.com

@Tugas
  Scenario Outline: Update post with valid id
    Given  Put update post with valid posts id <id>
    When Send request put update post
    Then Status code should be 200 OK
    And Response posts body should contain posts title "3 Bulan Pasti jadi QA"
    And Put Update Posts json Schema Validator
    Examples:
      |id|
      |1 |
      |92|
      |100|
      |150|

@Tugas
  Scenario: Update post with invalid id
    Given  Put update post with invalid id "tes"
    When Send request put update post
    Then Status code should be 400 Bad Request

@Tugas
  Scenario: Update post with unregistered id
    Given Put update post with valid posts id 200
    When Send request put update post
    Then Status code should be 404 Not Found

@Tugas
# Sehrusnya ini adalah Bad Request tetapi PostMan masih menganggap case ini adalah OK
  Scenario: Update post with registered id and invalid Value
    Given  Put update post with id 1 and invalid value
    When Send request put update post
    Then Status code should be 400 Bad Request
@Tugas
  Scenario: Update post with unregistered id and invalid Value
    Given  Put update post with unregistered id 200 and invalid value
    When Send request put update post
    Then Status code should be 404 Not Found

