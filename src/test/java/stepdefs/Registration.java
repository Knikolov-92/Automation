package stepdefs;

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

import java.util.concurrent.TimeUnit;

public class Registration {

    private static WebDriver driver;
    String baseURL = "https://shop.demoqa.com/";
    String MyAccountURL = "https://shop.demoqa.com/my-account/";

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

    @Then("^The user should be on the correct URL$")
    public void theUserShouldBeOnTheCorrectURL() {

        String expectedURL = "https://shop.demoqa.com/my-account/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


    @When("^The user scrolls down the page$")
    public void theUserScrollsDownThePage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 4; i++) {
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(2000);
        }
    }

    @Then("^The user should see the Registration form$")
    public void theUserShouldSeeTheRegistrationForm() throws Throwable {

        WebElement RegisterForm = driver.findElement(By.cssSelector("[method='post'].woocommerce-form.woocommerce-form-register.register"));
        WebElement UsernameLabel = driver.findElement(By.cssSelector("label[for='reg_username']"));
        WebElement UsernameField = driver.findElement(By.id("reg_username"));
        WebElement EmailLabel = driver.findElement(By.cssSelector("label[for='reg_email']"));
        WebElement EmailField = driver.findElement(By.id("reg_email"));
        WebElement PasswordLabel = driver.findElement(By.cssSelector("label[for='reg_password']"));
        WebElement PasswordField = driver.findElement(By.id("reg_password"));
        WebElement RegisterButton = driver.findElement(By.cssSelector("[type='submit'][name='register'][value='Register']"));
//------------------------------------------------------------
        if (RegisterForm.isDisplayed() )
        {
            System.out.println("Register form is displayed");
        }else
        {
            System.out.println("Register form is NOT displayed");
        }
//------------------------------------------------------------
        if (UsernameLabel.isDisplayed() )
        {
            System.out.println("Username label is displayed");
        }else
        {
            System.out.println("Username label is NOT displayed");
        }
//------------------------------------------------------------
        if (UsernameField.isDisplayed() )
        {
            System.out.println("Username field is displayed");
        }else
        {
            System.out.println("Username field is NOT displayed");
        }
//------------------------------------------------------------
        if (EmailLabel.isDisplayed() )
        {
            System.out.println("Email label is displayed");
        }else
        {
            System.out.println("Email label is NOT displayed");
        }
//------------------------------------------------------------
        if (EmailField.isDisplayed() )
        {
            System.out.println("Email field is displayed");
        }else
        {
            System.out.println("Email field is NOT displayed");
        }
//------------------------------------------------------------
        if (PasswordLabel.isDisplayed() )
        {
            System.out.println("Password label is displayed");
        }else
        {
            System.out.println("Password label is NOT displayed");
        }
//------------------------------------------------------------
        if (PasswordField.isDisplayed() )
        {
            System.out.println("Password field is displayed");
        }else
        {
            System.out.println("Password field is NOT displayed");
        }
//------------------------------------------------------------
        if (RegisterButton.isDisplayed() )
        {
            System.out.println("Register button field is displayed");
        }else
        {
            System.out.println("Register button field is NOT displayed");
        }

        Thread.sleep(2000);
        driver.quit();
    }


