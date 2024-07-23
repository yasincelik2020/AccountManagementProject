@Api8
Feature:User Group Type Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

    @TypeUserGroup
  Scenario: M_08_01-02 Get User Group Type Service
    Given Url ist eingestellt User Group Type Service
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service
    Then Benutzer prüft über, ob der Statuscode ist
    And Antwort wurde bestätigt, dass es sich bei den Namen um die Department handelt.

  @TypeUserGroupmitID
  Scenario: M_08_03 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit ID 1
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit ID
    Then Benutzer prüft über, ob der Id 1 ist

  Scenario: M_08_04 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit ID 2
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit ID
    Then Benutzer prüft über, ob der Id 2 ist

  Scenario: M_08_06 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit ID 3
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit ID
    Then Benutzer prüft über, ob der Id 3 ist

  @TypeUserGroupmitIDName
  Scenario: M_08_05 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit ID 2
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit ID
    Then Benutzer prüft über, ob der name "Remote Unit" ist

  Scenario: M_08_07 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit ID 3
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit ID
    Then Benutzer prüft über, ob der name "Team" ist

  @TypeUserGroupmitORG_ID
  Scenario: M_08_08-09 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit org_ID 1
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit org_ID 1
    Then Benutzer prüft über, ob den Statuscode 200 ist
    And Benutzer prüft über,wie der Name lautet Service mit org_ID 1

  Scenario: M_08_10-11 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit org_ID 2
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit org_ID 2
    Then Benutzer prüft über,wie der Name lautet Service mit org_ID 2
    And  Benutzer prüft über, ob den Statuscode 200 ist

  Scenario: M_08_12-13 Get User Group Type Service mit ID
    Given Url ist eingestellt User Group Type Service mit org_ID 3
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service mit org_ID 3
    Then Benutzer prüft über,wie der Name lautet Service mit org_ID 3
    And  Benutzer prüft über, ob den Statuscode 200 ist



