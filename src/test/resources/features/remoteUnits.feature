@Regression @RemoteUnits
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And  Der Benutzer gibt ein gültiges "dsdt3008@gmail.com" ein
    And Benutzer gibt gültiges "8vBaNs-OtsZyQW1" ein
    And Klick auf die Schaltflueche Login

  @US_10
  Scenario: TC_10_01 Nach der Anmeldung sollte der Benutzer auf dem Bildschirm den Reiter "Remote Units" sehen können
    And Klick auf die Schaltflueche acilirOk
    And Der Benutzer bestätigt, dass der Reiter Remote Units im geöfnetetn Bildschirm angezeigt wird.

  @US_10
  Scenario: TC_10_02 Nach der Anmeldung sollte der Benutzer den Reiter Remote Units anklicken können.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde

  @US_10
  Scenario: TC_10_03 Der Benutzer kann sehen, dass die Seite Remote Unit geöffnet wird
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Es ist zu sehen, dass die Seite des Remote Units geöffnet wird.

  @US_10
  Scenario: TC_10_04 Der Benutzer sollte registrierte Remote Units sehen können
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Es wird bestätigt, dass  die gespeicherten Remote Units angezeigt werden

  @US_10
  Scenario: TC_10_05 Der Benutzer sollte registrierte Remote Units anklicken können
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Es wird bestätigt, dass die gespeicherte Remote Units angeklickt wurde

  @US_10
  Scenario: TC_10_06 Der Benutzer sollte registrierte Remote Units listen können
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Es wird bestätigt, dass die gespeicherte Remote Units aufgelistet wurde.

  @US_11
  Scenario: TC_11_01 Der Benutzer sollte  die Schaltfläche Add New Remote Unit anzeigen.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer sieht die Schaltfläche Add New Remote Unit

  @US_11
  Scenario: TC_11_02 Der Benutzer sollte  die Schaltfläche "Add New Remote Unit" anklicken.
    And  Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.

  @US_11
  Scenario: TC_11_03 Der Benutzer fühlt auf der Seite New Remote Unit kann das Feld "Name" aus.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Name aus.

  @US_11
  Scenario: TC_11_04 Der Benutzer fühlt auf der Seite New Remote Unit kann das Feld "Short Name" aus.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Short Name aus.

  @US_11
  Scenario: TC_11_05 Der Benutzer fühlt auf der Seite New Remote Unit kann das Feld "Deparment Type" aus.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Deparment Type aus.

  @US_11
  Scenario: TC_11_06 Der Benutzer fühlt auf der Seite New Remote Unit kann das Feld "Description" aus.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Description aus.

  @US_11
  Scenario: TC_11_07 Der Benutzer fühlt auf der Seite New Remote Unit kann das Feld "Roles" aus.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Roles aus.

  @US_11
  Scenario: TC_11_08 Die erforderlichen Felder ausgefüllt sind, wird das Registrierungsformular versendet werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Name aus.
    And Der Benutzer füllt das Textfeld Short Name aus.
    And Der Benutzer füllt das Textfeld Deparment Type aus.
    And Der Benutzer füllt das Textfeld Description aus.
    And Der Benutzer füllt das Textfeld Roles aus.
    And Der Benutzer klickt auf die Schaltfläche Save an

  @US_11
  Scenario: TC_11_09 Der Benutzer sollte sehen können, dass er das Registrierungsformular gesendet hat.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Name aus.
    And Der Benutzer füllt das Textfeld Short Name aus.
    And Der Benutzer füllt das Textfeld Deparment Type aus.
    And Der Benutzer füllt das Textfeld Description aus.
    And Der Benutzer füllt das Textfeld Roles aus.
    And Der Benutzer klickt auf die Schaltfläche Save an
    And  Der Benutzer zeigt auf Popup-Bildschirm den Text successfully an.

  @US_11
  Scenario: TC_11_10 Der Benutzer zeigt ein Warntext an, wenn das Formular gespeichert wird, ohne das Feld "Departmen Type" auszufüllen.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld Name aus.
    And Der Benutzer füllt ohne das Textfeld Deparment Type aus.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Der Benutzer sieht den Warntext.

  @US_11
  Scenario: TC_11_11 Der Benutzer zeigt ein Warntext an, wenn das Formular gespeichert wird, ohne das Feld "Name" auszufüllen.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt ohne das Textfeld Name aus.
    And Der Benutzer füllt das Textfeld Deparment Type aus.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Der Benutzer sieht den WarntextName.
  @US_11
  Scenario: TC_11_12 Ein zuvor hinzugefügtes Remote Unit(mit denselben Informationen) kann nicht auf der Seite New Remote Unit hinzugefügt werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer klickt auf die Schaltfläche Add New Remote Units an.
    And Der Benutzer füllt das Textfeld "Roles" aus.
      ## ************** BURAYI DÜZENLE *************
    And Der Benutzer klickt auf die Schaltfläche Save.
    And  Der Benutzer zeigt Popup-Bildschirm wird den Text successfully an.

  @US_12
  Scenario: TC_12_01 Der Benutzer sollte gespeicherte Remote Units sehen können.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer sieht die registrierten Remote Units

  @US_12
  Scenario: TC_12_02 Der Benutzer sollte gespeicherte Remote Units klicken können.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And Der Benutzer sieht die registrierten Remote Units
    And  Der Benutzer klickt auf die registrierte Remote Units

  @US_12
  Scenario: TC_12_03 Der Benutzer sollte die Schaltfläche "Edit Remote Unit" sehen können.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer sieht die Schaltfläche Edit Remote Unit

  @US_12
  Scenario: TC_12_04 Der Benutzer sollte die Schaltfläche "Edit Remote Unit" anklicken können.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit

  @US_12
  Scenario: TC_12_05 Aenderungen sollten am Feld "Name" auf der Seite "Edit Remote Unit" vorgenommen werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Name andern

  @US_12
  Scenario: TC_12_06 Aenderungen sollten am Feld "Short Name" auf der Seite "Edit Remote Unit" vorgenommen werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Short Name andern

  @US_12
  Scenario: TC_12_07 Aenderungen sollten am Feld "Department Type" auf der Seite "Edit Remote Unit" vorgenommen werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Department Type andern

  @US_12
  Scenario: TC_12_08 Aenderungen sollten am Feld "Description" auf der Seite "Edit Remote Unit" vorgenommen werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Description andern

  @US_12
  Scenario: TC_12_09 Aenderungen sollten am Feld "Roles" auf der Seite "Edit Remote Unit" vorgenommen werden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Roles andern

  @US_12
  Scenario: TC_12_10 Nach Aenderungen klickt der Benutzer auf die Schaltfläche Save.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Name andern
    And  Der Benutzer kann das Textfeld Short Name andern
    And  Der Benutzer kann das Textfeld Department Type andern
    And  Der Benutzer kann das Textfeld Description andern
    And  Der Benutzer kann das Textfeld Roles andern

  @US_12
  Scenario: TC_12_11 Auf der Seite Edit Remote Unit wird überprüft, ob die vorgenommenen Änderungen übernommen wurden.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Name andern
    And  Der Benutzer kann das Textfeld Short Name andern
    And  Der Benutzer kann das Textfeld Department Type andern
    And  Der Benutzer kann das Textfeld Description andern
    And  Der Benutzer kann das Textfeld Roles andern
    And  Der Benutzer zeigt Popup-Bildschirm wird der Text successfully an.

  @US_12
  Scenario: TC_12_12 Wenn Sie sich auf der Seite Edit Remote Unit befinden, sehen Sie die Schaltfläche "Edit", um mit den Änderungen fortzufahren.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And Der Benutzer sieht die Schaltfläche Edit, um neue Änderungen vorzunehmen, ohne die Seite zu verlassen.

  @US_12
  Scenario: TC_12_13 Auf der Seite Edit Remote Unit wird auf die Schaltfläche "Edit" geklickt, um mit den Änderungen fortzufahren.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And Der Benutzer klickt die Schaltfläche Edit, um neue Änderungen vorzunehmen, ohne die Seite zu verlassen.

  @US_12
  Scenario: TC_12_14 Auf der Seite Edit Remote Unit wird ein Warntext angezeigt, wenn das Formular gespeichert wird, ohne das Feld "Department Type" auszufüllen.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann das Textfeld Name andern
    And  Der Benutzer kann das Textfeld Short Name andern
    And  Der Benutzer kann ohne das Textfeld Department Type andern
    And  Der Benutzer kann das Textfeld Description andern
    And  Der Benutzer kann das Textfeld Roles andern
    And Der Benutzer klickt auf die Schaltfläche Save.

  @US_12
  Scenario: TC_12_15 Auf der Seite Edit Remote Unit wird ein Warntext angezeigt, wenn das Formular gespeichert wird, ohne das Feld "Name" auszufüllen.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And  Der Benutzer kann ohne das Textfeld Name andern
    And  Der Benutzer kann das Textfeld Short Name andern
    And  Der Benutzer kann das Textfeld Department Type andern
    And  Der Benutzer kann das Textfeld Description andern
    And  Der Benutzer kann das Textfeld Roles andern
    And Der Benutzer klickt auf die Schaltfläche Save.

  @US_12
  Scenario: TC_12_16 Wenn ein im Departments modul gespeichertes Department erneut bearbeitet wird, wurde festgestellt, dass der Benutzer das Bild des Departments nicht ändern oder hinzufügen und die Bearbeitung nicht vornehmen konnte.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And Der Benutzer klickt auf die Schaltfläche Change Image
    And Es wird ein Foto aus dem Browser oder vom Computer ausgewählt und auf die Schaltfläche Öffnen geklickt.
    And Das Foto wird ausgewaehlt und auf die Schaltfläche Crop geklickt.
    And Der Benutzer klickt auf die Schaltfläche Save.
    And Der Benutzer sieht den Warntext.

  @US_12
  Scenario: TC_12_17 Ein auf der Seite des Remote Units registriertes Remote Unit wird gelöscht.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And Der Benutzer klickt die Schaltfläche Delete Department.

  @US_12
  Scenario: TC_12_18 Es scheint, dass ein auf der Seite des Remote Units gespeichertes Remote Unit gelöscht wurde.
    And Klick auf die Schaltflueche acilirOk
    And Es wird bestätigt, dass der Reiter Remote Units angeklickt wurde
    And  Der Benutzer klickt auf die registrierte Remote Units
    And  Der Benutzer klickt die Schaltfläche Edit Remote Unit
    And Der Benutzer klickt die Schaltfläche Delete Department.
    And Der Benutzer zeigt Popup-Bildschirm wird den Text successfully an.














































