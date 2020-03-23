package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import page_objects.RegistrationPage;

public class RegistrationSteps {


//==========================================general declarations==========================================\\
    RegistrationPage regPage = new RegistrationPage();
//==========================================Test Preconditions==========================================\

    @Given("The user has navigated to My Account Page")
    public void theUserHasNavigatedToMyAccountPage() {

        regPage.navigateToRegistrationPage();
      }

    @Then("The user sees the correct MyAccount page title")
    public void theUserSeesTheCorrectPageTitle() {

       regPage.checkMyAccountPageTitle();
    }
//==========================================New Scenario==========================================\
    @When("The user scrolls down the page")
    public void theUserScrollsDownThePage() {

        regPage.scrollWindow(regPage.registerButton);
    }
//------------------------------------------------------------
    @Then("The user should see the Registration form")
    public void theUserShouldSeeTheRegistrationForm() {

        regPage.checkRegistrationForm();
    }
//====================================================================================\
    @And("^The user should see the Register button$")
    public void theUserShouldSeeTheRegisterButton() {

        regPage.registerButtonShouldBeSeen();
    }
//====================================================================================\
    @Given("User enters personal details:")
    public void userEntersPersonalDetailsInRegForm(DataTable table ) {

       regPage.userEntersPersonalDetailsInRegForm(table);
    }
//------------------------------------------------------------
    @When("^The Register Button is clicked$")
    public void theRegisterButtonIsClicked() {

        regPage.registerButtonIsClicked();
    }
//====================================================================================\
    @Then("^The user should see the (.*) error$")
    public void userShouldSeeRegistrationError(String error) {

        regPage.checkRegistrationError(error);
    }
//====================================================================================\
    @Then("^The user should see the (.*) password warning$")
    public void theUserShouldSeePasswordWarning(String warning) {

        regPage.checkPasswordWarning(warning);
    }
//====================================================================================\
    @And("^The Register button should not be clickable$")
    public void theRegisterButtonShouldNotBeClickable() {

        regPage.registerButtonShouldNotBeClickable();
    }
    @And("^The Register button should be clickable$")
    public void theRegisterButtonShouldBeClickable() {

        regPage.registerButtonShouldBeClickable();
    }

    @But("^The browser should close$")
    public void browserShouldClose() {

       regPage.endBrowserSession();
    }

    @But("^The window is closed$")
    public void windowIsClosed() throws InterruptedException {

        regPage.endWindowSession();
    }

    @Given("^Privacy policy link is clicked$")
    public void privacyPolicyLinkIsClicked() {

       regPage.clickPrivacyPolicyLink();
    }

    @Then("The user should see the privacy policy page in new tab")
    public void theUserShouldSeeThePrivacyPolicyPageInNewTab() {

        regPage.checkPrivacyPolicyPage();
    }
//====================================================================================\

//====================================================================================\

}
