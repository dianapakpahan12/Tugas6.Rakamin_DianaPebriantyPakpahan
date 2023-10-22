Feature: Login Page Aplikasi Saucedemo

  Scenario: Success Login
    Given Halaman Login Saucedemo
    When input Username
    And input Password
    And Click Button Login
    Then User in on Dashboard page

  Scenario: Failed Login
    Given Halaman Login Saucedemo
    When input Username
    And input Invalid Password
    And Click Button Login
    Then User get error message


