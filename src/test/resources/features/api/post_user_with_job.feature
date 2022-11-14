Feature: Post a new user with job, using REST API

  I want to be able to Post new user in USERS endpoint

  Scenario: Should Post new user with job param
    When I make Post USERS with username= "Alex_test" and job title = "atlas_test" with response status 201
    Then The response have name equals to request one
    And  The response have job equals to request one
