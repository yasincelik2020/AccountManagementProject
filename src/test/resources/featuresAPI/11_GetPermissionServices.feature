@Api1 @Modul11 @Regression
Feature: Get Permission

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

@Permission
  Scenario: M11_TC_01-02-03-04 Get Permission Service Scenario
    Given Einstellen url für for permission
    When Der Benutzer sendet eine Anfrage mit der GET-Methode permission
    Then Der Statuscode 200 wird bestätigt für Permission
    And Der app_id des dritten Elements von list wird bestätigt.
    And Der Benutzer bestätigt, dass die erwarteten Daten in der Antwort vorhanden sind.
    And Die Antwort wird innerhalb von 600 ms erhalten müssen

  @PermissionwithappID
  Scenario: M11_TC_05-06 Get Permission Service Scenario (appID)
    Given  Einstellen url für Permission mit appID
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Permission mit appID
    Then Der Statuscode 200 wird bestätigt für Permission with appID
    And Der app_id des ersten Elements von list wird bestätigt.


@PermissionwithID
  Scenario: M11_TC_07-08-09-10-11 Get Permission Service Scenario (id)
    Given Einstellen url für Permission mit ID
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Permission mit ID
    Then Der Statuscode 200 wird bestätigt für Permission mit ID
    And Benutzer verifiziert ID in Antwort
    And Benutzer verifiziert Action in Antwort
    And Benutzer verifiziert Resource in Antwort
    And Benutzer verifiziert App_Id in Antwort