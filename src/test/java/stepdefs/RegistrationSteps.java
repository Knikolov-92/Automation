package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import page_objects.BasePage;
import page_objects.RegistrationPage;
import static page_objects.RegistrationPage.MY_ACCOUNT_URL;


public class RegistrationSteps {


//==========================================general declarations==========================================\\
    private RegistrationPage regPage = new RegistrationPage();
    private BasePage basePage = new BasePage();
//==========================================Test Preconditions==========================================\

    @Given("^The user has navigated to the Registration Page$")
    public void userNavigatesToRegistrationPage() throws InterruptedException {

        regPage.navigateToMyAccountPage();
        basePage.navigateToURL(MY_ACCOUNT_URL);
        regPage.initRegistrationElements();
      }

    @Then("^The user sees the correct Registration page title$")
    public void checkTheCorrectRegistrationPageTitle() {

       regPage.checkMyAccountPageTitle();
    }
//==========================================Scenario Methods==========================================\
    @Given("^User enters personal details to register:$")
    public void userEntersPersonalDetailsInRegForm(DataTable userInfo ) throws InterruptedException {

        regPage.userEntersPersonalDetailsInRegForm(userInfo);
    }
//====================================================================================\
    @Given("^Privacy policy link is clicked$")
    public void privacyPolicyLinkIsClicked() throws InterruptedException {

        regPage.clickPrivacyPolicyLink();
    }
//====================================================================================\
    @When("^User enters valid, randomized personal details:$")
    public void userEntersValidRandomizedPersonalDetails(DataTable dataTable) throws InterruptedException {

        regPage.UserEntersValidRandomizedPersonalDetails(dataTable);
    }
//====================================================================================\
    @When("^The user scrolls down the Registration page$")
    public void userScrollsTheRegistrationPage() throws InterruptedException {

        basePage.scrollWindow(regPage.registerButton);
    }
//====================================================================================\
    @When("^BackToSite link is clicked$")
    public void backToSiteLinkIsClicked() throws InterruptedException {

        regPage.clickBackToSiteLinkAfterRegistering();
    }
//====================================================================================\
    @When("^The Register Button is clicked$")
    public void theRegisterButtonIsClicked() throws InterruptedException {

        regPage.registerButtonIsClicked();
    }
//====================================================================================\
    @Then("^The user should see the Registration form$")
    public void userSeesTheRegistrationForm() {

        regPage.checkRegistrationForm();
    }
//====================================================================================\
    @Then("^The user should see the Register button$")
    public void checkTheRegisterButtonIsDisplayed() {

        basePage.checkWebElementIsDisplayed(regPage.registerButton);
    }
//====================================================================================\
    @Then("^The user should see the privacy policy page in new tab$")
    public void checkPrivacyPolicyPageIsDisplayed() {

        regPage.checkPrivacyPolicyPage();
    }
//====================================================================================\
    @Then("^Registration error message with text \"([^\"]*)\" should be displayed$")
    public void registrationErrorMessageIsDisplayed(String errorText) {

        regPage.checkRegistrationErrorMessage(errorText);
    }
//====================================================================================\
    @Then("^The Register button should be enabled: \"([^\"]*)\"$")
    public void checkTheRegisterButtonIsClickable(String buttonClickable) {

        regPage.checkRegisterButtonIsClickable(buttonClickable);
    }
//====================================================================================\
    @Then("^Warning message with text \"([^\"]*)\" should be displayed$")
    public void checkPasswordWarningIsDisplayed(String warningText) {

        regPage.checkPasswordWarning(warningText);
    }
//====================================================================================\
    @Then("^The Password Hint should be displayed: \"([^\"]*)\"$")
    public void checkPasswordHintIsDisplayed(String hintDisplayed) {

        regPage.checkPasswordHintDisplayed(hintDisplayed);
    }
//====================================================================================\
    @Then("^The successful registration page should be displayed$")
    public void theSuccessfulRegistrationPageShouldBeDisplayed() {

        regPage.checkSuccessfulRegistrationPageIsDisplayed();
    }

    @Then("^User should be on correct default URL$")
    public void userShouldBeOnCorrectDefaultURL() {

        regPage.checkDefaultURLIsCorrect();
    }

//====================================================================================\
}
