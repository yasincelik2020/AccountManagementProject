@Profile @US04
  Feature: Profile
    Background: login
      Given Der Benutzer geht zur URL
      When Klickt auf die Schaltflueche Login
      And Der Benutzer gibt ein gültiges "dsdt3005@gmail.com" ein
      And Benutzer gibt gültiges "123Asdf.%" ein
      And Klick auf die Schaltflueche Login
      And Der Benutzer bestaetigt, dass er auf HomePageSD ist


    @Password
    Scenario: TC_04_01 Das Passwort darf nur Großbuchstaben (A-Z), Kleinbuchstaben (a-z), Zahlen (0-9) und die Sonderzeichen .@#$%_& enthalten.

      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      When Klicken Sie auf die Schaltfläche „Passwort ändern“.
      And Das Passwort in den Testdaten, das die Zeichen "123QWEqwe.[]" enthält, wird in das Feld „Neues Passwort“ eingegeben.
      And Das Passwort in den Testdaten, das die Zeichen "123QWEqwe.[]" enthält, wird im zweiten Feld „Neues Passwort“ erneut eingegeben.
      And Klicken Sie auf die Schaltfläche „Bestätigen“.
      Then Sie sehen eine Warnmeldung, die besagt, dass das Passwort ungültig ist.
      And Schließen die Warnung.

    @Password
    Scenario Outline: TC_04_02,TC_04_03,TC_04_04,TC_04_05,TC_04_06,TC_04_16

      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      When Klicken Sie auf die Schaltfläche „Passwort ändern“.
      And Das Passwort in den Testdaten, das die Zeichen "<password1>" enthält, wird in das Feld „Neues Passwort“ eingegeben.
      And Das Passwort in den Testdaten, das die Zeichen "<password2>" enthält, wird im zweiten Feld „Neues Passwort“ erneut eingegeben.
      And Klicken Sie auf die Schaltfläche „Bestätigen“.
      Then Sie sehen eine "<alert_message>", die besagt, dass das Passwort ungültig ist.
      And Schließen die Warnung.

      Examples: customer credentials
        | password1  | password2  | alert_message                                         |
        | 1234       | 1234       | Password must be between 8 to 20 characters long.     |
        | 123asdqwe. | 123asdqwe. | Password must contain at least one uppercase.         |
        | 123ASDQWE. | 123ASDQWE. | Password must contain at least one lowercase.         |
        | ASDQWef.   | ASDQWef.   | Password must contain at least one digit.             |
        | 123QWEqwe  | 123QWEqwe  | Password must contain special characters from .@#$%_& |
        | 123QWEqwe.  | 123QWEqwe,| Password and repetition does not match                |

    @email
    Scenario: TC_04_07 Im Profilmodul,E-Mail darf nicht geändert werden.

      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And Klicken Sie auf das Kästchen, um die E-Mail-Adresse zu ändern.
      Then ist ersichtlich, dass das Kästchen nicht angeklickt und daher nicht geändert werden kann.

    @username
    Scenario: TC_04_08 Im Profilmodul,es sollte ersichtlich sein, dass der Username mit den von uns eingegebenen Daten geändert werden kann.
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And Klicken Sie auf das Feld Username, um den Namen zu ändern.
      When Testdaten werden in das Feld "test" eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten "test" ändert.
      And Schließen die WarnungAlert.

    @name
    Scenario: TC_04_09 Im Profilmodul,es sollte ersichtlich sein, dass der Name mit den von uns eingegebenen Daten geändert werden kann.
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And  Klicken Sie auf das Feld „Name“, um den Namen zu ändern..
      When Testdaten werden in das NameFeld "testad" eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich der NameFeld mit den von uns eingegebenen Testdaten "testad" ändert.
      And Schließen die WarnungAlert.

    @lastname
    Scenario: TC_04_10 Im Modul Profil, es sollte ersichtlich sein, dass der Nachname mit den eingegebenen Daten geändert werden kann
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And  Klicken Sie auf das Feld „Nachname“, um den Nachnamen zu ändern.
      When Die Testdaten werden in das Feld „Nachname“ "testsoyad" eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich der Nachname mit den von uns eingegebenen Testdaten "testsoyad" ändert.
      And Schließen die WarnungAlert.

    @address
    Scenario: TC_04_11 Im Modul Profil, es sollte ersichtlich sein, dass die Adresse mit den von uns eingegebenen Daten geändert werden kann
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And  Klicken Sie auf das Feld „Adresse“ , um die Adresse zu ändern.
      When Testdaten "testadres" werden in das Adressfeld eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich die Adresse mit den von uns eingegebenen Testdaten "testadres" ändert.
      And Schließen die WarnungAlert.

    @country
    Scenario: TC_04_12 Im Modul Profil, Es sollte ersichtlich sein, dass das Land mit den von uns ausgewählten Daten geändert werden kann
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And  Um das Land zu ändern, wählen Sie Testdaten aus dem Dropdown-Menü aus.
      When Testdaten "Germany" werden in das Landfeld eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich der Land mit den von uns eingegebenen Testdaten "Germany" ändert.
      And Schließen die WarnungAlert.

    @phone
    Scenario: TC_04_13 Im Modul Profil, Es sollte ersichtlich sein, dass  die Telefonnummer mit den von uns eingegebenen Daten geändert werden kann
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And  Klicken Sie auf das Feld „Telefon“, um die Telefonnummer zu ändern.
      When Testdaten "+49636353252" werden in die Telefonbox eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich die Telefonnummer mit den von uns eingegebenen Testdaten "49636353252" ändert.
      And Schließen die WarnungAlert.

    @passwordPositiveTest
    Scenario: TC_04_16 Im Modul Profil sollte die Meldung "Password and repetition does not match" erscheinen, wenn im ersten Abschnitt Passwort und im zweiten Bestätigungsabschnitt unterschiedliche Passwörter aus den Testdaten eingegeben werden.

      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      When Klicken Sie auf die Schaltfläche „Passwort ändern“.
      And Das Passwort in den Testdaten, das die Zeichen "123Asdf.%" enthält, wird in das Feld „Neues Passwort“ eingegeben.
      And Das Passwort in den Testdaten, das die Zeichen "123Asdf.%" enthält, wird im zweiten Feld „Neues Passwort“ erneut eingegeben.
      And Klicken Sie auf die Schaltfläche „Bestätigen“.
      Then Sie sehen eine WarnAlertmeldung "Change password successfully", die besagt, dass das Passwort erfolgreich geändert.
      And Schließen die WarnungAlert.