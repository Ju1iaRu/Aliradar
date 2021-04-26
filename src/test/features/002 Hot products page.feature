# language: en

Feature: Hot products page
@002
  Scenario: Hot products page

    When Open GoogleChrome and go to site

    * user clicks to Hot Products on header
    * user waits
    * user checks title on Hot Products page
    * user counts Hot items

    Then user logs out