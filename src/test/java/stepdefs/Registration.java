package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.UtilRegPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Registration {

//==========================================general declarations==========================================\\
    private UtilRegPage regPage = new UtilRegPage();
    private static WebDriver driver;
    private static final String MyAccountURL = "https://shop.demoqa.com/my-account/";
    private String expectedErrorText;
//==========================================Test Preconditions==========================================\

    @Given("The user has navigated to My Account Page")
    public void theUserHasNavigatedToMyAccountPage() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MyAccountURL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        regPage = PageFactory.initElements(driver, UtilRegPage.class);
      }

    @Then("The user should see the correct page title")
    public void theUserShouldSeeTheCorrectPageTitle() {

        String expectedPageTitle = "My Account – ToolsQA Demo Site";

        assertEquals(driver.getTitle(), expectedPageTitle);
    }
//==========================================New Scenario==========================================\
    @When("The user scrolls down the page")
    public void theUserScrollsDownThePage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(500);
        }
    }
//------------------------------------------------------------
    @Then("The user should see the Registration form")
    public void theUserShouldSeeTheRegistrationForm() {

        WebElement[] elementsArray = {
                regPage.RegisterForm,
                regPage.RegUsernameLabel,regPage.RegUsernameField,
                regPage.RegEmailLabel,regPage.RegEmailField,
                regPage.RegPasswordLabel,regPage.RegPasswordField,
                regPage.RegisterButton,
        };
//------------------------------------------------------------
        for (int n = 0; n < elementsArray.length; n++) {

           Assert.assertTrue(elementsArray[n].isDisplayed());
       }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }
//==========================================New Scenario==========================================\
    @Given("User enters personal details:")
    public void userEntersPersonalDetailsInRegForm(DataTable table ) {

       regPage.userEntersPersonalDetailsInRegForm(table);
    }
//------------------------------------------------------------
    @When("The Register Button is clicked")
    public void theRegisterButtonIsClicked() {

        regPage.RegisterButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
//------------------------------------------------------------
    @Then("The user should see the InvalidUsername error")
    public void theUserShouldSeeTheInvalidUsernameError() {

        expectedErrorText = "Error: Please enter a valid account username.";
        Assert.assertTrue(regPage.RegInvalidUsernameError.isDisplayed() );
        Assert.assertEquals(regPage.RegInvalidUsernameError.getText(), expectedErrorText);
    }
//------------------------------------------------------------
    @And("The user should see the Register button")
    public void theUserShouldSeeTheRegisterButton() {

        regPage.UserShouldSeeTheRegisterButton();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }
//==========================================New Scenario==========================================\
    @Then("The user should see the InvalidEmail error")
    public void theUserShouldSeeTheInvalidEmailError() {

        expectedErrorText = "Error: Please provide a valid email address.";
        Assert.assertTrue(regPage.RegInvalidEmailError.isDisplayed() );
        Assert.assertEquals(regPage.RegInvalidEmailError.getText(), expectedErrorText);
    }
//==========================================New Scenario==========================================\
    @Then("The user should see the UsernameAlreadyTaken error")
    public void theUserShouldSeeTheUsernameAlreadyTakenError() {

    expectedErrorText = "Error: An account is already registered with that username. Please choose another.";
    Assert.assertTrue(regPage.UsernameAlreadyTakenError.isDisplayed() );
    Assert.assertEquals(regPage.UsernameAlreadyTakenError.getText(), expectedErrorText);
    }
//==========================================New Scenario==========================================\
    @Then("The user should see the EmailAlreadyTaken error")
    public void theUserShouldSeeTheEmailAlreadyTakenError() {

        expectedErrorText = "Error: An account is already registered with your email address. Please log in.";
        Assert.assertTrue(regPage.EmailAlreadyTakenError.isDisplayed() );
        Assert.assertEquals(regPage.EmailAlreadyTakenError.getText(), expectedErrorText);
    }
//==========================================New Scenario==========================================\
}
