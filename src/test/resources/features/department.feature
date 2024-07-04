@Regression @Department
Feature: login

  Background: login
    Given Der Benutzer geht zur URL.
    When Der Benutzer klickt auf den Login Button
    And Auf dem sich öffnenden Bildschirm gibt der Benutzer eine gültige E-Mail-Adresse "dsdt3003@gmail.com" im E-Mail-Feld ein.
    And Der Benutzer gibt eine gültige Password "eY6gcuXtneNG91Q" im password-Feld ein.
    And Der Benutzer  klickt auf die SING IN Button.

  @US_7
  Scenario: TC_07_01 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" sehen können.
    Then Der Benutzer bestätigt, dass der Reiter Departmen im sich öffnenden Fenster angezeigt wird.
  @US_7
  Scenario: TC_07_02 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass der Reiter Departments angeklickt wurde.
  @US_7
  Scenario: TC_07_03 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.
  @US_7
  Scenario: TC_07_04 Der Benutzer sollte auf dem Bildschirm den Reiter "Departments" anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.
    And Es wird bestätigt, dass im geöffneten Fenster die berechtigten Rollen aufgelistet sind.

  @US_8
  Scenario: TC_08_01 TC_08_02 Der Benutzer sollte den Button Add New Department sehen und klicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Im geöffneten Fenster wird die Schaltfläche Add New Department angezeigt.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Es wird bestätigt, dass die Schaltfläche Add New Department geklickt wurde.
  @US_8
  Scenario: TC_08_03 Es sollte möglich sein, im Department-Modul eine neue department hinzuzufügen.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer füllt das Textfeld Department Name aus.
    And Der Benutzer füllt das Textfeld Department Short Name aus.
    And Der Benutzer wählt als Department Type die Option Department.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde.

  @US_8
  Scenario: TC_08_04 Beim Hinzufügen einer neuen Department muss das Feld Department Name obligatorisch ausgefüllt werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer lässt das Textfeld Department Name leer.
    And Der Benutzer füllt das Textfeld Department Short Name aus.
    And Der Benutzer wählt als Department Type die Option Department.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird angezeigt, dass ohne DepartmentName im Department Modul keine neue Aufzeichnung erstellt werden konnte.

  @US_8
  Scenario: TC_08_05 Beim Hinzufügen einer neuen Department muss das Feld Department Type obligatorisch ausgefüllt werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer füllt das Textfeld Department Name aus.
    And Der Benutzer füllt das Textfeld Department Short Name aus.
    And Der Benutzer lässt als Department Type die Option Department leer.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird angezeigt, dass ohne DepartmentType im Department Modul keine neue Aufzeichnung erstellt werden konnte.

  @US_8
  Scenario: TC_08_06 Beim Hinzufügen einer neuen "Department"im Departments-modul muss das Feld Department Short Name nicht zwingend ausgefüllt werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer füllt das Textfeld_ Department Name aus.
    And Der Benutzer lässt das Textfeld Department Short Name leer.
    And Der Benutzer wählt als Department Type die Option Department.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde-


  @US_8
  Scenario: TC_08_07 Beim Hinzufügen einer neuen "Department"im Departments-modul muss das Feld Department Short Name nicht zwingend ausgefüllt werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer füllt das_ Textfeld Department Name aus.
    And Der Benutzer füllt das Textfeld Department Short Name aus.
    And Der Benutzer wählt als Department Type die Option Department.
    And Der Benutzer lässt eine Auswahl für Department Roles leer.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die neue_ Department dem Departmentsmodul hinzugefügt wurde.-

  @US_8
  Scenario: TC_08_08 Im Department-Modul sollte es nicht möglich sein, ein bereits hinzugefügtes Department erneut hinzuzufügen.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die Schaltfläche Add New Department.
    And Der Benutzer füllt das Textfeld Department Name aus_
    And Der Benutzer füllt das Textfeld Department Short Name aus_
    And Der Benutzer wählt als Department Type die Option Department.
    And Der Benutzer trifft eine Auswahl für Department Roles.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die neue Department dem Departmentsmodul hinzugefügt wurde_

  @US_9
  Scenario: TC_09_01 und TC_09_02 und TC_09_03 und TC_09_04  Der Benutzer sollte die Schaltfläche "Edit Department" sehen und anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Es wird bestätigt, dass im Modul Departments die gespeicherten Abteilungen angezeigt werden.
    And Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.
    And Es wird bestätigt, dass die registrierten Departments erfolgreich angeklickt wurden.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Es wird bestätigt, dass die Schaltfläche Edit Department erfolgreich angeklickt wurde.

  @US_9
  Scenario: TC_09_05 Der Benutzer sollte die Schaltfläche "Edit Department" sehen und anklicken können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Der Benutzer füllt das Textfeld Department Name mit den gewünschten Informationen aus.
    And Der Benutzer füllt das Textfeld Short Name mit den gewünschten Informationen aus.
    And Der Benutzer wählt als Department Type die Option Department_
    And Der Benutzer trifft eine Auswahl für Department Roles_
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die Edit Bearbeitung erfolgreich durchgeführt wurde.

  @US_9
  Scenario: TC_09_06 Wenn das Feld Department Name nicht ausgefüllt ist, können keine Änderungen vorgenommen werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Der Benutzer lässt das Textfeld Department Name Informationen leer.
    And Der Benutzer füllt das Textfeld Short Name mit den gewünschten Informationen aus.
    And Der Benutzer wählt als Department Type die Option Department_
    And Der Benutzer trifft eine Auswahl für Department Roles_
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die Edit Bearbeitung nicht durchgeführt wurde.

  @US_9
  Scenario: TC_09_07 Wenn das Feld Department Type nicht ausgefüllt ist, können keine Änderungen vorgenommen werden.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Der Benutzer füllt das Textfeld Department Name mit den gewünschten Informationen aus_
    And Der Benutzer füllt das Textfeld Short Name mit den gewünschten Informationen aus.
    And Der Benutzer lasst als Department Type die Option Department_leer.
    And Der Benutzer trifft eine Auswahl für Department Roles_
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die Edit Bearbeitung nicht durchgeführt wurde_

  @US_9
  Scenario: TC_09_08 Der Bearbeitungsvorgang kann auch dann durchgeführt werden, wenn das Short Name nicht ausgefüllt ist.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Der Benutzer füllt das Textfeld Department Name_mit den gewünschten Informationen aus_
    And Der Benutzer lässt das Textfeld Short Name mit den gewünschten Informationen leer.
    And Der Benutzer wählt als Department Type die Option Department_
    And Der Benutzer trifft eine Auswahl für Department Roles_
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, dass die Edit Bearbeitung erfolgreich durchgeführt_wurde.

  @US_9
  Scenario: TC_09_09 Der Bearbeitungsvorgang kann auch dann durchgeführt werden, wenn das Department Roles nicht ausgefüllt ist.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die gespeicherte Department, die bearbeitet werden soll.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Der Benutzer füllt_das Textfeld Department Name_mit den gewünschten Informationen aus_
    And Der Benutzer füllt das Textfeld Short Name mit den gewünschten Informationen aus.
    And Der Benutzer wählt als Department Type die Option Department_
    And Der Benutzer lässt eine Auswahl für Department Roles leer.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Es wird bestätigt, _dass die Edit Bearbeitung erfolgreich durchgeführt_wurde.

  @US_9
  Scenario: TC_09_11 Eine im Department-Modul gespeicherte Department sollte gelöscht werden können.
    Then Der Benutzer klickt auf den Reiter Departments.
    And Der Benutzer klickt auf die gespeicherte Department, _die bearbeitet werden soll.
    And Der Benutzer klickt auf die Schaltfläche Edit Department.
    And Der Benutzer klickt auf die Schaltfläche Delete Department.
    And Im geöffneten Fenster klickt der Benutzer auf die Schaltfläche Confirm.
    And Es wird bestätigt, dass die Löschung erfolgreich durchgeführt wurde.
















