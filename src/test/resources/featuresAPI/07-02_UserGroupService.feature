@Api @Modul07 @Smoke
Feature:Get User Group Services

#  Background: Get User Info
#    Given set the url for User Info
#    When send get request User Info
#    And get the user info information

  Scenario:M07_TC_01_02 Get User Group Services Scenario
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für User Group Services.
    Then Der Statuscode 200 wird bestätigt für User Group Services.
    And Der Name des zweiten Elements von User Group List wird bestätigt.

  Scenario:M07_TC_03_04 Post User Group Services Scenario
    Given Einstellen url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der POST-Methode für User Group Services.
    Then Der Statuscode 201 wird bestätigt für User Group Services..
    And Die Name-Informationen der neu erstellten User Group werden bestätigt

  Scenario:M07_TC_05_06 Get User Group Services Scenario
    Given Einstellen url mit group_id2 für User Group Services
    When Der Benutzer sendet eine Anfrage mit der Get-Methode2 für User Group Services
    Then Der Statuscode 200 wird bestätigt für User Group _Services
    And Die Kurzname informationen der neu erstellten User Group werden bestätigt.

  Scenario:M07_07_08 Put User Scenario
    Given Einstellen _url für User Group Services
    When Der Benutzer sendet eine Anfrage mit der Put-Methode für User Group Services..
    Then Der Statuscode 200 wird bestätigt für User Group Services.
    And Der Kurzname info von nach dem Update Group Id wurden bestätigt

  Scenario:M07_09_10 Get User Scenario
    Given Einstellen url für User Group Services details
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group Services details.
    Then Der Statuscode 200 wird bestätigt für User Group Services.
    And Der Organizationsname info von nach dem Update Group Id wurden bestätigt

  Scenario:M07_Post User Scenario
    Given Einstellen url für ein neuer User.
    When Der Benutzer sendet eine Anfrage für ein neuer User.

  Scenario:M07_11_12 Post User Group Services Scenario
    Given Einstellen url für User Group_user.
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user.
    Then Der Statuscode 201 wird bestätigt für User Group_user.
    And Id info wurden bestätigt.

  Scenario:M07_13_14 Get User Group Services Scenario
    Given Einstellen url für User Group_userget.
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_userget.
    Then Der Statuscode 200 wird bestätigt für User Group_user.
    And Die Username-Informationen des ersten Elements der User List werden bestätigt.

  Scenario:M07_15 Delete User Group Services Scenario
    Given Einstellen url für User Group_userdelete.
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group_userdelete.
    Then Der Statuscode 200 wird bestätigt für User Group_userdelete.

  Scenario:M07_16_17 Get User Group Services Scenario
    Given Einstellen url für User Group_user_nachdelete_get.
    When Der Benutzer sendet eine Anfrage mit der Get-Methode für User Group_user_nachdelete_get.
    Then Der Statuscode 200 wird bestätigt für User Group_userdelete.
    And Es wird bestätigt, dass keine users vorliegen.

  Scenario:M07_18 Delete User Group Services Scenario
    Given Einstellen url für User Group_delete.
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group.
    Then Der Statuscode 200 wird bestätigt für User Group_userdelete.

  Scenario:M07_19 Get User Group Services Scenario
    Given Einstellen url für User Group_nachdelete_get.
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für User Group_nachdelete_get.
    Then Der Statuscode 404 wird bestätigt für User Group_userdelete..

