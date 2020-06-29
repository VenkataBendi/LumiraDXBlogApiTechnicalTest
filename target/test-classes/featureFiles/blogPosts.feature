Feature: Operations to blog posts

  Scenario Outline: TC13 - Returns list of blog posts
    Given I set the GET service endpoint for list of posts with parameters <pageNumber> , <perPage>, <pageNum>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | pageNumber | perPage | pageNum | expectedStatusCode | contentType        | expectedSchema     |
      | 1          | 2       | "true"  | 200                | "application/json" | "listOfPosts.json" |

  Scenario Outline: TC14 - Returns list of blog posts
    Given I set the GET service endpoint for list of posts with parameters <pageNumber> , <perPage>, <pageNum>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | pageNumber | perPage | pageNum | expectedStatusCode | contentType        | expectedSchema     |
      | 2          | 2       | "true"  | 200                | "application/json" | "listOfPosts.json" |

  Scenario Outline: TC15 - Returns list of blog posts
    Given I set the GET service endpoint for list of posts with parameters <pageNumber> , <pageNum>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | pageNumber | pageNum | expectedStatusCode | contentType        | expectedSchema     | perPage |
      | 1          | "true"  | 200                | "application/json" | "listOfPosts.json" | 10      |

  Scenario Outline: TC16 - Returns list of blog posts without query parameters
    Given I set the GET service endpoint for list of posts without parameters
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | pageNumber | perPage | expectedStatusCode | contentType        | expectedSchema     |
      | 1          | 10      | 200                | "application/json" | "listOfPosts.json" |

  Scenario Outline: TC17 -  Create a new blog post
    Given I have the number of posts present
    When I set the POST service endpoint for adding new blog post for <categoryId>, with <body> and <title>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And check the get list of posts number of posts is incremented by one
    And check get list of posts response to match categoryID to <categoryId>, body to <body>,title to <title> of the last post
    Examples:
      | categoryId | body   | title   | expectedStatusCode | contentType        |
      | 1          | "body" | "title" | 201                | "application/json" |

  Scenario: TC18 - Create a new blog post with no body
    Given I have the number of posts present
    When I set the POST service endpoint for adding new blog post for category_id 1,  and "title"
    Then check statusCode is 400
    And check response content type is "application/json"
    And check response for message "Input payload validation failed"

  Scenario: TC19 - Create a new blog post with no title
    Given I have the number of posts present
    When I set the POST service endpoint for adding new blog post for category_id 1 and with "body"
    And check statusCode is 400
    And check response content type is "application/json"
    And check response for message "Input payload validation failed"

  Scenario: TC20 - Create a new blog post with no categoryId
    Given I have the number of posts present
    When I set the POST service endpoint for adding new blog post with "body" and "title"
    Then check statusCode is 404
    And check response content type is "application/json"
    And check response for message "A database result was required but none was found."

  Scenario Outline: TC21 - Returns list of blog posts for specific year
    Given I set the GET service endpoint for list of posts with parameters <year> , <pageNumber>, <perPage>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for year <year>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | year | pageNumber | perPage | expectedStatusCode | contentType        | expectedSchema     |
      | 2016 | 1          | 2       | 200                | "application/json" | "listOfPosts.json" |


  Scenario Outline: TC22 - Returns list of blog posts for specific year with default perPage
    Given I set the GET service endpoint for list of posts with parameters <year>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for year <year>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | year | expectedStatusCode | contentType        | expectedSchema     | pageNumber | perPage |
      | 2016 | 200                | "application/json" | "listOfPosts.json" | 1          | 10      |

  Scenario Outline: TC23 - Returns list of blog posts for specific month and year
    Given I set the GET service endpoint for list of posts with parameters <month> , <year> , <pageNumber>, <perPage>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <month> and <year>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | month | year | pageNumber | perPage | expectedStatusCode | contentType        | expectedSchema     |
      | 6     | 2016 | 1          | 2       | 200                | "application/json" | "listOfPosts.json" |

  Scenario Outline: TC24 - Returns list of blog posts for specific month, year and default perPage
    Given I set the GET service endpoint for list of posts with parameters <month> , <year>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <month> and <year>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | month | year | expectedStatusCode | contentType        | expectedSchema     | pageNumber | perPage |
      | 6     | 2016 | 200                | "application/json" | "listOfPosts.json" | 1          | 10      |

  Scenario Outline: TC25 - Returns list of blog posts for specific month , year and date
    Given I set the GET service endpoint for list of posts with parameters <date> , <month> , <year>, <pageNumber>, <perPage>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <date>, <month>, <year>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | date | month | year | pageNumber | perPage | expectedStatusCode | contentType        | expectedSchema     |
      | 11   | 6     | 2016 | 1          | 2       | 200                | "application/json" | "listOfPosts.json" |

  Scenario Outline: TC26 - Returns list of blog posts for specific month , year, date and default perPage
    Given I set the GET service endpoint for list of posts with parameters <date> , <month> , <year>
    Then check statusCode is <expectedStatusCode>
    And check response content type is <contentType>
    And validate response json schema with <expectedSchema>
    And check response for <date>, <month>, <year>
    And check response for <pageNumber> , <perPage> and totalPages
    Examples:
      | date | month | year | expectedStatusCode | contentType        | expectedSchema     | pageNumber | perPage |
      | 11   | 6     | 2016 | 200                | "application/json" | "listOfPosts.json" | 1          | 10      |

  Scenario: TC27 - Delete blog post that doesn't exist
    Given I set the DELETE service endpoint for deleting a blog post with postID 29
    Then check statusCode is 404
    And check response content type is "application/json"
    And check response for message "A database result was required but none was found."

  Scenario: TC28 - Delete blog post
    Given I set the DELETE service endpoint for deleting a blog post with postID 5
    Then check statusCode is 204
    And check response content type is "application/json"
    And check get list of posts response for postID 5

  Scenario:TC29 - Get a blog post by id that doesn't exist
    Given I set the GET service endpoint for posts with 101 and receive response
    Then check statusCode is 404
    And check response content type is "application/json"
    And check response for message "A database result was required but none was found."

  Scenario:TC30 - Get a blog post by id
    Given I set the GET service endpoint for posts with 1 and receive response
    Then check statusCode is 200
    And check response content type is "application/json"
    And validate response json schema with "post.json"
    And check response for postID 1

  Scenario: TC31 - Update a post for postID with all details
    Given I set the PUT service endpoint for updating a blog post with postId 1 with categoryId 1 and pass updated body "this is new body" and updated title "this is new body"
    Then check statusCode is 204
    And  check response content type is "application/json"
    And check get post for postID 1 response to match categoryID to 1, body to "this is new body",title to "this is new body"


  Scenario: TC32 - Update a post for postID with no categoryId
    Given I set the PUT service endpoint for updating a blog post with postId 1 and pass updated body "this is new body" and updated title "this is new body"
    Then check statusCode is 404
    And  check response content type is "application/json"
    And check response for message "A database result was required but none was found."

  Scenario: TC33 - Update a post for postID with no title
    Given I set the PUT service endpoint for updating a blog post with postId 1 with categoryId 1 and pass updated body "this is new body"
    Then check statusCode is 400
    And  check response content type is "application/json"
    And check response for message "Input payload validation failed"

  Scenario: TC34 - Update a post for postID with no body
    Given I set the PUT service endpoint for updating a blog post with postId 1 with categoryId 1 and pass updated title "this is new body"
    Then check statusCode is 400
    And  check response content type is "application/json"
    And check response for message "Input payload validation failed"

  Scenario: TC35 - Update a post for postID with all details
    Given I set the PUT service endpoint for updating a blog post with postId 30 with categoryId 1 and pass updated body "this is new body" and updated title "this is new body"
    Then check statusCode is 404
    And  check response content type is "application/json"
    And check response for message "A database result was required but none was found."