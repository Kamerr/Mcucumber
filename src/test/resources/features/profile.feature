Feature: Profile Page Tests
  Background:
    Given The user is on the login page
    When The user type in valid credentials:"kamer@gmail.com"and "123456789Ka"
    Then The user should be able to see userName:"Kamer"

Scenario:The user navigates to Add Education Page
  #Given The user is on the login page
  #When The user type in valid credentials:"kamer@gmail.com"and "123456789Ka"
  #Then The user should be able to see userName:"Kamer"
  When The user navigate to "Kamer" and "My Profile"
  Then The user should be able to see overviewpage
  When The user navigate to profile tab:"Add Education"
  Then The user should be able to see "Add Education" button

  Scenario: The user navigate to Add Education Page and fill the education form
   # Given The user is on the login page
    #When The user type in valid credentials:"kamer@gmail.com"and "123456789Ka"
    #Then The user should be able to see userName:"Kamer"
    When The user navigate to "Kamer" and "My Profile"
    Then The user should be able to see overviewpage
    When The user navigate to profile tab:"Add Education"
    Then The user should be able to see "Add Education" button
    When The user fill the form with followings:"İTÜ","BACHELOR","ENGİNEER","0022113344","112233445566","Hard program"
  #  And The user should be able to delete last added record with:"İTÜ"
@wip
  Scenario: The user navigate to Add Education Page and fill the education form with list
    #Given The user is on the login page
    #When The user type in valid credentials:"kamer@gmail.com"and "123456789Ka"
    #Then The user should be able to see userName:"Kamer"
    When The user navigate to "Kamer" and "My Profile"
    Then The user should be able to see overviewpage
    When The user navigate to profile tab:"Add Education"
    Then The user should be able to see "Add Education" button
    When The user fill the form with followings with list:
    |Ankara University|
    |BACHELOR|
    |ENGİNEER|
    |0022113344|
    |112233445566|
    |Hard program|
    #Then The user should be added record with:"Ankara University"
    #And The user should be able to delete last added record with:"Ankara University"

