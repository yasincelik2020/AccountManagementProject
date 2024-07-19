@Api100
Feature:Get User Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: M_09_01 Post organization user register-manual
    Given Url ist eingestellt für organization user register-manual
    And Einstellen der zu sendenden Daten für organization user register-manual
    When Benutzer sendet Anfrage mit POST-Methode
    Then Der Statuscode 201 wird bestätigt.

  Scenario: M_09_02 Get user id
    Given Url ist eingestellt für user id
    And Einstellen der zu sendenden Daten für user id
    When Benutzer sendet Anfrage mit GET-Methode
    Then Der Statuscode 200 wird bestätigt.

  Scenario: M_09_03 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode
    Then Überprüfen Sie, ob die E-Mail in der Antwort die E-Mail des Benutzers ist.

  Scenario: M_09_04 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode
    Then In der Antwort wird auch überprüft, ob created_by die Benutzerkennung ist.

  Scenario: M_09_05 Put user
    Given Url ist eingestellt für user
    And Einstellen der zu sendenden Daten für user
    When Benutzer sendet Anfrage mit PUT-Methode
    Then Der Statuscode 200 wird bestätigt.

  Scenario: M_09_06 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode
    Then Der Statuscode 200 wird bestätigt.

  Scenario: M_09_07 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode
    Then In der Antwort wird überprüft, ob es sich bei dem Benutzernamen um den aktualisierten Namen des Benutzers handelt


#  Scenario: M_02_08 Get user_id appID membership
#    Given Url ist eingestellt für user_id appID membership
#    And Einstellen der zu sendenden Daten
#    When Benutzer sendet Anfrage mit GET-Methode für user_id appID membership
#    Then Antwort bestätigt auch, dass die Benutzerkennung vorhanden ist
#
#  Scenario: M_02_09 Get user_id appID membership
#    Given Url ist eingestellt für user_id appID membership
#    When Benutzer sendet Anfrage mit GET-Methode für user_id appID membership
#    Then Die Antwort bestätigt auch, dass es einen Benutzernamen gibt
#
#  Scenario: M_02_10 Get user_id appID membership
#    Given Url ist eingestellt für user_id appID membership
#    When Benutzer sendet Anfrage mit GET-Methode für user_id appID membership
#    Then Überprüft, ob die appId in der Antwort vorhanden ist
#
#  Scenario: M_02_01 Get membership
#    Given Url ist eingestellt für membership
#    When Benutzer sendet Anfrage mit GET-Methode
#    Then Überprüfen, ob der Statuscode 200 ist
#
#  Scenario: M_02_02 Get membership
#    Given Url ist eingestellt für membership
#    And Einstellen der zu sendenden Daten
#    When Benutzer sendet Anfrage mit GET-Methode
#    Then Anhand der Benutzer-ID in der Antwort wird überprüft, ob es unter den Mitgliedschaften eine Mitgliedschaft gibt, die zu dieser Benutzer-ID gehört.
#
#  Scenario: M_02_03 Get membership
#    Given Url ist eingestellt für membership
#    When Benutzer sendet Anfrage mit GET-Methode
#    Then Anhand der Benutzername in der Antwort wird überprüft, ob es unter den Mitgliedschaften eine Mitgliedschaft gibt, die zu dieser Benutzername gehört.
#
#  Scenario: M_02_04 Get appID membership
#    Given Url ist eingestellt für appID membership
#    When Benutzer sendet Anfrage mit GET-Methode für appID membership
#    Then Überprüfen, ob der Statuscode 200 ist
#
#  Scenario: M_02_05 Get appID membership
#    Given Url ist eingestellt für appID membership
#    When Benutzer sendet Anfrage mit GET-Methode für appID membership
#    Then Der Benutzername der zur Benutzerkennung gehörenden Mitgliedschaft wird überprüft
#
#  Scenario: M_02_06 Get appID membership
#    Given Url ist eingestellt für appID membership
#    When Benutzer sendet Anfrage mit GET-Methode für appID membership
#    Then Überprüft die Benutzer-ID der zum Benutzernamen gehörenden Mitgliedschaft
#
#  Scenario: M_02_11 Get user_id membership
#    Given Url ist eingestellt für user_id membership
#    When Benutzer sendet Anfrage mit GET-Methode für user_id membership
#    Then Überprüfen, ob der Statuscode 200 ist
#
#  Scenario: M_02_12 Get user_id membership
#    Given Url ist eingestellt für user_id membership
#    When Benutzer sendet Anfrage mit GET-Methode für user_id membership
#    Then Die Antwort überprüft auch, ob die Organisations-ID vorhanden ist.
#
#  Scenario: M_02_13 Get user_id membership
#    Given Url ist eingestellt für user_id membership
#    When Benutzer sendet Anfrage mit GET-Methode für user_id membership
#    Then Die Antwort überprüft auch, ob die Id vorhanden ist.










