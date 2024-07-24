@Api @Modul09 @Smoke
Feature:Get User Service

#  Background: Get User Info
#    Given set the url for User Info
#    When send get request User Info
#    And get the user info information

  Scenario: M_09_01 Post organization user register-manual
    Given Url ist eingestellt für organization user register-manual
    And Einstellen der zu sendenden Daten für organization user register-manual
    When Benutzer sendet Anfrage mit POST-Methode
    Then Der Statuscode 201 wird bestätigt..

  Scenario: M_09_02 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode für Get
    Then Der Statuscode 200 wird bestätigt..

  Scenario: M_09_03 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode für Get
    Then Überprüfen Sie, ob die E-Mail in der Antwort die E-Mail des Benutzers ist.

  Scenario: M_09_04 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode für Get
    Then In der Antwort wird auch überprüft, ob created_by die Benutzerkennung ist.

  Scenario: M_09_05 Put user
    Given Url ist eingestellt für user
    And Einstellen der zu sendenden Daten für user
    When Benutzer sendet Anfrage mit PUT-Methode
    Then Der Statuscode 200 wird bestätigt..

  Scenario: M_09_06 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode für Get
    Then Der Statuscode 200 wird bestätigt..

  Scenario: M_09_07 Get user id
    Given Url ist eingestellt für user id
    When Benutzer sendet Anfrage mit GET-Methode für Get
    Then In der Antwort wird überprüft, ob es sich bei dem Benutzernamen um den aktualisierten Namen des Benutzers handelt

  Scenario: M_09_08 Delete organization user id
    Given Url ist eingestellt für organization user id
    When Benutzer sendet Anfrage mit DELETE-Methode für Delete
    Then Der Statuscode 200 wird bestätigt..

  Scenario: M_09_09 Delete  user id
    Given Url ist eingestellt für delete user id
    When Benutzer sendet Anfrage mit DELETE-Methode
    Then Der Statuscode 200 wird bestätigt..

  Scenario: M_09_10 Get v1 user id
    Given Url ist eingestellt für Get v1 user id
    When Benutzer sendet Anfrage mit GET-Methode für Get v1 user id
    Then Der Statuscode 404 wird bestätigt..

  Scenario: M_09_11 Get organization user
    Given Url ist eingestellt für Get organization user
    When Benutzer sendet Anfrage mit GET-Methode für Get organization user
    Then Der Statuscode 200 wird bestätigt..

  Scenario: M_09_12 Get organization user
    Given Url ist eingestellt für Get organization user
    When Benutzer sendet Anfrage mit GET-Methode für Get organization user
    Then Antwort bestätigt, dass die gelöschte ID nicht existiert

  Scenario: M_09_13 Get organization user
    Given Url ist eingestellt für Get organization user
    When Benutzer sendet Anfrage mit GET-Methode für Get organization user
    Then Die Antwort bestätigt auch, dass der gelöschte Benutzername nicht existiert













