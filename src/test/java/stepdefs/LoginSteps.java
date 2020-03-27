package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.BasePage;
import page_objects.LoginPage;
import page_objects.RegistrationPage;

import static page_objects.RegistrationPage.MY_ACCOUNT_URL;

public class LoginSteps {

    private RegistrationPage regPage = new RegistrationPage();
    private BasePage basePage = new BasePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^The user has navigated to the Login Page$")
    public void userNavigatesToLoginPage() throws InterruptedException {

        regPage.navigateToMyAccountPage();
        basePage.navigateToURL(MY_ACCOUNT_URL);
        loginPage.initLoginElements();
    }

    @Given("User enters personal details to login:")
    public void userEntersPersonalDetailsInLoginForm(DataTable userInfo) throws InterruptedException {

        loginPage.userEntersPersonalDetailsInLoginForm(userInfo);
    }

    @When("^The user scrolls down the Login page$")
    public void userScrollsTheLoginPage() throws InterruptedException {

        basePage.scrollWindow(loginPage.loginLostPasswordLink);
    }

    @When("^The Login Button is clicked$")
    public void theLoginButtonIsClicked() throws InterruptedException {

        loginPage.loginButtonIsClicked();
    }

    @Then("^The user sees the correct Login page title$")
    public void checkTheCorrectLoginPageTitle() {

        regPage.checkMyAccountPageTitle();
    }


    @Then("^The user should see the Login form$")
    public void userSeesTheLoginForm() {

        loginPage.checkLoginForm();
    }

    @Then("^Login error message with text \"([^\"]*)\" should be displayed$")
    public void loginErrorMessageWithTextShouldBeDisplayed(String errorText) {

        loginPage.checkLoginErrorMessage(errorText);
    }

    @Then("^The user should see the Login button$")
    public void userSeesTheLoginButton() {

        basePage.checkWebElementIsDisplayed(loginPage.loginButton);
    }
}
