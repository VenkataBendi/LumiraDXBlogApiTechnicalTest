Feature: Operations to blog category

  Scenario: TC01 - Returns list of all blog categories
    Given I set the GET service endpoint for list of blog categories and receive response
    Then check statusCode is 200
    And check response content type is "application/json"
    And validate response json schema with "categoriesList.json"

  Scenario Outline: TC02 - Add a new category using id and name
    Given I have the number of categories present
    When I set the POST service endpoint for adding new blog category with id <id> and name <categoryName>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And check the get list of categories response if number of categories is incremented by one
    And check get list of categories response for the name of the item with id <id> to be <categoryName>
    Examples:
      | id | categoryName | expectedStatusCode | contentType        |
      | 4  | "Gardening"  | 201                | "application/json" |
      | 5  | "Sports"     | 201                | "application/json" |

  Scenario Outline: TC03 - Add a new category using name
    Given I have the number of categories present
    When I set the POST service endpoint for adding new blog category with name <categoryName>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And check the get list of categories response if number of categories is incremented by one
    And check get list of categories response for the name of the last item to be <expectedCategoryName>
    Examples:
      | categoryName | expectedStatusCode | contentType        | expectedCategoryName |
      | "Nature"     | 201                | "application/json" | "Nature"             |

  Scenario: TC04 - Add a new category using int data type for name
    Given I set the POST service endpoint for adding new blog category with categoryName as 1
    Then check statusCode is 400
    And check response content type is "application/json"
    And check response for message "Input payload validation failed"


  Scenario: TC05 - Add a new category using an existing id and name
    Given I set the POST service endpoint for adding new blog category with id 4 and name "Travel"
    Then check statusCode is 500
    And check response content type is "text/html; charset=utf-8"
    And check title in response contains "UNIQUE constraint failed: category.id"

  Scenario: TC06 - Add a new category using only id
    Given I set the POST service endpoint for adding new blog category with id 11
    Then check statusCode is 400
    And check response content type is "application/json"
    And check response for message "Input payload validation failed"

  Scenario Outline: TC07 - Delete a category with id that doesn't exist
    Given I set the DELETE service endpoint a categories with id <id> and receive response
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And check response for message "A database result was required but none was found."
    Examples:
      | id  | expectedStatusCode | contentType        |
      | 101 | 404                | "application/json" |


  Scenario Outline: TC08 - Delete a category with id in endpoint
    Given I set the DELETE service endpoint a categories with id <id> and receive response
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And check for id <id> is deleted in the list of categories response
    Examples:
      | id | expectedStatusCode | contentType        |
      | 5  | 204                | "application/json" |

  Scenario Outline: TC09 - Return a category with a list of posts for a valid category id
    Given I set the GET service endpoint for list of posts for category id <id> and receive response
    Then check statusCode is <expectedStatusCode>
    And validate response json schema with <expectedSchema>
    And check categoryId in list of posts response is <id>
    Examples:
      | id | expectedStatusCode | expectedSchema                 |
      | 1  | 200                | "listOfPostsForaCategory.json" |

  Scenario Outline: TC10 - Return a category with a list of posts for invalid category id
    Given I set the GET service endpoint for list of posts for category id <id> and receive response
    Then check statusCode is <expectedStatusCode>
    And check response for message "A database result was required but none was found."
    Examples:
      | id | expectedStatusCode |
      | 51 | 404                |

  Scenario Outline: TC11 - Updates a blog category
    Given I set the PUT service endpoint for updating a blog category with id <id> and pass the updated category name <categoryName>
    Then check statusCode is <expectedStatusCode>
    And  check response content type is "application/json"
    And check get list of categories response for the name of the item with id <id> to be <categoryName>
    Examples:
      | id | expectedStatusCode | categoryName |
      | 3  | 204                | "Technology" |

  Scenario: TC12 - Update a category using an id that doesn't exist
    Given I set the PUT service endpoint for updating a blog category with id 299 and pass the updated category name "Cycling"
    Then check statusCode is 404
    And check response contains "message" "A database result was required but none was found."

