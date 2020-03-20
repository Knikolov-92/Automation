package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import page_objects.RegistrationPage;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class RegistrationSteps {

//==========================================general declarations==========================================\\
    private RegistrationPage regPage = new RegistrationPage();
    private static WebDriver driver;
    private static final String MyAccountURL = "https://shop.demoqa.com/my-account/";

//==========================================Test Preconditions==========================================\

    @Given("The user has navigated to My Account Page")
    public void theUserHasNavigatedToMyAccountPage() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MyAccountURL);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        regPage = PageFactory.initElements(driver, RegistrationPage.class);
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
                regPage.registerForm,
                regPage.regUsernameLabel,regPage.regUsernameField,
                regPage.regEmailLabel,regPage.regEmailField,
                regPage.regPasswordLabel,regPage.regPasswordField,
                regPage.registerButton,
        };
//------------------------------------------------------------
       for (int n = 0; n < elementsArray.length; n++) {

           Assert.assertTrue(elementsArray[n].isDisplayed());
       }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
//====================================================================================\
    @And("^The user should see the Register button$")
    public void theUserShouldSeeTheRegisterButton() {

        regPage.registerButtonShouldBeSeen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
//====================================================================================\
    @Given("User enters personal details:")
    public void userEntersPersonalDetailsInRegForm(DataTable table ) {

       regPage.userEntersPersonalDetailsInRegForm(table);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
//------------------------------------------------------------
    @When("^The Register Button is clicked$")
    public void theRegisterButtonIsClicked() {

        regPage.registerButtonIsClicked();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
//====================================================================================\
    @Then("^The user should see the (.*) error$")
    public void userShouldSeeRegistrationError(String error) {

        regPage.checkRegistrationError(error);
    }
//====================================================================================\
    @Then("^The user should see the (.*) password warning$")
    public void theUserShouldSeePasswordWarning(String warning) {

        Actions actions = new Actions(driver);
        actions.doubleClick(regPage.regPasswordField).perform();
        actions.doubleClick(regPage.regUsernameField).perform();
        actions.doubleClick(regPage.regPasswordField).perform();

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
        driver.quit();
    }


//====================================================================================\

//====================================================================================\

}
