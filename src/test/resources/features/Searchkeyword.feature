Feature: SearchKeyword

  Scenario Outline: Successfully Item has been searched
    Given user is on home page
    When user enter the item in search engine from given sheetname "<SheetName>" and rownumber <RowNumber>
    And Click on search button
    Then user gets the title of the page
    And page title should be "Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc"
    Examples:
      | SheetName | RowNumber |
      | SearchProduct | 0         |
