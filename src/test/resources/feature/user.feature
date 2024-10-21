Feature: User

  Scenario: User Validation
    When The user has requested all users
    Then The user Bluth, George should be returned

  Scenario: Create users
    Given The user can create new users
      | name   | job   |
      | John   | Smith |
      | Rebeca | Coal  |

