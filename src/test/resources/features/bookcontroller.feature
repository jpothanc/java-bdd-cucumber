Feature: Book Controller

  Scenario: Get book by isbn
    Given I have a list of books
    When I request book with isbn 'isbn:1111'
    Then I should receive book with isbn 'isbn:1111'

  Scenario: Get book by isbn fails when book does not exist
    Given I have a list of books
    When I request book with isbn 'isbn:9999'
    Then I should receive book not found
