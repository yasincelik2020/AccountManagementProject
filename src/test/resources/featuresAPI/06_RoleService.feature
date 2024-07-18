@Modul06
Feature:Get Organization Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario:M06_TC_01_02_ Get Role Service Scenario (AppOrgRole)
    Given Einstellen url für Role Service(appOrgRole)
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service(appOrgRole)
    Then Der Statuscode 200 wird bestätigt für Role Service(appOrgRole)
    And Der Name wird bestätigt für Role Service(appOrgRole)

  Scenario:M06_TC_03_04_ Get Role Service Scenario (AppRole)
    Given Einstellen url für Role Service(appRole)
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service(appRole)
    Then Der Statuscode 200 wird bestätigt für Role Service(appRole)
    And Der Name wird bestätigt für Role Service(appRole)

  Scenario:M06_TC_05_06_ Get Role Service Scenario (Role)
    Given Einstellen url für Role Service(role)
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service(role)
    Then Der Statuscode 200 wird bestätigt für Role Service(role)
    And Die app_id wird bestätigt für Role Service(role)

  Scenario:M06_TC_07_08_ Get Role Service Scenario (RoleRoleId)
    Given Einstellen url für Role Service(roleID)
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Role Service(roleID)
    Then Der Statuscode 200 wird bestätigt für Role Service(roleID)
    And Die Id des ersten Elements von permission wird bestätigt.(roleID)




