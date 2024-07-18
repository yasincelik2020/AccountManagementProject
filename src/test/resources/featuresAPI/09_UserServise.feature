@Api1
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

  @09_04_05_06
  Scenario:09_04 Get User Service
    Given set the url for get TestCase 09_04
    When Der Benutzer sendet eine Anfrage mit der Get-Methode.
    And Der Statuscode 200 wird bestätigt.
    And die ID des zuletzt hinzugefügten Benutzers in der Antwort enthalten ist.
    And die E-Mail des zuletzt hinzugefügten Benutzers in der Antwort enthalten ist.
    And Es wird bestätigt, dass der zuletzt hinzugefügte Benutzer vom bestimmte Benutzer erstellt wurde.





