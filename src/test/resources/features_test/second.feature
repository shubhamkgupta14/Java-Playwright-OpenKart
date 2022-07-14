#Author: your.email@your.domain.com
@second
Feature: Second feature - Pass

  Scenario: Second - First Test
    Given Pass Step

  Scenario: Second - Second Test
    Given Pass Step

  @fail
  Scenario: Second - Third Test
    Given Fail Step

  Scenario: Second - Forth Test
    Given Pass Step

  @fail
  Scenario: Second - Fifth Test
    Given Fail Step

  @fail
  Scenario: Second - Sixth Test
    Given Fail Step
