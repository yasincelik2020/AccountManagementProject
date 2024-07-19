@Api11
Feature: Get User Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  @10_01_02
  Scenario:10_01_02 Get User Status Services
    Given set the url for get TestCase 10_01
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für 10_01.
    And Der Statuscode 200 wird bestätigt.
    And Die Antwort wird innerhalb von 400 ms erhalten

  @10_03
  Scenario:10_01_02 Get User Status Services
    Given set the url for get TestCase 10_03
    When Benutzer sendet eine GET-Anfrage
    And Der Statuscode 200 wird bestätigt.
    And Es wird überprüft, ob der ID-Wert im Response ersteID ist.
    And Es wird überprüft, ob der Response-Body "Active" enthält.

