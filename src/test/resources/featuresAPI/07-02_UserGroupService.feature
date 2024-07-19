@Api @Modul07
Feature:Get User Group Services

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario:M07_TC_01_02 Get User Group Services Scenario
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für User Group Services.
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Der Name des zweiten Elements von User Group List wird bestätigt.

  Scenario:M07_TC_03_04 Post User Group Services Scenario
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der POST-Methode für User Group Services.
    Then Der Statuscode 201 wird bestätigt für User Group Services
    And Die Name-Informationen der neu erstellten User Group werden bestätigt

  Scenario:M07_TC_05_06 Get User Group Services Scenario
    Given Einstellen url mit group_id für User Group Services.
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services..
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Die Kurzname informationen der neu erstellten User Group werden bestätigt.

  Scenario:M07_07_08 Put User Scenario
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services.
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Der Kurzname info von nach dem Update Group Id wurden bestätigt

  Scenario:M07_09_10 Get User Scenario
    Given Einstellen url für User Group Services details
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details.
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Der Organizationsname info von nach dem Update Group Id wurden bestätigt


  Scenario:M07_Post User Scenario
  (Ein neuer user wird erstellt)
    Given Einstellen url für ein neuer User
    When Der Benutzer sendet eine Anfrage für ein neuer User

  Scenario:M07_11_12 Post User Group Services Scenario
  (Die erstellte User Group wird aktualisiert)

