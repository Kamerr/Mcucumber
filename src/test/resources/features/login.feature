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