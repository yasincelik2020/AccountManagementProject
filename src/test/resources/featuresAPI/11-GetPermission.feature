@Api2
Feature: Get Permission

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

@Permission
  Scenario: Get Permission Scenario
    Given set the url for permission
    When send get request for permission
    Then assert permission

  @PermissionwithappID
  Scenario: Get Permission with appID Scenario
    Given set the url for Permission with appID
    When send get request for Permission with appID
    Then assert Permission with appID

@PermissionwithID
  Scenario: Get Permission with ID Scenario
    Given set the url for Permission with ID
    When send get request for Permission with ID
    Then assert Permission with ID