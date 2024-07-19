@Api11
Feature: Get User Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  @09_01
  Scenario:09_01 Post User Service
    Given set the url for Post TestCase 09_01
    When Der Benutzer sendet eine Anfrage mit der POST-Methode.
    Then Der Statuscode 201 wird bestätigt.

  @09_02_03
  Scenario:09_02_03 Post User Service
    Given set the url for Post TestCase 09_01
    When Der Benutzer sendet eine GET-Anfrage ohne API-ID im Body.
    Then die Nachricht Not Acceptable wird bestätigt

  @09_04_05_06_07
  Scenario:09_04_05_06_07 Get User Service
    Given set the url for get TestCase 09_04
    When Der Benutzer sendet eine Anfrage mit der Get-Methode.
    And Der Statuscode 200 wird bestätigt.
    And die ID des zuletzt hinzugefügten Benutzers in der Antwort enthalten ist.
    And die E-Mail des zuletzt hinzugefügten Benutzers in der Antwort enthalten ist.
    And Es wird überprüft, dass die zuletzt erstellte Benutzerstatus-ID 1 ist.

  @09_08
  Scenario:09_08 Put User Service
    Given set the url for put TestCase 09_08
    When Der Benutzer sendet eine Anfrage mit der Put-Methode.
    And Der Statuscode 200 wird bestätigt.

  @09_09
  Scenario:09_09 Put User Service
    Given set the url for put TestCase 09_08
    When Der Benutzer sendet eine Anfrage ohne Benutzer-ID  mit der Put-Methode.
    And Der Statuscode 406 wird bestätigt.

  @09_10
  Scenario:09_10 Delete User Service for Organization
    Given set the url for delete TestCase 09_10
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode.
    And Der Statuscode 200 wird bestätigt.

  @09_11
  Scenario:09_11 Delete User Service for User Service
    Given set the url for delete TestCase 09_11
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode for User Service.
    And Der Statuscode 200 wird bestätigt.

  @09_12_13
  Scenario:09_12_13 Get User for User Service
    Given set the url for get TestCase 09_04
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für Kontrolle.
    And Der Statuscode 404 wird bestätigt.
    And Es wird bestätigt, dass der Text „User is not available“ angezeigt wird
