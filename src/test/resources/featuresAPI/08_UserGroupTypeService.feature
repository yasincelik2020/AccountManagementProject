@Api8
Feature:User Group Type Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: M_08_01-02 Get User Group Type Service
    Given Url ist eingestellt User Group Type Service
    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service
    Then Benutzer prüft über, ob der Statuscode 200 ist
    And Antwort wurde bestätigt, dass es sich bei den Namen um die Department handelt.

#  Scenario: M_08_03-04 Get User Group Type Service mit ID
#    Given Url ist eingestellt User Group Type Service mit ID
#    When Benutzer sendet Anfrage mit GET Methode for User Group Type Service
#    Then Benutzer prüft über, ob der Id 1 ist
