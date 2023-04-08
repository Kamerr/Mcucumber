@login
Feature: Login

  Scenario: Login as Kamer
    Given The user is on the login page
    When The user type in Kamer's credentials
    Then The user should be able to login succesfuly


  Scenario:
    Given The user is on the login page
    When The user type in valid credentials:"kamer@gmail.com"and "123456789Ka"
    Then The user should be able to see userName:"Kamer"


  Scenario:
    Given The user is on the login page
    When The user type in valid credentials:"john@gmail.com"and "John1234."
    Then The user should be able to see userName:"John"

  Scenario: Login as Kamer with map
    Given The user is on the login page
    Then The user type in valid credentials via map and verify success login
    |userEmail|kamer@gmail.com|
    |pass|123456789Ka|
    |name|Kamer|
  @grid
  Scenario: Login as Kamer with list
    Given The user is on the login page
    Then The user type in valid credentials via list and verify success login
      |kamer@gmail.com|
      |123456789Ka|
      |Kamer|
  @grid
    Scenario Outline:Login with different user via scenario outline
      Given The user is on the login page
      When The user type in valid credentials:"<userEmail>"and "<password>"
      Then The user should be able to see userName:"<userName>"
      Examples:
        | userEmail | password | userName |
        | kamer@gmail.com | 123456789Ka| Kamer |
        | john@gmail.com |John1234.| John |


