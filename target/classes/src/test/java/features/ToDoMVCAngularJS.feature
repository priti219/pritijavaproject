Feature: ToDoMVCAngularJS

  Background:
    Given I am on ToDoMVC page
    When I click on AngularJS
    Then AngularJS page should be displayed

  Scenario: Add a ToDo Item
    Given I am on AngularJS page
    When I enter something in the ToDo text box
    Then a ToDo item should be added