Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3001@gmail.com" ein
    And Benutzer gibt gültiges "tOGuL29qh-UuNOb" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist


  @Ignore
  Scenario: TC_15_01 und TC_15_02 Neues Mitglied hinzufügen und überprüfen
    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    When Der Benutzer klickt auf der Users Seite auf den +Add New Member Button.
    And Der Benutzer waehlt eine Abteilung aus dem Dropdown-Menü aus.
    And Der Benutzer waehlt eine Rolle aus dem Dropdown-Menü aus.
    And Der Benutzer gibt eine gültige E-Mail-Adresse im E-Mail-Feld ein.
    And Der Benutzer klickt auf den Register Button.
    And Der Benutzer überprüft, ob die Nachricht successful im geöffneten Pop-up-Fenster angezeigt wird.
    And Der Benutzer clickt auf Close Button
    And Der Benutzer verifiziert, dass die E-Mail des zuletzt hinzugefügten Benutzers angezeigt wird."

  @Ignore
  Scenario: TC_16_03 Der im Benutzermodul registrierte Benutzername darf nicht leer sein.

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Given Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    And Klicken Sie auf die Schaltfläche Bearbeiten
    And Auf der Seite, die geöffnet wird, wird der Benutzername im Feld Benutzername gelöscht.
    And Stellen Sie sicher, dass die Meldung „Username cannot be empty“ angezeigt wird

  @Ignore
  Scenario: TC_16_04, TC_16_05, TC_16_06 Das registrierte Benutzerpasswort im Benutzermodul kann zurückgesetzt werden und abmelden dann wieder anmelden.

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Then Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    Then Klicken Sie auf der sich öffnenden Benutzerseite auf „Reset Password“.
    And Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf „Confirm“.
    And Es wird bestätigt, dass das neue POP-UP, das geöffnet wird, „Reset password successfully“ enthält.
    And Klicken Sie auf dem sich öffnenden POP-UP-Bildschirm auf „Close“.
    And Der Benutzer muss abgemelted sein
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges Email ein
    And Benutzer gibt gültiges Password ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist

  @Aktiv
  Scenario: TC_16_07 Kullaniciya başka roller eklenebilir

    Given Der Benutzer klickt auf der Startseite auf den Users Button.
    Then Klicken Sie auf der sich öffnenden Seite auf den Benutzernamen des zuletzt hinzugefügten Benutzers.
    And Klicken Sie auf der sich öffnenden Benutzerseite auf das + Symbol neben der Überschrift „Rollen“.
    And Klicken Sie im Dropdown-Menü des Popup-Bildschirms auf das Feld „Rolle auswählen“.
    And Klicken Sie auf die Schaltfläche Speichern.
    And Stellen Sie sicher, dass die neu hinzugefügte Rolle „Vertriebsmanager“ neben der Standardrolle hinzugefügt wurde.
    And Schliesssen Sie Information




