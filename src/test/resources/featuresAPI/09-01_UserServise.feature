@Api1
Feature: Get User Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: Post User Service
    Given set the url for Modul
    When Der Benutzer sendet eine Anfrage mit der POST-Methode.
    Then Der Statuscode 201 wird bestätigt.


