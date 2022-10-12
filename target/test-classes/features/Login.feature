Feature: Login

  Scenario Outline: Successful Login with Valid Credentials
    Given user is on login page
    When user fills the form from given SheetName "<SheetName>" and rowNumber <RowNumber>
    And Click on Login
    Then user gets the title of the page
    And page title should be "Dashboard / nopCommerce administration"


    Examples:
      | SheetName | RowNumber |
      | credentials  | 0         |