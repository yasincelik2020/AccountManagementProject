@Regression
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3001@gmail.com" ein
    And Benutzer gibt gültiges "tOGuL29qh-UuNOb" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist


  Scenario: TC_15_01 Neues Mitglied hinzufügen

    Given Der Benutzer klickt auf der Startseite auf den "Users" Button.
    When Der Benutzer klickt auf der Users Seite auf den +Add New Member Button.
    And Der Benutzer waehlt eine Abteilung aus dem Dropdown-Menü aus.
    And Der Benutzer waehlt eine Rolle aus dem Dropdown-Menü aus.
    And Der Benutzer gibt eine gültige E-Mail-Adresse im E-Mail-Feld ein.
    And Der Benutzer klickt auf den Register Button.
    And Der Benutzer überprüft, ob die Nachricht successful im geöffneten Pop-up-Fenster angezeigt wird.
    And Der Benutzer clickt auf Close Button



