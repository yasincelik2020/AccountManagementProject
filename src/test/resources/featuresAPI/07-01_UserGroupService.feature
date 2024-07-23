@Api2 @Modul07_04
Feature:Get User Group Services

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario:M07_TC_01_02 Get User Group Services Scenario
  (Gibt alle "User Group" zurück, die infolge von Hinzufügungen zu den Modulen in der "Company" erstellt wurden.)
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für User Group Services
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Der Name des ersten Elements von User Group List wird bestätigt.

  Scenario:M07_TC_03_04 Post User Group Services Scenario
  (Neu erstellte User Group informationen werden gelesen.)
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der POST-Methode für User Group Services
    Then Der Statuscode 201 wird bestätigt für User Group Services
    And Die Kurznamen-Informationen der neu erstellten User Group werden bestätigt


  Scenario:M07_TC_05_06 Get User Group Services Scenario
  (Die erstellte User Group wird mit der Information „group_id“ zurückgegeben..)
    Given Einstellen url mit group_id für User Group Services
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Der Name info von Group_id wurden bestätigt

  Scenario:M07_07_08 Put User Scenario
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And Der Name info von nach dem Updait Group_id wurden bestätigt

  Scenario:M07_09_10 Get User Scenario
    Given Einstellen url für User Group Services deteils
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details
    Then Der Statuscode 200 wird bestätigt für User Group Services
    And description info von nach dem Updait Group_id wurden bestätigt

  Scenario:M07_Post User Scenario
  (Ein neuer user wird erstellt)
    Given Einstellen url für ein neuer User
    When Der Benutzer sendet eine Anfrage für ein neuer User

  Scenario:M07_11_12 Post User Group Services Scenario
  (Die erstellte User Group wird aktualisiert)
    Given Einstellen url für User Group_user
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user
    Then Der Statuscode 201 wird bestätigt für User Group_user
    And user_id info wurden bestätigt

  Scenario:M07_13_14 Get User Group Services Scenario
  (Abhängig von der User Group erstellte User details werden gelesen)
    Given Einstellen url für User Group_userget
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_userget
    Then Der Statuscode 200 wird bestätigt für User Group_user
    And Die User name-Informationen des ersten Elements der User List werden bestätigt

  Scenario:M07_15 Delete User Group Services Scenario
    (Der je nach User Group erstellte User wird gelöscht.)
    Given Einstellen url für User Group_userdelete
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group_userdelete
    Then Der Statuscode 200 wird bestätigt für User Group_userdelete

  Scenario:M07_16_17 Get User Group Services Scenario
  (Es wird bestätigt, dass die mit der User Group verbundenen User informationen nach dem Löschvorgang nicht vorhanden sind.)
    Given Einstellen url für User Group_user_nachdelete_get
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user_nachdelete_get
    Then Der Statuscode 200 wird bestätigt für User Group_userdelete
    And Es wird bestätigt, dass keine users vorliegen

  Scenario:M07_18 Delete User Group Services Scenario
  (Die zuvor erstellte User Group wird gelöscht.)
    Given Einstellen url für User Group_delete
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group
    Then Der Statuscode 200 wird bestätigt für User Group_userdelete

  Scenario:M07_19 Get User Group Services Scenario
  (Es ist ersichtlich, dass die zuvor erstellte User Group gelöscht wurde..)
    Given Einstellen url für User Group_nachdelete_get
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group_nachdelete_get
    Then Der Statuscode 404 wird bestätigt für User Group_userdelete_



