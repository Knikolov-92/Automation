package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import page_objects.BasePage;
import page_objects.RegistrationPage;

public class RegistrationSteps {


//==========================================general declarations==========================================\\
    RegistrationPage regPage = new RegistrationPage();
    BasePage basePage = new BasePage();
//==========================================Test Preconditions==========================================\

    @Given("^The user has navigated to My Account Page$")
    public void theUserNavigatesToMyAccountPage() {

        regPage.navigateToRegistrationPage();
      }

    @Then("^The user sees the correct MyAccount page title$")
    public void checkTheCorrectMyAccountPageTitle() {

       regPage.checkMyAccountPageTitle();
    }
//==========================================Scenario Methods==========================================\
    @When("^The user scrolls down the page$")
    public void theUserScrollsThePage() throws InterruptedException {

        basePage.scrollWindow(regPage.registerButton);
    }
//====================================================================================\
    @Then("^The user should see the Registration form$")
    public void checkTheRegistrationFormIsDisplayed() throws InterruptedException {

        regPage.checkRegistrationForm();
    }
//====================================================================================\
    @And("^The user should see the Register button$")
    public void checkTheRegisterButtonIsDisplayed() {

        regPage.checkRegisterButtonIsDisplayed();
    }
//====================================================================================\
    @Given("^User enters personal details:$")
    public void theUserEntersPersonalDetailsInRegForm(DataTable table ) throws InterruptedException {

       regPage.userEntersPersonalDetailsInRegForm(table);
    }
//====================================================================================\
    @When("^The Register Button is clicked$")
    public void theRegisterButtonIsClicked() throws InterruptedException {

        regPage.registerButtonIsClicked();
    }
//====================================================================================\
    @But("^The browser should close$")
    public void browserIsClosed() {

        basePage.endBrowserSession();
    }
//====================================================================================\
    @But("^The window is closed$")
    public void windowIsClosed() throws InterruptedException {

        basePage.endWindowSession();
    }
//====================================================================================\
    @Given("^Privacy policy link is clicked$")
    public void privacyPolicyLinkIsClicked() throws InterruptedException {

       regPage.clickPrivacyPolicyLink();
    }
//====================================================================================\
    @Then("^The user should see the privacy policy page in new tab$")
    public void checkPrivacyPolicyPageIsDisplayed() {

        regPage.checkPrivacyPolicyPage();
    }
//====================================================================================\
    @Then("^Error message with text \"([^\"]*)\" should be displayed$")
    public void checkRegistrationErrorMessageIsDisplayed(String errorText) {

        regPage.checkRegistrationError(errorText);
    }
//====================================================================================\
    @And("^The Register button should be enabled: \"([^\"]*)\"$")
    public void checkTheRegisterButtonIsClickable(String buttonClickable) {

        regPage.checkRegisterButtonIsClickable(buttonClickable);
    }
//====================================================================================\
    @Then("^Warning message with text \"([^\"]*)\" should be displayed$")
    public void checkPasswordWarningIsDisplayed(String warningText) {

        regPage.checkPasswordWarning(warningText);
    }
//====================================================================================\
    @And("^The Password Hint should be displayed: \"([^\"]*)\"$")
    public void checkPasswordHintIsDisplayed(String hintDisplayed) {

        regPage.checkPasswordHintDisplayed(hintDisplayed);
    }
//====================================================================================\
    @Given("^User enters valid, randomized personal details:$")
    public void theUserEntersValidRandomizedPersonalDetails(DataTable dataTable) throws InterruptedException {

        regPage.UserEntersValidRandomizedPersonalDetails(dataTable);
    }
//====================================================================================\
    @Then("^The successful registration page should be displayed$")
    public void theSuccessfulRegistrationPageShouldBeDisplayed() {

        regPage.checkSuccessfulRegistrationPageIsDisplayed();
    }
//====================================================================================\
    @When("^BackToSite link is clicked$")
    public void backToSiteLinkIsClicked() throws InterruptedException {

        regPage.clickBackToSiteLinkAfterRegistering();
    }

    @Then("^User should be on correct default URL$")
    public void userShouldBeOnCorrectDefaultURL() {

        regPage.checkDefaultURLIsCorrect();
    }
//====================================================================================\

}
