@Api8
Feature:User Group Type Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: M_08_01 Get User Group Type Service