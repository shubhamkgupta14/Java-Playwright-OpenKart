#Author: your.email@your.domain.com
@third
Feature: Third feature - Pass

  Scenario: Third - First Test
    Given Pass Step

  Scenario: Third - Second Test
    Given Pass Step

  @fail
  Scenario: Third - Third Test
    Given Fail Step

  Scenario: Third - Forth Test
    Given Pass Step

  @fail
  Scenario: Third - Fifth Test
    Given Fail Step

  Scenario: Third - Sixth Test
    Given Pass Step

  Scenario: Third - Seventh Test
    Given Pass Step
