# language: en

Feature: Main page
@001
  Scenario: Main page

    When Open GoogleChrome and go to site

    * user checks title of Main page
    * user checks text AliradarBest on Main page
    * user waits
    * user checks Useful Category on Main page
    * user clicks to useful category Instruments
    * user waits
    * user checks title on Instruments page
    * user clicks back
    * user waits
    Then user clicks to Install button

    Then user logs out