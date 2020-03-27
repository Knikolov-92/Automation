package page_objects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class RegistrationPage extends BasePage {

    public final static String MY_ACCOUNT_URL = "https://shop.demoqa.com/my-account/";

//==========================================WebElements(locators)==========================================\

    @FindBy(how = How.CSS, using = "[method='post'].woocommerce-form.woocommerce-form-register.register")
    public WebElement registerForm;

    @FindBy(how = How.CSS, using = "label[for='reg_username']")
    public WebElement regUsernameLabel;

    @FindBy(how = How.ID, using = "reg_username")
    public WebElement regUsernameField;

    @FindBy(how = How.CSS, using = "label[for='reg_email']")
    public WebElement regEmailLabel;

    @FindBy(how = How.ID, using = "reg_email")
    public WebElement regEmailField;

    @FindBy(how = How.CSS, using = "label[for='reg_password']")
    public WebElement regPasswordLabel;

    @FindBy(how = How.ID, using = "reg_password")
    public WebElement regPasswordField;

    @FindBy(how = How.CSS, using = "[type='submit'][name='register'][value='Register']")
    public WebElement registerButton;

    @FindBy(how = How.CSS, using = "div.woocommerce-notices-wrapper ul.woocommerce-error[role='alert']")
    public WebElement regInvalidInputErrorMessage;

    @FindBy(how = How.CSS, using = "div.woocommerce-password-strength")
    public WebElement regPasswordWarning;

    @FindBy(how = How.CLASS_NAME, using = "woocommerce-password-hint")
    public WebElement regPasswordHint;

    @FindBy(how = How.CSS, using = ".woocommerce-privacy-policy-text")
    public WebElement privacyPolicy;

    @FindBy(how = How.CSS, using = ".woocommerce-privacy-policy-link")
    public WebElement privacyPolicyLink;

    @FindBy(how = How.CLASS_NAME, using = "button-404")
    public WebElement returnToHome404button;

    @FindBy(how = How.CSS, using = "p.login.message")
    public WebElement regSuccessMessage;

    @FindBy(how = How.CSS, using = "#loginform[name='loginform']")
    public WebElement regSuccessLoginForm;

    @FindBy(how = How.CSS, using = "#wp-submit[name='wp-submit']")
    public WebElement regSuccessLoginButton;

    @FindBy(how = How.CSS, using = "p#backtoblog")
    public WebElement regSuccessBackToSiteLink;

//====================================================================================\
//Navigate to https://shop.demoqa.com/my-account/ and initialize web elements on page
    public void navigateToMyAccountPage() {

        BasePage.initializeBrowser();
    }

    public void initRegistrationElements() {

        PageFactory.initElements(driver, this);
    }
//====================================================================================\
    //Check AccountPage Title
    public void checkMyAccountPageTitle() {

        String expectedPageTitle = "My Account – ToolsQA Demo Site";
        Assert.assertEquals(driver.getTitle(), expectedPageTitle);
    }
//====================================================================================\
    //click on register button
    public void registerButtonIsClicked() throws InterruptedException {

        registerButton.click();
        Thread.sleep(3000);
    }
//====================================================================================\
    //Check Registration Form is displayed with all the elements
    public void checkRegistrationForm() {

        String regPolicyText = "Your personal data will be used to support your experience";
        WebElement[] elementsArray = {
                registerForm,
                regUsernameLabel, regUsernameField,
                regEmailLabel, regEmailField,
                regPasswordLabel, regPasswordField,
                registerButton, privacyPolicy,
                };
//------------------------------------------------------------
        for (int n = 0; n < elementsArray.length; n++) {

            Assert.assertTrue(elementsArray[n].isDisplayed());

            if (elementsArray[n] == privacyPolicy) {

                Assert.assertTrue(elementsArray[n].getText().contains(regPolicyText));
            }
        }
    }
//====================================================================================\
    //check whether the Register Button is enabled
    public void checkRegisterButtonIsClickable(String clickable) {

        switch (clickable) {
            case "yes":
                Assert.assertTrue(registerButton.isEnabled() );
                break;

            case "no":
                Assert.assertFalse(registerButton.isEnabled() );
                break;

            default:
                System.out.println("No option is selected, skipping check for ButtonIsClickable");
        }
    }
//====================================================================================\
    //check whether the Password Hint is displayed
    public void checkPasswordHintDisplayed(String displayed) {

        switch (displayed) {

            case "yes":
                Assert.assertTrue(regPasswordHint.isDisplayed() );
                break;

            case "no":
                //Assert.assertFalse(regPasswordHint.isDisplayed() );
                Assert.assertEquals(0, driver.findElements(By.className("woocommerce-password-hint")).size() );
                //Assert.assertNull(regPasswordHint);
                break;

            default:
                System.out.println("No option is selected, skipping check for PasswordHintIsDisplayed");
        }
    }
//====================================================================================\
    //enter username, email and password in Registration form
    public void userEntersPersonalDetailsInRegForm( DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);


        if (data.get(0).get("username") != null) {

                regUsernameField.sendKeys(data.get(0).get("username"));
        }
        Thread.sleep(1000);

        if  (data.get(0).get("email") != null) {

                regEmailField.sendKeys(data.get(0).get("email") );
        }
        Thread.sleep(1000);

        if  (data.get(0).get("password") != null) {

                regPasswordField.sendKeys(data.get(0).get("password") );
        }
        Thread.sleep(1000);
    }
