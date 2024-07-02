@Regression
Feature: login

  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login

  Scenario: TC_10_01 Nach der Anmeldung sollte der Benutzer auf dem Bildschirm den Reiter "Remote Units" sehen können.
Given  Der Benutzer gibt ein gültiges "dsdt3008@gmail.com" ein
And Benutzer gibt gültiges "8vBaNs-OtsZyQW1" ein
And Klick auf die Schaltflueche Login
And Klick auf die Schaltflueche "acilirOk"
And Der Benutzer bestätigt, dass der Reiter 'Remote Units' im geöfnetetn Bildschirm angezeigt wird.
Then  Es wird bestätigt, dass der Reiter 'Remote Units' angeklickt wurde.