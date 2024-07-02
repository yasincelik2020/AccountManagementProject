@Profile
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
    Scenario Outline: TC_04_02,TC_04_03,TC_04_04,TC_04_05,TC_04_06

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

    @email
    Scenario: TC_04_07 Im Profilmodul,E-Mail darf nicht geändert werden.

      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And Klicken Sie auf das Kästchen, um die E-Mail-Adresse zu ändern.
      Then ist ersichtlich, dass das Kästchen nicht angeklickt und daher nicht geändert werden kann.

    @name
    Scenario:
      Given Klicken Sie auf das Profilmodul in der Seitenleiste.
      And Klicken Sie auf die Stiftschaltfläche, um Änderungen vorzunehmen.
      And Klicken Sie auf das Feld Username, um den Namen zu ändern.
      When Testdaten werden in das Feld "testad" eingegeben.
      And Klicken Sie auf das Pfeilsymbol.
      Then Es ist ersichtlich, dass sich der Name mit den von uns eingegebenen Testdaten "testad" ändert.

