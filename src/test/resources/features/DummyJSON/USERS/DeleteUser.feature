Feature: Delete User at Dummyjson.com
@Tugas
  Scenario Outline: Delete User with Registered id
    Given Delete user with registered id <id>
    When Send request delete user
    Then Status code should be 200 OK
    And Delete user registered id json schema validator
    Examples:
    |id|
    |1 |
    |2 |

   @Tugas
    Scenario: Delete User with Unregistered Id
      Given Delete user with Unregistered Id 103
      When Send request delete user
      Then Status code should be 404 Not Found
      And Delete user unregistered id json schema validator