@Api
Feature:Get Membership Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: M_02_07 Get user_id appID membership
    Given Url ist eingestellt für user_id appID membership
    When Benutzer sendet Anfrage mit GET-Methode für user_id appID membership
    Then Überprüfen, ob der Statuscode 200 ist

  Scenario: M_02_08 Get user_id appID membership
    Given Url ist eingestellt für user_id appID membership
    And Einstellen der zu sendenden Daten
    When Benutzer sendet Anfrage mit GET-Methode für user_id appID membership
    Then Antwort bestätigt auch, dass die Benutzerkennung vorhanden ist

  Scenario: M_02_01 Get membership status

    Given Url ist eingestellt für membership
    When Benutzer sendet Anfrage mit GET-Methode
    Then Überprüfen, ob der Statuscode 200 ist

  Scenario: M_02_02 Get membership

    Given Url ist eingestellt für membership
    When Benutzer sendet Anfrage mit GET-Methode
    Then Anhand der Benutzer-ID in der Antwort wird überprüft, ob es unter den Mitgliedschaften eine Mitgliedschaft gibt, die zu dieser Benutzer-ID gehört.

