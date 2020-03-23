package page_objects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RegistrationPage extends BasePage {

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
    public WebElement regInvalidInputRegError;

    @FindBy(how = How.CSS, using = "div.woocommerce-password-strength.short[aria-live='polite']")
    public WebElement regPasswordWarningVeryWeak;

    @FindBy(how = How.CSS, using = "div.woocommerce-password-strength.bad[aria-live='polite']")
    public WebElement regPasswordWarningWeak;

    @FindBy(how = How.CSS, using = "div.woocommerce-password-strength.good[aria-live='polite']")
    public WebElement regPasswordWarningMedium;

    @FindBy(how = How.CSS, using = "div.woocommerce-password-strength.strong[aria-live='polite']")
    public WebElement regPasswordWarningStrong;

    @FindBy(how = How.CSS, using = ".woocommerce-privacy-policy-text")
    public WebElement privacyPolicy;

    @FindBy(how = How.CSS, using = ".woocommerce-privacy-policy-link")
    public WebElement privacyPolicyLink;

    @FindBy(how = How.CLASS_NAME, using = "button-404")
    public WebElement returnToHome404button;

//====================================================================================\
//Navigate to https://shop.demoqa.com/my-account/ and initialize web elements on page
    public void navigateToRegistrationPage() {

        BasePage.initializeBrowser("myAccountURL");
        PageFactory.initElements(driver, this);
    }
//====================================================================================\
    //Check AccountPage Title
    public void checkMyAccountPageTitle() {

        String expectedPageTitle = "My Account – ToolsQA Demo Site";
        Assert.assertEquals(driver.getTitle(), expectedPageTitle);
    }
//====================================================================================\
    public void registerButtonShouldBeSeen() {

        Assert.assertTrue(registerButton.isDisplayed() );
    }
//====================================================================================\
    public void registerButtonIsClicked() {

        registerButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
//====================================================================================\
    public void scrollWindow(WebElement elementToScrollTo) {

        //This will scroll the page until an element is found:
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToScrollTo);
        actions.perform();

        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }
//====================================================================================\
    public void registerButtonShouldBeClickable() {

        Assert.assertTrue(registerButton.isEnabled() );
    }
//====================================================================================\
    public void registerButtonShouldNotBeClickable() {

        Assert.assertFalse(registerButton.isEnabled() );
    }
//====================================================================================\
    public void userEntersPersonalDetailsInRegForm( DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

            if (data.get(0).get("username").isEmpty() ) {
                regUsernameField.clear();
            }else{
                regUsernameField.sendKeys(data.get(0).get("username"));
            }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            if (data.get(0).get("email").isEmpty() ) {
                regEmailField.clear();
            }else{
                regEmailField.sendKeys(data.get(0).get("email") );
            }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            if (data.get(0).get("password").isEmpty()) {
                regPasswordField.clear();
            }else{
                regPasswordField.sendKeys(data.get(0).get("password") );
            }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
//====================================================================================\
    public void checkRegistrationError(String errorText) {

        String expectedErrorText = "";

        switch ( errorText ){
            case "InvalidUsername":
                expectedErrorText = "Error: Please enter a valid account username.";
                break;

            case "InvalidEmail":
                expectedErrorText = "Error: Please provide a valid email address.";
                break;

            case "UsernameAlreadyTaken":
                expectedErrorText = "Error: An account is already registered with that username. Please choose another.";
                break;

            case "EmailAlreadyTaken":
                expectedErrorText = "Error: An account is already registered with your email address. Please log in.";
                break;
        }
        Assert.assertTrue(regInvalidInputRegError.isDisplayed() );
        Assert.assertEquals(regInvalidInputRegError.getText(), expectedErrorText);
    }
//====================================================================================\
    public void checkPasswordWarning(String inputText) {

        Actions actions = new Actions(driver);
        String expectedWarningText = "";

        //actions added temporarily to test this kind of warning/note
        actions.doubleClick(regPasswordField).perform();
        actions.doubleClick(regUsernameField).perform();
        actions.doubleClick(regPasswordField).perform();

        switch ( inputText ){
            case "VeryWeak":
                expectedWarningText = "Very weak - Please enter a stronger password.";

                Assert.assertTrue(regPasswordWarningVeryWeak.isDisplayed() );
                Assert.assertEquals(regPasswordWarningVeryWeak.getText(), expectedWarningText);
                break;

            case "Weak":
                expectedWarningText = "Weak - Please enter a stronger password.";

                Assert.assertTrue(regPasswordWarningWeak.isDisplayed() );
                Assert.assertEquals(regPasswordWarningWeak.getText(), expectedWarningText);
                break;

            case "Medium":
                expectedWarningText = "Medium";

                Assert.assertTrue(regPasswordWarningMedium.isDisplayed() );
                Assert.assertEquals(regPasswordWarningMedium.getText(), expectedWarningText);
                break;

            case "Strong":
                expectedWarningText = "Strong";

                Assert.assertTrue(regPasswordWarningStrong.isDisplayed() );
                Assert.assertEquals(regPasswordWarningStrong.getText(), expectedWarningText);
                break;
        }
    }
//====================================================================================\
    public void clickPrivacyPolicyLink() {

        privacyPolicyLink.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
//====================================================================================\
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
    public void endWindowSession() throws InterruptedException {

        //switch 1st tab(if others are open - close them first)
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if (tabs.size()  > 1)
        {
            for(int iCount = 2; iCount <= tabs.size(); iCount++){

                driver.close();
                Thread.sleep(3);
            }
        }
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(1000);
    }
//====================================================================================\
    public void endBrowserSession(){
        driver.quit();
    }
//====================================================================================\
}