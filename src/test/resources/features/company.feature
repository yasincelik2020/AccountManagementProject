@Company @US06 @Smoke
Feature: Profile
  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3005@gmail.com" ein
    And Benutzer gibt gültiges "123Asdf.%" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist

  @companyName
  Scenario: TC_06_01 Im Modul Firma muss darauf geachtet werden, dass der Name zwingend eingegeben werden muss.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Die Informationen im Feld „Name“ werden gelöscht, sodass es leer bleibt.
    And Klicken Sie auf die Schaltfläche Save
    Then Es wird die Warnmeldung "Please enter a name for company" angezeigt.

  @companyEmail
  Scenario: TC_06_02 Im Modul Firma muss überprüft werden, dass die E-Mail-Adresse obligatorisch eingegeben werden muss.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Die Informationen im Feld E-Mail-Postfach werden gelöscht, sodass es leer bleibt.
    And Klicken Sie auf die Schaltfläche Save
    Then Es wird die Warnmeldung "Please enter a email for company" angezeigt.

  @companyNameChange
  Scenario: TC_06_03 Im Firmenmodul sollte ersichtlich sein, dass der Name mit den von uns ausgewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Klicken Sie auf das Feld „Name“, um den Namen zu ändern.
    And Testdaten "testname" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für CompanyName "testname" ändert.

  @companyShortNameChange
  Scenario: TC_06_04 Im Firmenmodul sollte ersichtlich sein, dass der Kurzname mit den von uns ausgewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Um den Kurznamen zu ändern, klicken Sie auf das Feld „Kurzname“.
    And Testdaten "testshortname" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für CompanyShortName "testshortname" ändert.


  @companyWebsiteChange
  Scenario: TC_06_05 Im Firmenmodul sollte ersichtlich sein, dass die Website mit den von uns ausgewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Klicken Sie auf das Feld Website, um die Website zu ändern.
    And Testdaten "testwebsite" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Website  "testwebsite" ändert.

  @companyTelefonNummerChange
  Scenario: TC_06_06 Im Firmenmodul sollte ersichtlich sein, dass die Telefonnummer mit den von uns ausgewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Klicken Sie auf das Feld „Telefon“ in Company Modul, um die Telefonnummer zu ändern.
    And Testdaten "496352364" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Telefonnummer  "496352364" ändert.

  @companyTelefonNummerChange
  Scenario: TC_06_06 Im Firmenmodul sollte ersichtlich sein, dass die Telefonnummer mit den von uns ausgewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Klicken Sie auf das Feld „Telefon“ in Company Modul, um die Telefonnummer zu ändern.
    And Testdaten "496352364" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Telefonnummer  "496352364" ändert.

  @companyFaxNummerChange
  Scenario: TC_06_07 Im Firmenmodul sollte ersichtlich sein, dass  die Faxnummer mit den von uns gewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Klicken Sie auf das Feld „Fax“, um die Faxnummer zu ändern.
    And Testdaten "4963865425" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die Faxnummer  "4963865425" ändert.

  @companyAddressChange
  Scenario: TC_06_08 Im Firmenmodul sollte ersichtlich sein, dass  die Adresse mit den von uns ausgewählten Daten geändert werden kann.

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Klicken Sie auf das Feld „Adresse“, um die Adresse zu ändern.
    And Testdaten "testadres" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für die  die Adresse  "testadres" ändert.

  @companyCountryChange
  Scenario: TC_06_09 Im Firmenmodul sollte ersichtlich sein, dass  das Land mit den von uns ausgewählten Daten geändert werden kann

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Um das Land zu ändern, wählen Sie das Land aus dem Dropdown-Menü aus.
    And Testdaten "France" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für das Land  "France" ändert.

  @companyStatusChange
  Scenario: TC_06_10 Im Firmenmodul sollte ersichtlich sein, dass  der Status geändert werden kann

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Um den Statusstatus zu ändern, wählen Sie den Status aus dem Dropdown-Menü aus.
    And Testdaten "Active" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für den Status  "Active" ändert.

  @companyCurrencyChange
  Scenario: TC_06_11 Im Firmenmodul sollte ersichtlich sein, dass der Währungsstatus geändert werden kann

    Given Klicken Sie in der Seitenleiste auf das Firmenmodul
    When Klicken Sie auf die Schaltfläche Edit
    And Um den Währungsstatus zu ändern, wählen Sie den Status aus dem Dropdown-Menü aus.
    And Testdaten "Euro" werden in das Feld „Name“ eingegeben.
    And Klicken Sie auf die Schaltfläche Save
    Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten für den Währungsstatus  "Euro" ändert.