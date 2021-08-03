Feature: Search a product

  Scenario: User looks for a product
    Given User opens the webpage
    When User enters the product "It"
    Then The webpage shows the list of items