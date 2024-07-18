@Api3
Feature:Membership Service Type Service

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  Scenario: M_03_TC_01 Get appID Membership Type Service
    Given Url ist eingestellt mit appID membership-type
    When Benutzer sendet Anfrage mit GET Methode für appID membership-type
    Then Benutzer prüft über, ob der Statuscode 200 ist

  Scenario Outline:M_03_TC_02-03 Get appID Membership Type Service
    Given Url ist eingestellt mit appID membership-type
    When Benutzer sendet Anfrage mit GET Methode für appID membership-type
    And In der Antwort wird bestätigt,dass die <ID> , <index> , "<name>" sind.

   Examples:
     |ID | index|name|
     |5  |0    |Company Membership|
     |6  |1    |Guest Membership  |

  Scenario Outline:M_03_TC_04-05-06 Get Membership Type Service
    Given Url ist eingestellt membership-type
    When Benutzer sendet Anfrage mit GET Methode membership-type
    Then Benutzer prüft über, ob der Statuscode 200 ist
    And In der Antwort wird bestätigt,dass den "<name>" ist.
    Examples:
      |name|
      |Company Membership|
      |Guest Membership  |

  Scenario: M_03_TC_07-08 Get Membership Type Service
    Given Url ist eingestellt membership-type mit Company ID
    When Url ist eingestellt membership-type mit Guest ID
    Then Benutzer sendet Anfrage mit GET Methode membership-type mit Company ID
    Then Benutzer sendet Anfrage mit GET Methode membership-type mit Guest ID
    And Benutzer prüft über, ob der Statuscode 200 ist