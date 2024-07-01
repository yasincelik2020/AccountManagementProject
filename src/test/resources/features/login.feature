@Regression
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "Mail" ein
    And Benutzer gibt gültiges "Passwort" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestuetigt, dass er auf HomePage ist

  Scenario:  Sie müssen ein gültiges E-Mail-Format angeben, das Folgendes enthält


