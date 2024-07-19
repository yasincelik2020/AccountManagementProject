@Api12 @Modul12
Feature: Get Permission

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  @SubscriptionwithoutUUID
  Scenario: M12_TC_01-02-03-04 Get Subscription Service Scenario
    Given Einstellen url für Subscription ohne uuid
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription ohne uuid
    Then Der Statuscode 200 wird bestätigt für Subscription ohne uuid
    And Der Benutzer bestätigt, dass die erwarteten Daten für Subscription ohne uuid in der Antwort vorhanden sind.
    And Benutzer verifiziert für subscription ID in Antwort
    And Die Antwort für Subscription ohne uuid wird innerhalb von 800 ms erhalten müssen

@Subscription
  Scenario: M12_TC_05-06-07-08 Get Subscription Service Scenario
    Given Einstellen url für Subscription
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription
    Then Der Statuscode 200 wird bestätigt für Subscription
    And Der Benutzer bestätigt, dass die erwarteten Daten für Subscription in der Antwort vorhanden sind.
    And Die Antwort für Subscription wird innerhalb von 800 ms erhalten müssen

