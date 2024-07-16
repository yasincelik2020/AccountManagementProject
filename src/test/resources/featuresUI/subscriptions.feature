@Subscriptions @US05 @Regression
Feature: Profile
  Background: login
    Given Der Benutzer geht zur URL
    When Klickt auf die Schaltflueche Login
    And Der Benutzer gibt ein gültiges "dsdt3005@gmail.com" ein
    And Benutzer gibt gültiges "123Asdf.%" ein
    And Klick auf die Schaltflueche Login
    And Der Benutzer bestaetigt, dass er auf HomePageSD ist


  @cardBody
  Scenario: TC_05_01 Die Abonnementinformationskarte im Abonnementmodul muss angezeigt werden.

    When Klicken Sie in der Seitenleiste auf das Modul „Meine Abonnements“.
    Then Es wird überprüft, ob die Abonnementkarte angezeigt wird.

  @subscriberName
  Scenario: TC_05_02 Es wird überprüft, ob der Abonnentenname anhand der Abonnementinformationen im Abonnementmodul test ist.

    When Klicken Sie in der Seitenleiste auf das Modul „Meine Abonnements“.
    When Klicken Sie auf die Abonnementkarte
    Then Es wird überprüft,  ob der Name Subscriber der Benutzername ist.

  @subscriberType
  Scenario: TC_05_03 Es wird bestätigt, dass es sich um eine Gastmitgliedschaft handelt.

    When Klicken Sie in der Seitenleiste auf das Modul „Meine Abonnements“.
    When Klicken Sie auf die Abonnementkarte
    Then Es wird überprüft,  ob Subscription Type Guest Membership ist

  @subscriberTo
  Scenario: TC_05_04 Es wird bestätigt, dass es sich um Subscribes To Quaspareparts Gateway App handelt

    When Klicken Sie in der Seitenleiste auf das Modul „Meine Abonnements“.
    When Klicken Sie auf die Abonnementkarte
    Then Es wird überprüft,  ob Subscribes To Quaspareparts Gateway App ist

  @subscriberID
  Scenario: TC_05_05 Abonnement-ID aus den Abonnementinformationen im Abonnementmodul, es ist als 5b04d78b-da49-412a-ac3e-01530b416817 verifiziert.

    When Klicken Sie in der Seitenleiste auf das Modul „Meine Abonnements“.
    When Klicken Sie auf die Abonnementkarte
    Then Stellen Sie sicher, dass die Subscription ID lautet