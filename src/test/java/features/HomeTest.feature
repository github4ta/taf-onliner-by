Feature: Test cases for onliner

  Scenario: User can open Home page
    When User opens Home page
    Then Home page is opened


  Scenario: User can open Autobaraholka page
    Given User is on the Home page
    When User clicks Autobaraholaka link
    Then Autobaraholka page is opened


  Scenario: User can open Catalog page
    Given User is on the Home page
    When User clicks Catalog link
    Then Catalog page is opened


  Scenario: User can open Realty page
    Given User is on the Home page
    When User clicks Realty link
    Then Realty page is opened


  Scenario: User can open Baraholka page
    Given User is on the Home page
    When User clicks Baraholka link
    Then User is on Baraholka page

