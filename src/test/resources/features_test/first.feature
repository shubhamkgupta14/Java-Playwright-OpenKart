#Author: your.email@your.domain.com
@first
Feature: First feature - Pass

  Scenario: First - First Test
    Given Pass Step

  Scenario: First - Second Test
    Given Pass Step

  @fail
  Scenario: First - Third Test
    Given Fail Step

  Scenario: First - Forth Test
    Given Pass Step

  @fail
  Scenario: First - Fifth Test
    Given Fail Step