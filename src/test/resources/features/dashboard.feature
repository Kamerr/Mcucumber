Feature: Dashboard Tab Names
  @wip
  Scenario:
    Given The user is on the login page
    When The user type in valid credentials:"kamer@gmail.com"and "123456789Ka"
    Then The user should be able to see userName:"Kamer"
    And The user should be able to see all tabs that shown on the dashboard page
    |Dashboard |
    |Developers|
    |Components|
    |Forms     |
    |JavaScript|
    |Kamer     |