Feature: Get All Posts on Dummyjson.com

  @Tugas
  Scenario: Get all posts with valid parameter
    Given Get all posts with parameter "posts"
    When Send request get all post
    Then Should return 200 OK
    And Response body should contain total posts 150
    And Get all posts json Schema Validator


  @Tugas
#// Seharusnya status kode 404, tetapi postman masih membaca 200
  Scenario Outline: Get all posts with invalid parameter
    Given Get all posts with parameter "<path>"
    When Send request get all post
    Then Should return 404 Not Found
    Examples:
      |path|
      |post |
      |posting|
      |postz|

