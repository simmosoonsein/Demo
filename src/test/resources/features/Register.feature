@Register @Demo
Feature: Register e-mail

  Scenario Outline: Enter e-mail to registration form for <Test Case>
    Given user opens web browser with Gymwolf page
    When user clicks on "Start free" button
    Then user enters <e-mail> as e-mail
    When user clicks "Register" button
    Then main page for logged in user is displayed
    And notification to check confirmation e-mail on user mailbox is displayed
    Examples: TestData[name=Registration; filter=[Scenario=Register new e-mail]]
      | Test Case            | e-mail              |
      | Register test e-mail | testmail@google.com |
