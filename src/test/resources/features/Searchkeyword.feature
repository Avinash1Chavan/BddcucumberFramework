Feature: SearchKeyword

  Scenario Outline: Successfully Item has been searched
    Given user is on home page
    When user enter the item in search engine from given sheetname "<SheetName>" and rownumber <RowNumber>
    And Click on search button
    And user clicks on the sort by button
    And user clicks on the popularity
    And user sets the price range
    And user clicks on the first item
    And user clicks on add to cart
    And user verifies item added to cart
    And user verifies item removed from cart
    Then user gets message
    And the message should be "Shopping Cart is empty!"

    Examples:
      | SheetName | RowNumber |
      | SearchProduct | 0     |
