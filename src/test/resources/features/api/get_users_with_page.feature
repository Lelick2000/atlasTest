Feature: Get list of users using REST API

  I want to be able to get all users, using special endpoint

  Scenario: Should receive list of users with GET query and 'page' param
    When I make GET USERS with param page = 2 with response status 200
    Then The response have “first_name” with value = "Lindsay"
    And  The response page param has value 2
