@Api @Modul12 @Smoke
Feature: Get Permission

  Background: Get User Info
    Given set the url for User Info
    When send get request User Info
    And get the user info information

  @SubscriptionGet
  Scenario: M12_TC_01-02-03 Get Subscription Service Scenario
    Given Einstellen url für Subscription ohne uuid
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription ohne uuid
    Then Der Statuscode 200 wird bestätigt für Subscription
    And Der Benutzer bestätigt, dass die erwarteten Daten für Subscription ohne uuid in der Antwort vorhanden sind.
    And Benutzer verifiziert für subscription ID in Antwort
    And Die Antwort für Subscription ohne uuid wird innerhalb von 800 ms erhalten müssen

@SubscriptionGetwithUUID
  Scenario: M12_TC_04-05-06 Get Subscription Service Scenario
    Given Einstellen url für Subscription
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Subscription
    Then Der Statuscode 200 wird bestätigt für Subscription
    And Der Benutzer bestätigt, dass die erwarteten Daten für Subscription in der Antwort vorhanden sind.
    And Die Antwort für Subscription wird innerhalb von 800 ms erhalten müssen
    And Benutzer verifiziert für subscription ID with UUID in Antwort

  @SubscriptionPost
  Scenario: M12_TC_07-08-09 Post Subscription Service Scenario
    Given Einstellen url für Post Subscription
    When Der Benutzer sendet eine Anfrage mit der Post-Methode für Subscription
    Then Der Statuscode 201 wird bestätigt für Subscription
    And Der Benutzer bestätigt, dass die erwarteten Daten für Post Subscription in der Antwort vorhanden sind.
    And Die Antwort für Subscription wird innerhalb von 800 ms erhalten müssen
    And Benutzer verifiziert für Post subscription ID  in Antwort

  @SubscriptionDelete
  Scenario: M12_TC_10 Post Subscription Service Scenario
    Given Einstellen url für Delete Subscription
    When Der Benutzer sendet eine Anfrage mit der Delete-Methode für Subscription
    Then Der Statuscode 200 wird bestätigt für Subscription