//====================================================================================\
    //check for correct error text upon invalid registration input submitted
    public void checkRegistrationErrorMessage(String expectedErrorText) {

        Assert.assertTrue(regInvalidInputErrorMessage.isDisplayed() );
        Assert.assertEquals(regInvalidInputErrorMessage.getText(), expectedErrorText);
    }
//====================================================================================\
    //check password warning when password is being typed in the password field
    public void checkPasswordWarning(String expectedWarningText) {

        Actions actions = new Actions(driver);
        //actions added temporarily to test this kind of warning/note
        actions.doubleClick(regPasswordField).perform();
        actions.doubleClick(regUsernameField).perform();
        actions.doubleClick(regPasswordField).perform();

        Assert.assertTrue(regPasswordWarning.isDisplayed() );
        Assert.assertEquals(regPasswordWarning.getText(), expectedWarningText);
    }
//====================================================================================\
    //find and click privacy policy link in the registration form
    public void clickPrivacyPolicyLink() throws InterruptedException {

        privacyPolicyLink.click();
        Thread.sleep(5000);
    }
//====================================================================================\
    //check privacy policy page(currently not existing) is opened when privacy policy link is clicked
    public void checkPrivacyPolicyPage() {

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        String expectedPolicyURL = "https://shop.demoqa.com/?page_id=3";
        String expectedPolicyTitle = "Page not found – ToolsQA Demo Site";
        String expectedReturnButtonText = "return to home page";

        //switch to the new tab and do checks there
        driver.switchTo().window(newTab.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), expectedPolicyURL);
        Assert.assertEquals(driver.getTitle(), expectedPolicyTitle);
        Assert.assertTrue(returnToHome404button.isDisplayed() );
        Assert.assertTrue(returnToHome404button.getText().equalsIgnoreCase(expectedReturnButtonText) );
    }
//====================================================================================\
    //enter valid username, email and password to test successful registration
    public void UserEntersValidRandomizedPersonalDetails(DataTable dataTable ) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String randomizedUsername;
        String randomizedEmail;
        String randomizedPassword;

        randomizedUsername = (data.get(0).get("username")) + UUID.randomUUID().toString();
        System.out.println("Username used is:" +randomizedUsername);

        regUsernameField.sendKeys(randomizedUsername);
        Thread.sleep(1000);

        randomizedEmail = (data.get(0).get("email")) + UUID.randomUUID().toString() + "@example.com";
        System.out.println("Email used is:" +randomizedEmail);

        regEmailField.sendKeys(randomizedEmail);
        Thread.sleep(1000);

        randomizedPassword = (data.get(0).get("password")) + UUID.randomUUID().toString();
        System.out.println("Password used is:" +randomizedPassword);

        regPasswordField.sendKeys(randomizedPassword);
        Thread.sleep(1000);

    }
//====================================================================================\
    //check that after successful registration, user is redirected to the correct page
    public void checkSuccessfulRegistrationPageIsDisplayed(){

        String expectedURL = BasePage.properties.getProperty("myAccountURL");
        String actualURL = driver.getCurrentUrl();
        String expectedSuccessMessage = "Your session has expired because it has been over 60 minutes since your last login. Please log back in to continue.";
        String expectedBackToSiteLinkText = "← Back to ToolsQA Demo Site";

        Assert.assertNotEquals(actualURL, expectedURL);
        Assert.assertTrue(regSuccessMessage.isDisplayed() );
        Assert.assertTrue(regSuccessLoginForm.isDisplayed() );
        Assert.assertTrue(regSuccessLoginButton.isDisplayed() );
        Assert.assertTrue(regSuccessBackToSiteLink.isDisplayed() );

        Assert.assertEquals(regSuccessMessage.getText(), expectedSuccessMessage);
        Assert.assertEquals(regSuccessBackToSiteLink.getText(), expectedBackToSiteLinkText);
    }
//====================================================================================\
    //check that when user is on the redirected page after successful registration, user can go back to default page
    public void clickBackToSiteLinkAfterRegistering() throws InterruptedException {

        regSuccessBackToSiteLink.click();
        Thread.sleep(3000);
    }
//====================================================================================\
    //check that defaultURL is the current one
    public void checkDefaultURLIsCorrect(){

        String expectedDefaultURL = BasePage.properties.getProperty("baseURL");
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedDefaultURL);
    }
//====================================================================================\
}