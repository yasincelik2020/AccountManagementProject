@Regression
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3004@gmail.com" ein
    And Benutzer gibt gültiges "UEi7XS5wSWc_sao" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist

  @US_18
  Scenario: TC_18_01 "Roles" sehen können

    When In der linken Spalte der aktuellen Seite ist die Registerkarte "Roles" zu sehen

  @US_18
  Scenario: TC_18_02 "Roles" klicken können

    When Die Registerkarte "Roles" in der linken Spalte der aktuellen Seite wird angeklickt
    Then  Auf der Seite, die geöffnet wird, wird der Text "All Roles" angezeigt.

  @US_18
  Scenario: TC_18_03 vierzehn verschiedene Rollen sehen können

    When Die Registerkarte "Roles" in der linken Spalte der aktuellen Seite wird angeklickt
    Then Nach einem Klick auf die Registerkarte "Roles" in der linken Spalte der aktuellen Seite werden sofort vierzehn Rollen angezeigt.

  @US_19
    Scenario: TC_19_01 auf die Rolle Accountant zu klicken
    When Im linken Modul wird Roles angeklickt.
    When Die Rolle Accountant wird ausgewählt.
    Then  Auf der folgenden Seite wird die Überschrift Role Information angezeigt.

  @US_19
    Scenario: TC_19_08 auf die Rolle Business Owner zu klicken
    When Im linken Modul wird Roles angeklickt.
    When Die Rolle Business Owner wird ausgewählt.
    Then  Auf der folgenden Seite wird die Überschrift Role Information angezeigt.

  @US_19
    Scenario: TC_19_14 auf die Rolle Warehouse Personnel zu klicken
    When Im linken Modul wird Roles angeklickt.
    When Die Rolle Warehouse Personnel wird ausgewählt.
    Then  Auf der folgenden Seite wird die Überschrift Role Information angezeigt.


  @US_19
  Scenario Outline: : US_19 (ohne TC_19_01,TC_19_08,TC_19_14)
    When Die Registerkarte "Roles" in der linken Spalte der aktuellen Seite wird angeklickt
    When  Die Rolle "<id>"  wird ausgewählt.
    Then Auf der folgenden Seite wird die Überschrift Role Information angezeigt.

    Examples:
      |id|
      |5|
      |6|
      |7|
      |8|
      |9|
      |10|
      |11|
      |12|
      |13|
      |14|
      |15|






