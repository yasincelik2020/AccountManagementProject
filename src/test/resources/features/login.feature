@Regression
Feature: login

  Scenario:  Sie müssen ein gültiges E-Mail-Format angeben, das Folgendes enthält

    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltfläche Login
    And Der Benutzer gibt ein gültiges "Mail" ein
    And Benutzer gibt gültiges "Passwort" ein
    And Klick auf die Schaltfläche Login
    And Der Benutzer bestätigt, dass er auf HomePage ist
