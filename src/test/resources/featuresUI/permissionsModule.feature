@Regression
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3004@gmail.com" ein
    And Benutzer gibt gültiges "UEi7XS5wSWc_sao" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist

  @US_20
  Scenario: TC_20_01 "Permissons" sehen können
    When  Auf der folgenden Seite wird die Registerkarte Permissons in der linken Spalte der aktuellen Seite angezeigt.

  @US_20
Scenario:  TC_20_02 "Permissons" klicken können
    When Der Benutzer klickt auf die Registerkarte Permissons in der linken Spalte der aktuellen Seite.


  @US_20
  Scenario: TC_20_03  die Information All Permissions sehen können.
    When Der Benutzer klickt auf die Registerkarte Permissons in der linken Spalte der aktuellen Seite.
    Then  Auf der Seite, die geöffnet wird, wird der Text All Permissions angezeigt.