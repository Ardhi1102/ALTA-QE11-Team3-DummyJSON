Feature: Create New Posts on Dummyjson.com

  @Tugas
  Scenario: Create new post with valid user id
    Given Post new post with valid user id
    When Send request post new post
    Then Should return 200 OK
    And Response body should contain posts id 151 and title "3 Bulan Pasti jadi QA"
    And Post new posts json schema validator

  @Tugas
  Scenario: Create new post with invalid user id
    Given Post new post with invalid user id
    When Send request post new post
    Then Should return 400 Bad Request
  @Tugas
  Scenario: Create new post without user id
    Given Post new post without user id
    When Send request post new post
    Then Should return 400 Bad Request
  @Tugas
  Scenario: Create new post with unregistered user id
    Given Post new post with unregistered user id
    When Send request post new post
    Then Should return 404 Not Found
   @Tugas
#    //Seharusnya 400 bad request, tetapi postman 200 Ok, dikarenakan bisa menambahkan dengan empty value
  Scenario: Create new post with registered user id  and empty value
    Given Post new post registered user id  and empty value
    When Send request post new post
    Then Should return 400 Bad Request

  @Tugas
  Scenario: Create new post with unregistered user id and empty value
    Given Post new post unregistered user id  and empty value
    When Send request post new post
    Then Should return 404 Not Found
