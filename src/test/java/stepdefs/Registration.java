package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Registration {

    //==========================================general declarations==========================================\

    private static WebDriver driver;
    private static final String MyAccountURL = "https://shop.demoqa.com/my-account/";

//==========================================Test Preconditions==========================================\

    @Given("^The user has navigated to My Account Page$")
    public void theUserHasNavigatedToMyAccountPage() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MyAccountURL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
    }

    @Then("^The user should see the correct page title$")
    public void theUserShouldSeeTheCorrectPageTitle() {

        String expectedPageTitle = "My Account – ToolsQA Demo Site";

        assertEquals(driver.getTitle(), expectedPageTitle);
    }
//==========================================New Scenario==========================================\
    @When("^The user scrolls down the page$")
    public void theUserScrollsDownThePage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(1000);
        }
    }
//------------------------------------------------------------
    @Then("^The user should see the Registration form$")
    public void theUserShouldSeeTheRegistrationForm() throws Throwable {

        WebElement RegisterForm = driver.findElement(By.cssSelector("[method='post'].woocommerce-form.woocommerce-form-register.register") );
        WebElement UsernameLabel = driver.findElement(By.cssSelector("label[for='reg_username']") );
        WebElement UsernameField = driver.findElement(By.id("reg_username") );
        WebElement EmailLabel = driver.findElement(By.cssSelector("label[for='reg_email']") );
        WebElement EmailField = driver.findElement(By.id("reg_email") );
        WebElement PasswordLabel = driver.findElement(By.cssSelector("label[for='reg_password']") );
        WebElement PasswordField = driver.findElement(By.id("reg_password") );
        WebElement RegisterButton = driver.findElement(By.cssSelector("[type='submit'][name='register'][value='Register']") );

        WebElement[] elementsArray = {RegisterForm, UsernameLabel, UsernameField, EmailLabel, EmailField,
                PasswordLabel, PasswordField, RegisterButton};
//------------------------------------------------------------
       for (int n = 0; n < elementsArray.length; n++) {

           Assert.assertTrue(elementsArray[n].isDisplayed());
       }

        Thread.sleep(2000);
        driver.quit();
    }
//==========================================New Scenario==========================================\
    @Given("User enters personal details\\(invalid username):")
       public void userEntersPersonalDetailsInRegForm( DataTable dataTable) {

        List <Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        WebElement UsernameField = driver.findElement(By.id("reg_username") );
        WebElement EmailField = driver.findElement(By.id("reg_email") );
        WebElement PasswordField = driver.findElement(By.id("reg_password") );

        UsernameField.sendKeys(data.get(0).get("username") );
        EmailField.sendKeys(data.get(0).get("email") );
        PasswordField.sendKeys(data.get(0).get("password") );
    }
//------------------------------------------------------------
    @When("The Register Button is clicked")
    public void theRegisterButtonIsClicked() {

        WebElement RegisterButton = driver.findElement(By.cssSelector("[type='submit'][name='register'][value='Register']") );
        RegisterButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
//------------------------------------------------------------
    @Then("The user should see the InvalidUsername error")
    public void theUserShouldSeeTheInvalidUsernameError() {

        String expectedErrorText = "Error: Please enter a valid account username.";
        WebElement InvalidUsernameError = driver.findElement((By.cssSelector("div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']") ) );

        Assert.assertTrue(InvalidUsernameError.isDisplayed() );
        Assert.assertEquals(InvalidUsernameError.getText(), expectedErrorText);
    }
//------------------------------------------------------------
    @And("The user should see the Register button")
    public void theUserShouldSeeTheRegisterButton() {

        WebElement RegisterButton = driver.findElement(By.cssSelector("[type='submit'][name='register'][value='Register']") );
        Assert.assertTrue(RegisterButton.isDisplayed() );

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.quit();
    }
//==========================================New Scenario==========================================\

}
