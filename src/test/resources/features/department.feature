@Regression @Department
Feature: login

  Background: login
    Given Der Benutzer geht zur URL.
    When Der Benutzer klickt auf den Login Button
    And Auf dem sich öffnenden Bildschirm gibt der Benutzer eine gültige E-Mail-Adresse "dsdt3003@gmail.com" im E-Mail-Feld ein.
    And Der Benutzer gibt eine gültige Password "eY6gcuXtneNG91Q" im password-Feld ein.
    And Der Benutzer  klickt auf die SING IN Button.

  Scenario: TC_07_01 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" sehen können.
    Then Der Benutzer bestätigt, dass der Reiter Departmen im sich öffnenden Fenster angezeigt wird.

  Scenario: TC_07_02 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass der Reiter Departments angeklickt wurde.

  Scenario: TC_07_03 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.

  @Department1
  Scenario: TC_07_04 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.
    And Es wird bestätigt, dass im geöffneten Fenster die berechtigten Rollen aufgelistet sind.
  @Department2
  Scenario: TC_08_01  Der Benutzer sollte den Button Add New Department sehen können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Im geöffneten Fenster wird die Schaltfläche Add New Department angezeigt.
  @Department2
  Scenario: TC_08_02  Der Benutzer sollte auf die Schaltfläche Add New Department klicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Es wird bestätigt, dass die Schaltfläche Add New Department geklickt wurde.
  @Department2
  Scenario: TC_08_03 Es sollte möglich sein, im Department-Modul eine neue department hinzuzufügen.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer füllt das Textfeld Department Name aus.
    And Der Benutzer füllt das Textfeld Department Short Name aus.
    And Der Benutzer wählt als Department Type die Option Department.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde (Auf dem Bildschirm erscheint die Nachricht New department successfully created).
  @Department2
  Scenario: TC_08_04 Beim Hinzufügen einer neuen Department muss das Feld Department Name obligatorisch ausgefüllt werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer lässt das Textfeld Department Name leer.
    And Der Benutzer füllt das Textfeld Department Short Name aus.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird angezeigt, dass im Department Modul keine neue Aufzeichnung erstellt werden konnte.













