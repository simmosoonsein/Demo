@Search @Demo
Feature: Search for an exercise

  Scenario Outline: Search for specific exercise and verifies the result for <Test Case>
    Given user opens web browser with Gymwolf page
    When user clicks on "Exercises and plans" menu
    Then "Exercises list" page will be displayed
    When user clicks on "Workout plans" tab
    Then popular workout plans are displayed
    When user enters <Search criteria> and clicks on Search button
    Then workout plans for entered search criteria are displayed
    Examples: TestData[name=Exercises and plans; filter=[Scenario=Search exercise]]
      | Test Case            | Search criteria |
      | Search legs exercise | legs            |
