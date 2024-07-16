@Smoke @Regression
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3001@gmail.com" ein
    And Benutzer gibt gültiges "tOGuL29qh-UuNOb" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist


  @Smoke
  Scenario: TC_15_01, TC_15_02 und TC_17_01 Neues Mitglied hinzufügen, überprüfen und loschen
    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    When Der Benutzer klickt auf der Users Seite auf den +Add New Member Button.
    And Der Benutzer waehlt eine Abteilung aus dem Dropdown-Menü aus.
    And Der Benutzer waehlt eine Rolle aus dem Dropdown-Menü aus.
    And Der Benutzer gibt eine gültige E-Mail-Adresse im E-Mail-Feld ein.
    And Der Benutzer klickt auf den Register Button.
    And Der Benutzer überprüft, ob die Nachricht successful im geöffneten Pop-up-Fenster angezeigt wird.
    And Der Benutzer clickt auf Close Button
    And Der Benutzer verifiziert, dass die E-Mail des zuletzt hinzugefügten Benutzers angezeigt wird."
    Then Klicken Sie auf die drei Punkte am Ende der neu hinzugefügten Benutzerzeile.
    And Klicken Sie auf dem sich öffnenden Bildschirm auf „Aus Organisation entfernen“.
    And Es wird bestätigt, dass das neue POP-UP, das geöffnet wird, „Selected user removed“ enthält.

  @Regression
  Scenario: TC_16_03 Der im Benutzermodul registrierte Benutzername darf nicht leer sein.

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Given Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    And Klicken Sie auf die Schaltfläche Bearbeiten
    And Auf der Seite, die geöffnet wird, wird der Benutzername im Feld Benutzername gelöscht.
    And Stellen Sie sicher, dass die Meldung „Username cannot be empty“ angezeigt wird

  @Regression
  Scenario: TC_16_04, TC_16_05, TC_16_06 Das registrierte Benutzerpasswort im Benutzermodul kann zurückgesetzt werden und abmelden dann wieder anmelden.

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Then Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    Then Klicken Sie auf der sich öffnenden Benutzerseite auf „Reset Password“.
    And Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf Confirm
    And Es wird bestätigt, dass das neue POP-UP, das geöffnet wird, „Reset password successfully“ enthält.
    And Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf „Close“.
    And Der Benutzer muss abgemelted sein
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges Email ein
    And Benutzer gibt gültiges Password ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist

  @Regression
  Scenario: TC_16_07 Dem Benutzer können weitere Rollen hinzugefügt werden und loschen

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Then Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    And Klicken Sie auf der sich öffnenden Benutzerseite auf das + Symbol neben der Überschrift „Rollen“.
    And Klicken Sie im Dropdown-Menü des Popup-Bildschirms auf das Feld „Rolle auswählen“.
    And Klicken Sie auf die Schaltfläche Speichern.
    And Stellen Sie sicher, dass die neu hinzugefügte Rolle „Vertriebsmanager“ neben der Standardrolle hinzugefügt wurde.
    And Schliesssen Sie Information
    And Click drei Punkte auf die neu Role
    And Click auf Remove Role
    And Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf Confirm
    And Schliesssen Sie Information

  @Regression
  Scenario: TC_16_08 Der Benutzername muss mit Buchstaben beginnen (A-Za-z)

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Given Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    And Klicken Sie auf die Schaltfläche Bearbeiten
    And Auf der Seite, die geöffnet wird, wird der Benutzername im Feld Benutzername gelöscht.
    And Der Benutzer gibt einen Benutzernamen ein, der nur aus Zahlen besteht
    And Der Benutzer clickt auf der Bestautigung Button
    And User information updated successfully wird nicht bestätigt.

