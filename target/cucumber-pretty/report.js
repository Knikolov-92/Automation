$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/registration.feature");
formatter.feature({
  "name": "Registration Form",
  "description": "Description: As a user, I want to be able to register on site, so that I can use its features",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Unsuccessful Registration",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DebugTest"
    }
  ]
});
formatter.step({
  "name": "User enters personal details:",
  "keyword": "Given ",
  "rows": [
    {
      "cells": [
        "username",
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "\u003cusername\u003e",
        "\u003cemail\u003e",
        "\u003cpassword\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "The Register Button is clicked",
  "keyword": "When "
});
formatter.step({
  "name": "Error message with text \"\u003cerror_message\u003e\" should be displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "The user should see the Register button",
  "keyword": "And "
});
formatter.step({
  "name": "The browser should close",
  "keyword": "But "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "email",
        "password",
        "error_message"
      ]
    },
    {
      "cells": [
        "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890",
        "validTestEmail+\u003d1@example.com",
        "AbcdefgHIJK",
        "Error: Username may not be longer than 60 characters."
      ]
    }
  ]
});
formatter.background({
  "name": "The user is on My Account Page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "The user has navigated to My Account Page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.theUserNavigatesToMyAccountPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user scrolls down the page",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.theUserScrollsThePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user sees the correct MyAccount page title",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.checkTheCorrectMyAccountPageTitle()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Unsuccessful Registration",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DebugTest"
    }
  ]
});
formatter.step({
  "name": "User enters personal details:",
  "rows": [
    {},
    {}
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.theUserEntersPersonalDetailsInRegForm(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Register Button is clicked",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.theRegisterButtonIsClicked()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error message with text \"Error: Username may not be longer than 60 characters.\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.checkRegistrationErrorMessageIsDisplayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The user should see the Register button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.checkTheRegisterButtonIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The browser should close",
  "keyword": "But "
});
formatter.match({
  "location": "stepdefs.RegistrationSteps.browserIsClosed()"
});
formatter.result({
  "status": "passed"
});
});