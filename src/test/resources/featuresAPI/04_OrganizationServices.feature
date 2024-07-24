@Api @Modul04 @Regression
Feature:Get Organization Service

#  Background: Get User Info
#    Given set the url for User Info
#    When send get request User Info
#    And get the user info information

  Scenario:M04_TC_01_02_03 Get Organization Service Scenario (uuid)
  (Die erstellten „Organisation“-Informationen und alle Benutzer in den mit dieser „Organisation“ verbundenen Modulen werden als Liste zurückgegeben.)
    Given Einstellen url für Organization Service
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Organization Service
    Then Der Statuscode 200 wird bestätigt für Organization Service
    And Der Name wird bestätigt für Organization Service
    And Der Benutzername des ersten Elements von user_list wird bestätigt.

  Scenario:M04_TC_04_05_06_07 Get Organization Service Scenario (summary)
  (Es werden zusammenfassende Informationen über die erstellte „Organisation“ und die Benutzer in den mit dieser „Organisation“ verbundenen Modulen zurückgegeben.)
    Given Einstellen url für Organization Service(summary)
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Organization Service(summary)
    Then Der Statuscode 200 wird bestätigt für Organization Service(summary)
    And Die founder_id info wird bestätigt für Organization Service(summary)
    And Der Name des ersten Elements von group_types wird bestätigt für Organization Service(summary)
    And Es wurde bestätigt, dass die Informationen „Name“ nicht „Beyza“ sind.

  Scenario:M04_TC_08 Get Organization Service Scenario (summary-Negativ)
  (In den Modulen, die mit der nicht erstellten „Organisation“ verbunden sind, werden keine Informationen zurückgegeben.)
    Given Einstellen url für Organization Service(summary-Negativ)
    When Der Benutzer sendet eine Anfrage mit der GET-Methode für Organization Service(summary-Negativ)
    Then Der Statuscode 403 wird bestätigt für Organization Service(summary-Negativ)





