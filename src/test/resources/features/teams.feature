@RegressionT
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3006@gmail.com" ein
    And Benutzer gibt gültiges "TwK89PRl1q4GgXf" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist

  Scenario: TC_13_01 Der Benutzer überprüft, ob die Teams-Schaltfläche angezeigt wird, und klickt im Menü auf der linken Seite darauf.
    Given „Teams“ wird im Modul links angezeigt.
    When Die Schaltfläche „Teams“ wird angeklickt.
    And Das Wort „Teams“ erscheint oben links.

  Scenario: TC_13_02 Der Benutzer überprüft, ob die Schaltfläche „Neues Team hinzufügen“ angezeigt und im Teams-Modul angeklickt wird.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Die Schaltfläche „Neues Team hinzufügen“ erscheint.
    Then Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.

  Scenario: TC_13_03 „Abteilungsname“ muss ausgefüllt werden, wenn ein neues Team zum Teams-Modul hinzugefügt wird. Wenn dieses Feld nicht ausgefüllt ist, sollte keine Neuregistrierung durchgeführt werden.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.
    And Das Textfeld „Abteilungsname“ bleibt leer.
    And Das Textfeld „Abteilungskurzname“ ist ausgefüllt.
    And „Abteilungstyp“ ist als Team ausgewählt.
    And Trifft eine Auswahl für „Abteilungsrollen“.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass „Bitte geben Sie einen Namen für die Abteilung ein“ im Textfeld „Abteilungsname“ steht.

  Scenario: TC_13_04 Beim Hinzufügen eines neuen Teams zum Teams-Modul muss „Abteilungstyp“ ausgefüllt werden. Wenn dieses Feld nicht ausgefüllt ist, sollte keine Neuregistrierung durchgeführt werden.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.
    And Das Textfeld „Abteilungsname“ ist ausgefüllt.
    And Das Textfeld „Abteilungskurzname“ ist ausgefüllt.
    And Das Feld „Abteilungstyp“ bleibt leer.
    And Trifft eine Auswahl für „Abteilungsrollen“.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass unter dem Textfeld „Abteilungsname“ „Bitte wählen Sie einen Typ für die Abteilung“ steht.

  Scenario: TC_13_05 Beim Hinzufügen eines neuen Teams zum Teams-Modul sollte es nicht zwingend erforderlich sein, das Feld „Abteilungskurzname“ auszufüllen. Sollte dieses Feld nicht ausgefüllt sein, muss eine Neuanmeldung erfolgen.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.
    And Das Textfeld „Abteilungsname“ ist ausgefüllt.
    And Das Textfeld „Abteilungskurzname“ bleibt leer.
    And „Abteilungstyp“ ist als Team ausgewählt.
    And Trifft eine Auswahl für „Abteilungsrollen“.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird bestätigt, dass die neue Abteilung zum Modul „Abteilungen“ hinzugefügt wurde. Auf dem Bildschirm erscheint „Neue Abteilung erfolgreich erstellt“..

  Scenario: TC_13_06 Beim Hinzufügen eines neuen Teams zum Teams-Modul sollte es nicht zwingend erforderlich sein, das Feld „Abteilungsbeschreibung“ auszufüllen. Sollte dieses Feld nicht ausgefüllt sein, muss eine Neuanmeldung erfolgen.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.
    And Das Textfeld „Abteilungsname“ ist ausgefüllt.
    And Das Textfeld „Abteilungskurzname“ ist ausgefüllt.
    And „Abteilungstyp“ ist als Team ausgewählt.
    And Das Feld „Abteilungsbeschreibung“ bleibt leer.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird bestätigt, dass die neue Abteilung zum Modul „Abteilungen“ hinzugefügt wurde. Auf dem Bildschirm erscheint „Neue Abteilung erfolgreich erstellt“..

  Scenario: TC_13_07 Beim Hinzufügen eines neuen Teams zum Teams-Modul sollte es nicht zwingend erforderlich sein, das Feld „Abteilungsrollen“ auszufüllen. Sollte dieses Feld nicht ausgefüllt sein, muss eine Neuanmeldung erfolgen.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf die Schaltfläche „Neues Team hinzufügen“.
    And Das Textfeld „Abteilungsname“ ist ausgefüllt.
    And Das Textfeld „Abteilungskurzname“ ist ausgefüllt.
    And „Abteilungstyp“ ist als Team ausgewählt.
    And „Abteilungsrollen“ ist nicht ausgewählt.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird bestätigt, dass die neue Abteilung zum Modul „Abteilungen“ hinzugefügt wurde. Auf dem Bildschirm erscheint „Neue Abteilung erfolgreich erstellt“..

  Scenario: TC_14_01 Der Benutzer überprüft, ob „Abteilungsname“ im Teams-Modul bearbeitet werden kann.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf eines der angezeigten Teams.
    And Klicken Sie auf die Schaltfläche „Team bearbeiten“.
    And „Abteilungsname“ wird neu angeordnet.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Der Text „Änderungen erfolgreich gespeichert“ wird angezeigt.

  Scenario: TC_14_02 Der Benutzer überprüft, ob „Kurzname“ im Teams-Modul bearbeitet werden kann.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf eines der angezeigten Teams.
    And Klicken Sie auf die Schaltfläche „Team bearbeiten“.
    And „Kurzname“ wird neu angeordnet.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Der Text „Änderungen erfolgreich gespeichert“ wird angezeigt.

  Scenario: TC_14_03 Der Benutzer überprüft, ob „Abteilungstyp“ im Teams-Modul bearbeitet werden kann.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf eines der angezeigten Teams.
    And Klicken Sie auf die Schaltfläche „Team bearbeiten“.
    And „Abteilungstyp“ wird neu angeordnet.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Der Text „Änderungen erfolgreich gespeichert“ wird angezeigt.

  Scenario: TC_14_04 Der Benutzer stellt sicher, dass „Abteilungsname“, wenn er beim Bearbeiten eines Teams im Teams-Modul leer gelassen wird, nicht bearbeitet werden kann.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf eines der angezeigten Teams.
    And Klicken Sie auf die Schaltfläche „Team bearbeiten“.
    And „Abteilungsname“ wird gelöscht.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass „Bitte geben Sie einen Namen für die Abteilung ein“ im Textfeld „Abteilungsname“ steht.

  Scenario: TC_14_05 Der Benutzer stellt sicher, dass der „Abteilungstyp“, wenn er beim Bearbeiten eines Teams im Teams-Modul gelöscht wird, nicht bearbeitet werden kann.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf eines der angezeigten Teams.
    And Klicken Sie auf die Schaltfläche „Team bearbeiten“.
    And „Abteilungstyp“ wird gelöscht.
    And Klicken Sie auf die Schaltfläche „Speichern“.
    Then Es wird angezeigt, dass keine neue Registrierung für das Abteilungsmodul vorgenommen werden kann. Es wird überprüft, dass unter dem Textfeld „Abteilungsname“ „Bitte wählen Sie einen Typ für die Abteilung“ steht.

  Scenario: TC_14_06 Überprüft, ob Benutzerteams gelöscht werden können.
    Given Die Schaltfläche „Teams“ wird angeklickt.
    When Klicken Sie auf eines der angezeigten Teams.
    And Klicken Sie auf die Schaltfläche „Team bearbeiten“.
    And Klicken Sie auf die Schaltfläche „Abteilung löschen“.
    And Klicken Sie auf die Schaltfläche „Bestätigen“.
    And  „Teams“ wird im Modul links angezeigt und kann angeklickt werden.
    Then Welches Team gelöscht wird, wird hier nicht angezeigt.


