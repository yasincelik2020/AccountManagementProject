@Regression @RemoteUnits
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And  Der Benutzer gibt ein gültiges "dsdt3008@gmail.com" ein
    And Benutzer gibt gültiges "8vBaNs-OtsZyQW1" ein
    And Klick auf die Schaltflueche Login

  Scenario: TC_10_01 Nach der Anmeldung sollte der Benutzer auf dem Bildschirm den Reiter "Remote Units" sehen können.
    And Klick auf die Schaltflueche "acilirOk"
    Then Der Benutzer bestätigt, dass der Reiter 'Remote Units' im geöfnetetn Bildschirm angezeigt wird.

@US_10
  Scenario: TC_10_02 Nach der Anmeldung sollte der Benutzer auf dem Bildschirm den Reiter "Remote Units" anklicken können.
    And Es wird bestätigt, dass der Reiter 'Remote Units' angeklickt wurde.
  @US_10
  Scenario: TC_10_03 Der Benutzer kann sehen, dass die Seite „Remote Unit“ geöffnet wird.
    And  Es ist zu sehen, dass die Seite des Remote Units geöffnet wird.
  @US_10
  Scenario: TC_10_04 Der Benutzer sollte registrierte Remote Units auf der Seite Remote Units sehen können.
    And Es wird bestätigt, dass  die gespeicherten Remote Units angezeigt werden.
  @US_10
  Scenario: TC_10_05 Der Benutzer sollte registrierte Remote Units auf der Seite Remote Units anklicken können.
    And Es wird bestätigt, dass die gespeicherte 'Remote Units' angeklickt wurde.
  @US_10
  Scenario: TC_10_06 Der Benutzer sollte registrierte Remote Units auf der Seite Remote Units listen können.
    And Es wird bestätigt, dass die gespeicherte 'Remote Units' aufgelistet wurde.









































