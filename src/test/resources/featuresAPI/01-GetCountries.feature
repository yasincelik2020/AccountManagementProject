@Api
Feature: Get Countries


  @Countries
  Scenario: Get Countries Scenario
    Given set the url for countries
    When sen get request for countries
    Then assert countries