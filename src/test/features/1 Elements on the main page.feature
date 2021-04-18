# language: en

Feature: Main page
@001
  Scenario: Main page

    When Open GoogleChrome and go to site
    * user checks title of Main page
    * user waits
    * user checks text AliradarBest of Main page
    Then user click to Install button
    Then user logs out