@Regression @Department
Feature: login

  Background: login
    Given Der Benutzer geht zur URL.
    When Der Benutzer klickt auf den Login Button
    And Auf dem sich öffnenden Bildschirm gibt der Benutzer eine gültige E-Mail-Adresse "dsdt3003@gmail.com" im E-Mail-Feld ein
    And Der Benutzer gibt eine gültige Password "eY6gcuXtneNG91Q" im password-Feld ein.
    And Der Benutzer  klickt auf die SING IN Button.

  Scenario: TC_07_01 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" sehen können.
    Then Der Benutzer bestätigt, dass der Reiter Departmen im sich öffnenden Fenster angezeigt wird

  Scenario: TC_07_02 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt im sich öffnenden Fenster auf den Reiter Departments.
    And Es wird bestätigt, dass der Reiter Departments angeklickt wurde.

  Scenario: TC_07_03 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt im sich öffnenden Fenster auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden

  @Department1
  Scenario: TC_07_04 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt im sich öffnenden Fenster auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden
    And Es wird bestätigt, dass im geöffneten Fenster die berechtigten Rollen aufgelistet sind.








