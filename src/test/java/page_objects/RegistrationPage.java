package page_objects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import java.util.List;
import java.util.Map;

public class RegistrationPage {

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

//====================================================================================\
    public void userEntersPersonalDetailsInRegForm( DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        if (data.get(0).get("username").isEmpty() ) {
            regUsernameField.clear();
        }else{
            regUsernameField.sendKeys(data.get(0).get("username"));
        }

        if (data.get(0).get("email").isEmpty() ) {
            regEmailField.clear();
        }else{
            regEmailField.sendKeys(data.get(0).get("email") );
        }

        if (data.get(0).get("password").isEmpty()) {
            regPasswordField.clear();
        }else{
            regPasswordField.sendKeys(data.get(0).get("password") );
        }
    }
//====================================================================================\
    public void registerButtonShouldBeSeen() {

        Assert.assertTrue(registerButton.isDisplayed() );
    }
//====================================================================================\
    public void registerButtonIsClicked() {

        registerButton.click();
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
    public void registerButtonShouldBeClickable() {

        Assert.assertTrue(registerButton.isEnabled() );
    }
    public void registerButtonShouldNotBeClickable() {

        Assert.assertFalse(registerButton.isEnabled() );
    }
//====================================================================================\
    public void checkPasswordWarning(String inputText) {

        String expectedWarningText = "";

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
}