//================================================================================\\
/**
    @Then("The user should see the Register label")
    public void theUserShouldSeeTheRegisterLabel() {
        driver.quit();
    }

    @And("The user should see the Username field")
    public void theUserShouldSeeTheUsernameField() {
        driver.quit();
    }

    @And("The user should see the Email-address field")
    public void theUserShouldSeeTheEmailAddressField() {
        driver.quit();
    }

    @And("The user should see the password field")
    public void theUserShouldSeeThePasswordField() {
        driver.quit();
    }

    @And("The user should see the Register button")
    public void theUserShouldSeeTheRegisterButton() {
        driver.quit();
    }
//================================================================================\\
    @Given("Invalid Username is entered in Username field")
    public void invalidUsernameIsEnteredInUsernameField() {
        driver.quit();
    }

    @And("Valid email is entered in Email field")
    public void validEmailIsEnteredInEmailField() {
        driver.quit();
    }

    @And("Valid password is entered in Password field")
    public void validPasswordIsEnteredInPasswordField() {
        driver.quit();
    }

    @When("The Register Button is clicked")
    public void theRegisterButtonIsClicked() {
        driver.quit();
    }

    @Then("The user should see the InvalidUsername error")
    public void theUserShouldSeeTheInvalidUsernameError() {
        driver.quit();
    }

    @And("The user should still see the Register button")
    public void theUserShouldStillSeeTheRegisterButton() {
        driver.quit();
    }
//================================================================================\\
    @Given("Empty Username is entered in Username field")
    public void emptyUsernameIsEnteredInUsernameField() {
        driver.quit();
    }

    @Given("Valid Username is entered in Username field")
    public void validUsernameIsEnteredInUsernameField() {
        driver.quit();
    }

    @And("Invalid email is entered in Email field")
    public void invalidEmailIsEnteredInEmailField() {
        driver.quit();
    }

    @Then("The user should see the InvalidEmail error")
    public void theUserShouldSeeTheInvalidEmailError() {
        driver.quit();
    }
//================================================================================\\
    @And("Empty email is entered in Email field")
    public void emptyEmailIsEnteredInEmailField() {
        driver.quit();
    }

    @And("Invalid password is entered in Password field")
    public void invalidPasswordIsEnteredInPasswordField() {
        driver.quit();
    }

    @Then("The user should see the InvalidPassword error")
    public void theUserShouldSeeTheInvalidPasswordError() {
        driver.quit();
    }
//================================================================================\\
    @And("Empty password is entered in Password field")
    public void emptyPasswordIsEnteredInPasswordField() {
        driver.quit();
    }
//================================================================================\\
    @And("Username entered in Username field is already used")
    public void usernameEnteredInUsernameFieldIsAlreadyUsed() {
        driver.quit();
    }

    @Then("The user should see the AlreadyRegisteredUsername error")
    public void theUserShouldSeeTheAlreadyRegisteredUsernameError() {
        driver.quit();
    }
//================================================================================\\
    @And("Email entered in Email field is already used")
    public void emailEnteredInEmailFieldIsAlreadyUsed() {
        driver.quit();
    }

    @Then("The user should see the AlreadyRegisteredEmail error")
    public void theUserShouldSeeTheAlreadyRegisteredEmailError() {
        driver.quit();
    }
//================================================================================\\
    @When("Weak password is entered in Password field")
    public void weakPasswordIsEnteredInPasswordField() {
        driver.quit();
    }

    @Then("The user should see the WeakPassword error")
    public void theUserShouldSeeTheWeakPasswordError() {
        driver.quit();
    }

    @And("The Register button should not be clickable")
    public void theRegisterButtonShouldNotBeClickable() {
        driver.quit();
    }
//================================================================================\\
    @When("Very weak password is entered in Password field")
    public void veryWeakPasswordIsEnteredInPasswordField() {
        driver.quit();
    }

    @Then("The user should see the VeryWeakPassword error")
    public void theUserShouldSeeTheVeryWeakPasswordError() {
        driver.quit();
    }
//================================================================================\\
    @When("Medium password is entered in Password field")
    public void mediumPasswordIsEnteredInPasswordField() {
        driver.quit();
    }

    @Then("The user should see the MediumPassword note")
    public void theUserShouldSeeTheMediumPasswordNote() {
        driver.quit();
    }

    @And("The Register button should be clickable")
    public void theRegisterButtonShouldBeClickable() {
        driver.quit();
    }
//================================================================================\\
    @When("Strong password is entered in Password field")
    public void strongPasswordIsEnteredInPasswordField() {
        driver.quit();
    }

    @Then("The user should see the StrongPassword note")
    public void theUserShouldSeeTheStrongPasswordNote() {
        driver.quit();
    }
//================================================================================\\
    @Then("The user should see the Successful-Registration-Message")
    public void theUserShouldSeeTheSuccessfulRegistrationMessage() {
        driver.quit();
    }
    */
}
