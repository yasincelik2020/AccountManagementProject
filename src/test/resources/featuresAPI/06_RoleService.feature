@Api @Modul06
Feature:Get Organization Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario:M06_TC_01_02_ Get Role Service Scenario (AppOrgRole)
    Given Einstellen url für Role Service
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service
    Then Der Statuscode 200 wird bestätigt für Role Service
    And Der Name wird bestätigt für Role Service

  Scenario:M06_TC_03_04_ Get Role Service Scenario (AppRole)
    Given Einstellen url für Role Service
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service
    Then Der Statuscode 200 wird bestätigt für Role Service
    And Der Name wird bestätigt für Role Service

  Scenario:M06_TC_05_06_ Get Role Service Scenario (Role)
    Given Einstellen url für Role Service
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service
    Then Der Statuscode 200 wird bestätigt für Role Service
    And Die app_id wird bestätigt für Role Service

  Scenario:M06_TC_07_08_ Get Role Service Scenario (RoleRoleId)
    Given Einstellen url für Role Service
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service
    Then Der Statuscode 200 wird bestätigt für Role Service
    And Die Id des ersten Elements von permission wird bestätigt.




