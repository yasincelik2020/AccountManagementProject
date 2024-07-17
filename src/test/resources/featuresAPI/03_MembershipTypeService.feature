@Api3
Feature:Membership Service Type Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: M_03_01 Get appID Membership Type Service
    Given Url ist eingestellt mit appID membership-type
    When Benutzer sendet Anfrage mit GET Methode für appID membership-type
    Then Benutzer prüft über, ob der Statuscode 200 ist